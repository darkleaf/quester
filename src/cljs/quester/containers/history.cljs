(ns quester.containers.history
  (:require [pushy.core :as pushy]
            [darkleaf.router :as router]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [quester.routes.web :as web-routes]
            [quester.react :refer [e] :as r]
            [quester.containers.state :as state])
  (:require-macros [cljs.core.async.macros :refer [go]]))

;; TODO: cancel and progress

(defn- blank-component []
  (e "div" nil "loading"))

(def container
  (r/create-class
   :displayName "History"

   :matcher
   (fn [this uri]
     (let [req {:uri uri, :request-method :get}
           handler (.. this -handler)]
       (handler req)))

   :dispatch
   (fn [this {:keys [component-var req]}]
     (let [initial-data (.. this -initialData)
           component @component-var]
       (if initial-data
         (do
           (js-delete this "initialData")
           (.setState this #js{:component component :data initial-data}))
         (go
           (let [req (assoc-in req [:headers "accept"] "application/transit+json")
                 response (<! (http/request req))
                 data (:body response)]
             ;; #js not work here
             (.setState this (js-obj "component" component, "data" data)))))))

   :getInitialState
   (fn [_this] #js{:component blank-component, :data {}})

   :componentWillMount
    (fn [this]
      (aset this "handler" (router/make-handler web-routes/routes))
      (aset this "initialData" (.. this -props -initialData))
      (let [matcher (.. this -matcher)
            dispatch (.. this -dispatch)
            history (pushy/pushy dispatch matcher)]
        (aset this "history" history)
        (pushy/start! history)))

    :componentWillUnmount
    (fn [this]
      (pushy/stop! (.-history this)))

    :render
    (fn [this]
      (let [component (.. this -state -component)
            data (.. this -state -data)]
        (e js/ui.IntlProvider #js{:locale "ru", :messages js/ui.messages}
           (e state/container #js{:data data}
              (e component)))))))
