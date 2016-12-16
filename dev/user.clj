;;(in-ns boot.user)

(ns user)

(require '[mount.core]
         '[quester.container]
         '[quester.composition-root]
         '[quester.web-server])

(defn start []
  (mount.core/start))

(defn stop []
  (mount.core/stop))

(defn restart []
  (stop)
  (start))

(quester.composition-root/register-all)
