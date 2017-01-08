(ns quester.use-cases.welcome)

(defn use-case [{:keys [select-selections-cards
                        select-best-quests-cards
                        select-reviews-cards
                        select-new-quests-cards
                        select-companies-cards]}]
  (let [selections-cards  (select-selections-cards :limit 10)
        best-quests-cards (select-best-quests-cards :limit 10)
        reviews-cards     (select-reviews-cards :limit 10)
        new-quests-cards  (select-new-quests-cards :limit 10)
        companies-cards   (select-companies-cards :limit 10)]



    {:selections-cards  selections-cards
     :best-quests-cards best-quests-cards
     :reviews-cards     reviews-cards
     :new-quests-cards  new-quests-cards
     :companies-cards   companies-cards}))
