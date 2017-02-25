(ns quester.deps.routing
  (:require [darkleaf.router :as router]
            [quester.util.container :as container]
            [quester.routes.web :as web-routes]))

;; TODO: move to separate ns
(defn- url-handler [handler uri]
  (let [req {:uri uri, :request-method :get}]
    (handler req)))

(defn- url-for [request-for & args]
  (let [req (apply request-for args)]
    (assert (= :get (:request-method req)))
    (assert (= #{:request-method :uri}  (-> req keys set)))
    (:uri req)))

(defn register [registry]
  ;; for cache
  (let [routes (web-routes/build-routes)
        handler (router/make-handler routes)
        request-for (router/make-request-for routes)]
    (container/register
     registry

     :routing/handler
     (fn [_] handler)

     :routing/request-for
     (fn [_] request-for)

     :routing/url-handler
     (fn [r]
       (partial url-handler (r :routing/handler)))

     :routing/url-for
     (fn [r]
       (partial url-for (r :routing/request-for))))))
