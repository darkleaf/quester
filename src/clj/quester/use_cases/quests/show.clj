(ns quester.use-cases.quests.show
  (:require [clojure.spec :as s]
            [quester.projections.quest :as quest-projection]))

(defn use-case [{:keys [find-quest-page]} id]
  (let [quest-page (s/assert ::quest-projection/page (find-quest-page id))]
    {:quest-page quest-page}))
