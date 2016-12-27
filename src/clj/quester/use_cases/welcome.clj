(ns quester.use-cases.welcome)

(defn perform [{:keys [selections-cards
                       best-quests-cards
                       reviews-cards
                       new-quests-cards
                       companies-cards]}]
  {:selections-cards  (selections-cards)
   :best-quests-cards (best-quests-cards)
   :reviews-cards     (reviews-cards)
   :new-quests-cards  (new-quests-cards)
   :companies-cards   (companies-cards)})
