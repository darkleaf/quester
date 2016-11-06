(ns user
  (:require [boot.core :refer :all]
            [mount.core]
            [quester.web-server]
            [quester.use-cases-deps.container]
            [quester.use-cases-deps.setup]))

(defn start []
  (quester.use-cases-deps.setup/setup)
  (mount.core/start))

(defn stop []
  (quester.use-cases-deps.container/clear)
  (mount.core/stop))
