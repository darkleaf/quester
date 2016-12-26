;;(in-ns boot.user)

(ns user)

(require '[mount.core]
         '[quester.deps.db]
         '[quester.deps.use-cases]
         '[quester.web-server])

(defn start []
  (mount.core/start))

(defn stop []
  (mount.core/stop))

(defn restart []
  (stop)
  (start))
