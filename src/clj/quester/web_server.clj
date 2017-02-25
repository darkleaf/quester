(ns quester.web-server
  (:require [mount.core :refer [defstate]]
            [ring.adapter.jetty :refer [run-jetty]]
            [darkleaf.router :as r]
            [quester.routes.core :as routes]
            [ring.middleware.file :refer [wrap-file]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.content-type :refer [wrap-content-type]]
            [ring.middleware.not-modified :refer [wrap-not-modified]]
            [quester.util.container :as container]
            [quester.deps :as deps]))

(defn wrap-deps [handler]
  (fn [req]
    (-> req
        (assoc :deps-registry deps/registry)
        (handler))))

(defn build-handler []
  (-> (r/make-handler (routes/build-routes))
      (wrap-resource "public")
      (wrap-content-type)
      (wrap-not-modified)
      (wrap-deps)))

(defstate web-server
  :start (run-jetty (build-handler) {:port 3000, :join? false})
  :stop (.stop web-server))
