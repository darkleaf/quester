(ns quester.containers.history
  (:require [reagent.core :as r]
            [pushy.core :as pushy]
            [darkleaf.router :as router]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [quester.routes.web :as web-routes]
            [quester.ui :as ui])
  (:require-macros [cljs.core.async.macros :refer [go]]))


;; TODO: cancel and progress

(defn- blank-component []
  [:div "loading"])

(defn container [initial-data]
  (let [use-initial? (atom (some? initial-data))
        state (r/atom {:component blank-component, :data {}})
        handler (router/make-handler web-routes/routes)
        matcher (fn [uri]
                  (let [req {:uri uri, :request-method :get}]
                    (handler req)))
        dispatch (fn [{:keys [component-var req]}]
                  (let [component @component-var]
                    (if @use-initial?
                      (do
                        (reset! use-initial? false)
                        (reset! state {:component component, :data initial-data}))
                      (go
                        (let [req (assoc-in req [:headers "accept"] "application/transit+json")
                              response (<! (http/request req))
                              data (:body response)]
                          (reset! state {:component component, :data data}))))))
        history (pushy/pushy dispatch matcher)]
    (r/create-class
     {:display-name
      "History"

      :component-will-mount
      #(pushy/start! history)

      :component-will-unmount
      #(pushy/stop! history)

      :reagent-render
      (fn [_initial-data]
        [ui/wrapper
         [(:component @state) (r/cursor state [:data])]])})))
