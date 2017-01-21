(ns quester.screen.components
  (:require [reagent.core :as r]
            [pushy.core :as pushy]
            [darkleaf.router :as router]
            [cljs.core.async :refer [<!]]
            [quester.routes.web :as web-routes]
            [quester.util.container :as c]
            [quester.screen.model :as model])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def ^:private handler (router/make-handler web-routes/routes))
(def ^:private request-for (router/make-request-for web-routes/routes))

(defn- matcher [uri]
  (let [req {:uri uri, :request-method :get}]
    (handler req)))

(defn history [screen-identity initial-state initial-deps]
  (let [initial-dispatch
        (fn [{:keys [component req]}]
          (let [deps initial-deps
                page (model/new-page :component component
                                     :state initial-state
                                     :deps deps
                                     :req req)]
            (swap! screen-identity model/replace-page page)))

        usual-dispatch
        (fn [{:keys [component req]}]
          (when (not= req (:req @screen-identity))
            (let [deps initial-deps
                  http-request (c/resolve deps :http/request)
                  api-req (assoc-in req [:headers "accept"] "application/transit+json")]
              (go
                (let [api-response (<! (http-request api-req))
                      state (:body api-response)
                      page (model/new-page :component component
                                           :state state
                                           :deps deps
                                           :req req)]
                  (swap! screen-identity model/replace-page page))))))

        dispatch
        (fn [router-resp]
          (if (empty? @screen-identity)
            (initial-dispatch router-resp)
            (usual-dispatch router-resp)))

        history
        (pushy/pushy dispatch matcher)]
    (r/create-class
     {:display-name
      "History"

      :component-will-mount
      #(pushy/start! history)

      :component-will-unmount
      #(pushy/stop! history)

      :reagent-render
      (fn [& _] [:div "history"])})))


(defn page [screen-identity]
  (prn @screen-identity)
  [:div "page"])

(defn screen [screen-identity initial-state initial-deps]
  [:div
   [history screen-identity initial-state initial-deps]
   [page screen-identity]])
