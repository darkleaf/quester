(ns quester.middlewares.core
  (:require [ring.util.response :refer [charset]]))

(defn wrap-charset [handler]
  (fn [req]
    (let [resp (handler req)]
      (charset resp "UTF-8"))))
