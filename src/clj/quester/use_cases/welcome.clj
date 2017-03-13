(ns quester.use-cases.welcome
  (:require [quester.use-cases.protocols.queries :as queries]))

(defn use-case [ctx]
  {:new-quests-cards (queries/get-new-quests-cards ctx :limit 10)
   :best-quests-cards (queries/get-best-quests-cards ctx :limit 10)
   :companies-cards (queries/get-companies-cards ctx :limit 10)
   :selections-cards (queries/get-selections-cards ctx :limit 10)
   :reviews-cards (queries/get-reviews-cards ctx :limit 10)})
