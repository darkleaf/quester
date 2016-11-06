(ns quester.web-server
  (:require [mount.core :refer [defstate]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "33qqq Hello World"})

(defstate web-server
  :start (run-jetty #'handler {:port 3000, :join? false})
  :stop (.stop web-server))
