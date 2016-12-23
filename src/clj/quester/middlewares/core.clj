(ns quester.middlewares.core
  (:require [ring.util.response :refer [charset]]))

(defn middleware [handler]
  (fn [req]
    (let [resp (handler req)]
      (charset resp "UTF-8"))))
