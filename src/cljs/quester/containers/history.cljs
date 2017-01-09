(ns quester.containers.history
  (:require [reagent.core :as r]
            [pushy.core :as pushy]
            [darkleaf.router :as router]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [quester.routes.web :as web-routes]
            [quester.ui :as ui]
            [quester.util.url-helpers :as url-helpers])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def ^:private handler (router/make-handler web-routes/routes))
(def ^:private request-for (router/make-request-for web-routes/routes))

(defn- matcher [uri]
  (let [req {:uri uri, :request-method :get}]
    (handler req)))

;; TODO: cancel and progress
(defn container [& {:keys [state initial-data]}]
  (let [initial-dispatch (fn [{:keys [component-var router-req]}]
                           (reset! state {:component-var component-var
                                          :data initial-data
                                          :router-req router-req}))
        usual-dispatch (fn [{:keys [component-var router-req]}]
                         (when (not= router-req (:router-req @state))
                           (go
                             (let [req (assoc-in router-req [:headers "accept"] "application/transit+json")
                                   response (<! (http/request req))
                                   data (:body response)]
                               (reset! state {:component-var component-var
                                              :data data
                                              :router-req router-req})))))
        dispatch (fn [router-resp]
                   (if (empty? @state)
                     (initial-dispatch router-resp)
                     (usual-dispatch router-resp)))
        history (pushy/pushy dispatch matcher)]
    (r/create-class
     {:display-name
      "History"

      :component-will-mount
      #(pushy/start! history)

      :component-will-unmount
      #(pushy/stop! history)

      :reagent-render
      (fn [& _]
        (let [component @(:component-var @state)
              data (r/cursor state [:data])]
          [url-helpers/provider request-for
           [ui/wrapper
            [component data]]]))})))
