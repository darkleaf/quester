(ns quester.use-cases.welcome)

(defn perform [{:keys [selections best-quests reviews]}]
  {:selections (selections)
   :best-quests (best-quests)
   :reviews (reviews)})
