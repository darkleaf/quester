(ns quester.middlewares.web
  (:require [cognitect.transit :as t]
            [ring.util.response :as r]
            [hiccup.page :as h])
  (:import [java.io ByteArrayOutputStream]))

(defn- data->transit [data]
  (let [out (ByteArrayOutputStream. 4096)
        writer (t/writer out :json)]
    (t/write writer data)
    (.toString out)))

(defn- data->html [data]
  (h/html5
   [:head
    [:title "Quester"]]
   [:body
    [:div#root]
    [:script
     "window.initData = "
     (data->transit data)]
    (h/include-js "/frontend/bundle.js")
    (h/include-js "/js/web.js")]))

(defn wrap-response-body [handler]
  (fn [req]
    (let [resp (handler req)]
      ;; добавить условие на success и проверять content-type запроса

      (-> resp
          #_(update :body data->transit)
          #_(r/content-type "application/transit+json")
          (update :body data->html)
          (r/content-type "text/html")))))
