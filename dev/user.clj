(ns user
  (:require [boot.core :refer :all]
            [mount.core]
            [quester.container]
            [quester.composition-root]
            [quester.web-server]))

(defn start []
  (quester.composition-root/register-all)
  (mount.core/start))

(defn stop []
  (quester.container/clear)
  (mount.core/stop))

(defn restart []
  (stop)
  (start))
