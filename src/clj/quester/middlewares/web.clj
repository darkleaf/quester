(ns quester.middlewares.web
  (:require [cognitect.transit :as t]
            [ring.util.response :as r]
            [hiccup.page :as h]
            [quester.util.request-hash :refer [req->hash]])
  (:import [java.io ByteArrayOutputStream]))

(defn- data->transit [data]
  (let [out (ByteArrayOutputStream. 4096)
        writer (t/writer out :json)]
    (t/write writer data)
    (.toString out)))

(defn- data->html [data req]
  (h/html5
   [:head
    [:title "Quester"]
    [:style "body { margin: 0; }"]]
   [:body
    [:div#root]
    [:script#payload {:type "application/transit+json"}
     (data->transit {:req-hash (req->hash req)
                     :data data})]
    (h/include-js "/ui/bundle.js")
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
            (update :body data->html req)
            (r/content-type "text/html"))))))
