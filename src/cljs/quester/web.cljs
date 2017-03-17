(ns quester.web
  (:require [quester.patches]
            [reagent.core :as reagent]
            [cognitect.transit :as t]
            [cljs-http.client :as http]
            [pushy.core :as pushy]
            [darkleaf.router :as r]
            [quester.routes.web :as web-routes]
            [quester.ui :as ui]
            [quester.use-cases.context :as use-cases.context]
            [cljs.core.async :refer [<!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(deftype Context [db]
  use-cases.context/Context
  (get-state [_] @db)
  (-update-state [_ args] (apply swap! db args))
  (request [_ req] (http/request req)))

(enable-console-print!)

(def mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json)]
    (t/read r text)))

(defonce initial-state-valid? (atom true))
(def initial-state (-> (.getElementById js/document "initial-data")
                       (.-innerHTML)
                       (read-transit)))

(defn wrap-render [handler]
  (fn [req]
    (let [element (handler req)]
      (reagent/render-component element mount-point))))

(defn fetch-state [req callback]
  (if @initial-state-valid?
    (do
      (reset! initial-state-valid? false)
      (callback initial-state))
    (let [api-req (assoc-in req [:headers "accept"] "application/transit+json")]
      (go
        (let [_ (ui/nprogress.start)
              api-response (<! (http/request api-req))
              _ (ui/nprogress.done)
              state (:body api-response)]
          (callback state))))))

(defn wrap-context [handler]
  (fn [req]
    (fetch-state req (fn [state]
                       (let [db (reagent/atom state)
                             ctx (Context. db)]
                         (handler (assoc req :quester/ctx ctx)))))))

(defn build-handler []
  (-> (r/make-handler (web-routes/build-routes))
      (wrap-render)
      (wrap-context)))

(defonce history (atom nil))

(defn restart []
  (when (some? @history)
    (pushy/stop! @history))
  (let [handler (build-handler)]
    (reset! history
            (pushy/pushy (constantly nil)
                         (fn [uri] (handler {:uri uri, :request-method :get})))))
  (pushy/start! @history))
