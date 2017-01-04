;;(in-ns boot.user)

(ns user
 (:require [mount.core :as mount]
           [clojure.spec :as s]
           [quester.deps.db]
           [quester.deps.use-cases]
           [quester.web-server]))

(s/check-asserts true)

(defn start []
  (mount/start))

(defn stop []
  (mount/stop))

(defn restart []
  (stop)
  (start))
