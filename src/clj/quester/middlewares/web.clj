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
    [:title "Quester"]
    [:style "body { margin: 0; }"]]
   [:body
    [:div#root]
    [:script#initial-data {:type "application/transit+json"}
     (data->transit data)]
    #_(h/include-js "/ui/bundle.js")
    (h/include-js "/js/web.js")]))

(defn middleware [handler]
  (fn [req]
    (let [resp (handler req)
          accept (get-in req [:headers "accept"])]
      (if (= accept "application/transit+json")
        (-> resp
            (update :body data->transit)
            (r/content-type "application/transit+json"))
        (-> resp
            (update :body data->html)
            (r/content-type "text/html"))))))
