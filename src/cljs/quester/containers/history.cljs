(ns quester.containers.history
  (:require [pushy.core :as pushy]
            [darkleaf.router :as router]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [quester.routes.web :as web-routes]
            [quester.react :refer [e] :as r]
            [quester.util.request-cache :as cache]
            [quester.util.request-hash :refer [req->hash]]
            [quester.containers.state :as state]
            [quester.containers.root :as root])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def ^:private handler (router/make-handler web-routes/routes))

(defn- matcher [uri]
  (let [req {:uri uri, :request-method :get}]
     (handler req)))

(defn- handle [this {:keys [element req]}]
  (let [atom (.. this -props -atom)
        key (req->hash req)
        page-data (cache/get @atom key)]
    (if page-data
      (swap! atom assoc :element element, :page page-data)
      (go
        (let [req (assoc-in req [:headers "accept"] "application/transit+json")
              response (<! (http/request req))]
          (prn element)
          (swap! atom assoc :element element, :page (:body response)))))))

(def container
  (r/create-class
   :displayName "History"

   :componentWillMount
   (fn []
     (this-as this
       (let [history (pushy/pushy #(handle this %) matcher)]
         (aset this "history" history)
         (pushy/start! history))))

   :componentWillUnmount
   (fn []
     (this-as this
       (pushy/stop! (.-history this))))

   :render
   (fn []
     (this-as this
       (let [atom (.. this -props -atom)]
         (e "div" {}
             (e "a" {:href "/"} "main")
             (e "br" {})
             (e "a" {:href "/quests/1"} "quest 1")

             (e state/container {:atom atom}
                (e root/container {}))))))))
