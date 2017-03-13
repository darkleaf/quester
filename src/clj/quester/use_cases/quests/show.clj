(ns quester.use-cases.quests.show
  (:require [quester.use-cases.protocols.queries :as queries]))

(defn use-case [ctx id]
  (let [quest-page (queries/find-quest-page ctx id)]
    {:quest-page quest-page}))
