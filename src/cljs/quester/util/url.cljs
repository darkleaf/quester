(ns quester.util.url
  (:require [darkleaf.router :as router]
            [quester.routes.web :as web]))

(def ^:private request-for (router/make-request-for web/routes))

(defn url-for [& args]
  (let [req (apply request-for args)]
    (assert (= :get (:request-method req)))
    (assert (= #{:request-method :uri}  (-> req keys set)))
    (:uri req)))
