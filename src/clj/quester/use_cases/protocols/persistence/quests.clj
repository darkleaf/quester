(ns quester.use-cases.protocols.persistence.quests)

(defprotocol BestCards
  (-best-cards [_ limit]))

(defn best-cards [ctx & {:keys [limit]}]
  (-best-cards ctx limit))

(defprotocol NewCards
  (-new-cards [_ limit]))

(defn new-cards [ctx & {:keys [limit]}]
  (-new-cards ctx limit))
