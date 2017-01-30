(ns quester.middlewares.web)

(defn middleware [handler]
  (fn [req]
    {:component (handler req)
     :req req}))
