(ns quester.use-cases.quests.show
  (:require
   [quester.use-cases.context :as context]))

(defprotocol Protocol
  (get-quest-page [_]))

(defrecord UseCase [ctx]
  Protocol
  (get-quest-page [_]
    (-> ctx context/get-state :quest-page)))

(defn use-case [ctx]
  (UseCase. ctx))
