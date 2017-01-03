(ns quester.middlewares.web)

(defn middleware [handler]
  (fn [req]
    {:element (handler req)
     :req req}))
