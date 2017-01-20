(ns quester.web-server
  (:require [mount.core :refer [defstate]]
            [ring.adapter.jetty :refer [run-jetty]]
            [darkleaf.router :as r]
            [quester.routes.core :refer [routes]]
            [ring.middleware.file :refer [wrap-file]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.not-modified :refer [wrap-not-modified]]
            [quester.util.container :as container]
            [quester.deps :as deps]))

(defn wrap-resolve [handler]
  (fn [req]
    (-> req
        (assoc :resolve #(container/resolve deps/registry %))
        (handler))))

(def handler (-> (r/make-handler routes)
                 (wrap-resource "public")
                 (wrap-content-type)
                 (wrap-not-modified)
                 (wrap-resolve)))

(defstate web-server
  :start (run-jetty handler {:port 3000, :join? false})
  :stop (.stop web-server))
