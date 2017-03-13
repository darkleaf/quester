(ns quester.use-cases.protocols.queries)

(defprotocol GetCompnaiesCards
  (-get-companies-cards [_ limit]))
(defn get-companies-cards [ctx & {:keys [limit]}]
  (-get-companies-cards ctx limit))

(defprotocol GetBestQuestsCards
  (-get-best-quests-cards [_ limit]))
(defn get-best-quests-cards [ctx & {:keys [limit]}]
  (-get-best-quests-cards ctx limit))

(defprotocol GetNewQuestsCards
  (-get-new-quests-cards [_ limit]))
(defn get-new-quests-cards [ctx & {:keys [limit]}]
  (-get-new-quests-cards ctx limit))

(defprotocol GetSelectionsCards
  (-get-selections-cards [_ limit]))
(defn get-selections-cards [ctx & {:keys [limit]}]
  (-get-new-quests-cards ctx limit))

(defprotocol GetReviewsCards
  (-get-reviews-cards [_ limit]))
(defn get-reviews-cards [ctx & {:keys [limit]}]
  (-get-reviews-cards ctx limit))

(defprotocol FindQuestPage
  (-find-quest-page [_ id]))
(defn find-quest-page [ctx id]
  (-find-quest-page ctx id))
