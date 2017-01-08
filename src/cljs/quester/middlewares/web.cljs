(ns quester.middlewares.web)

(defn middleware [handler]
  (fn [req]
    {:component-var (handler req)
     :req req}))
