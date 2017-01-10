(ns quester.deps.use-cases
  (:require [quester.container :as c]
            [quester.use-cases.welcome :as welcome]
            [quester.use-cases.quests.show :as quests-show]))

(defn register [registry]
  (c/register
   registry

   :use-cases/welcome
   (fn [resolve]
     (partial welcome/use-case
              {:select-selections-cards  (resolve :db.selections/cards)
               :select-best-quests-cards (resolve :db.quests/best-cards)
               :select-reviews-cards     (resolve :db.reviews/cards)
               :select-new-quests-cards  (resolve :db.quests/new-cards)
               :select-companies-cards   (resolve :db.companies/cards)}))

   :use-cases.quests/show
   (fn [resolve]
     (partial quests-show/use-case
              {:find-quest-page (resolve :db.quests/page)}))))
