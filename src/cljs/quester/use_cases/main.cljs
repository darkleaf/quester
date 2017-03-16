(ns quester.use-cases.main
  (:require
   [quester.use-cases.context :as context]))

(defprotocol Protocol
  (get-selections-cards [_])
  (get-reviews-cards [_])
  (get-best-quests-cards [_])
  (get-new-quests-cards [_])
  (get-companies-cards [_]))

(defrecord UseCase [ctx]
  Protocol
  (get-selections-cards [_]
    (-> ctx context/get-state :selections-cards))
  (get-reviews-cards [_]
    (-> ctx context/get-state :reviews-cards))
  (get-best-quests-cards [_]
    (-> ctx context/get-state :best-quests-cards))
  (get-new-quests-cards [_]
    (-> ctx context/get-state :new-quests-cards))
  (get-companies-cards [_]
    (-> ctx context/get-state :companies-cards)))

(defn use-case [ctx]
  (UseCase. ctx))
