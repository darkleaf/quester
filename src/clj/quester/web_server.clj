(ns quester.web-server
  (:require [mount.core :refer [defstate]]
            [ring.adapter.jetty :refer [run-jetty]]
            [quester.routes.core :refer [handler]]))

(defstate web-server
  :start (run-jetty #'handler {:port 3000, :join? false})
  :stop (.stop web-server))
