(ns quester.middlewares.web
  (:require [cognitect.transit :as t]
            [ring.util.response :as r])
  (:import [java.io ByteArrayOutputStream]))

(defn- data->transit [data]
  (let [out (ByteArrayOutputStream. 4096)
        writer (t/writer out :json)]
    (t/write writer data)
    (.toString out)))

(defn wrap-response-body [handler]
  (fn [req]
    (let [resp (handler req)]
      ;; добавить условие на success и проверять content-type запроса
      (-> resp
          (update :body data->transit)
          (r/content-type "application/transit+json")))))
