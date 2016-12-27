(ns quester.use-cases.welcome)

(defn perform [{:keys [selections best-quests reviews new-quests companies]}]
  {:selections (selections)
   :best-quests (best-quests)
   :reviews (reviews)
   :new-quests (new-quests)
   :companies (companies)})
