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

(defn- handle-with-cache [this {:keys [element req]}]
  (let [atom (.. this -props -atom)
        key (req->hash req)]
    (when-let [page-data (cache/get @atom key)]
      (swap! atom assoc :element element, :page page-data))))

;; TODO: cancel and progress
(defn- handle-with-api [this {:keys [element req]}]
  (let [atom (.. this -props -atom)
        key (req->hash req)
        req (assoc-in req [:headers "accept"] "application/transit+json")]
    (go
      (let [response (<! (http/request req))]
        (swap! atom assoc :element element, :page (:body response))))))

(defn- handle [this req]
  (or (handle-with-cache this req)
      (handle-with-api this req)))

(def container
  (r/create-class
   :displayName "History"

   :componentWillMount
   (fn [this]
     (let [history (pushy/pushy #(handle this %) matcher)]
         (aset this "history" history)
         (pushy/start! history)))

   :componentWillUnmount
   (fn [this]
     (pushy/stop! (.-history this)))

   :render
   (fn [this]
     (let [atom (.. this -props -atom)]
         (e "div" {}
             (e "a" {:href "/"} "main")
             (e "br" {})
             (e "a" {:href "/quests/1"} "quest 1")

             (e state/container {:atom atom}
                (e root/container {})))))))
