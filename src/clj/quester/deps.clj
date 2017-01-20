(ns quester.deps
  (:require [mount.core :refer [defstate]]
            [quester.util.container :as container]
            [quester.deps.db :as db]
            [quester.deps.use-cases :as use-cases]))

(defstate registry
  :start (doto (container/build)
           (db/register)
           (use-cases/register)))
