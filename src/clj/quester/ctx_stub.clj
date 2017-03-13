(ns quester.ctx-stub
  (:require [quester.use-cases.protocols.queries :as queries]
            [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(deftype ContextStub []
  queries/GetBestQuestsCards
  (-get-best-quests-cards [_ limit]
    (->> (s/gen ::quest-projection/card)
         (gen/sample)
         (take limit)))

  queries/GetNewQuestsCards
  (-get-new-quests-cards [_ limit]
    (->> (s/gen ::quest-projection/card)
         (gen/sample)
         (take limit)))

  queries/GetSelectionsCards
  (-get-selections-cards [_ limit]
    (->> (s/gen ::selection/spec)
         (gen/sample)
         (take limit)))

  queries/GetReviewsCards
  (-get-reviews-cards [_ limit]
    (->> (s/gen ::review/spec)
         (gen/sample)
         (take limit)))

  queries/GetCompnaiesCards
  (-get-companies-cards [_ limit]
    (->> (s/gen ::company/spec)
         (gen/sample)
         (take limit)))

  queries/FindQuestPage
  (-find-quest-page [_ uuid]
    (->> (s/gen ::quest-projection/page)
         (gen/generate))))
