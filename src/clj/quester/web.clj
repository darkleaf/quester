(ns quester.web
 (:require [ring.adapter.jetty :refer [run-jetty]]
           [mount.core :refer [defstate] :as mount]
           [domkm.silk :as silk]
           [quester.web.common-routes :as common-routes]))

(def all-routes
  (silk/routes [common-routes/routes]))


;;TODO: add request-methods
(defmulti handler
  (fn [_ params]
    (if-let [params (silk/arrive all-routes)])))

(defn app-handler [req])

(defstate server
  :start (run-jetty app-handler {:port 3000 :join? false})
  :stop (.stop server))
