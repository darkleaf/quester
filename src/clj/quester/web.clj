(ns quester.web
 (:require [ring.adapter.jetty :refer [run-jetty]]
           [mount.core :refer [defstate] :as mount]))



(defn app-handler [req])

(defstate server
  :start (run-jetty app-handler {:port 3000 :join? false})
  :stop (.stop server))
