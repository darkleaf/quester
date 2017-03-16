(ns quester.middlewares.web
  (:require
   [darkleaf.router :as r]
   [quester.ui :as ui]
   [quester.components.context :as context]))

(defn- url-for [request-for & args]
  (let [req (apply request-for args)]
    (assert (= :get (:request-method req)))
    (:uri req)))

(defn wrap-wrapper [handler]
  (fn [req]
    [ui/wrapper
     (handler req)]))

(defn wrap-url-for [handler]
  (fn [req]
    (let [provider (context/provider :url-for)
          request-for (::r/request-for req)]
      [provider (partial url-for request-for)
       (handler req)])))

(def middleware (comp wrap-wrapper wrap-url-for))
