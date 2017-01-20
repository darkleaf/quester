(ns quester.deps.db
  (:require [quester.util.container :as c]

            ;; for stubs
            [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(defn register [registry]
  (c/register
   registry

   :db.quests/best-cards
   (fn [_resolve]
     (fn [& {:keys [limit]}]
       (->> (s/gen ::quest-projection/card)
            (gen/sample)
            (take limit))))

   :db.quests/new-cards
   (fn [_resolve]
     (fn [& {:keys [limit]}]
       (->> (s/gen ::quest-projection/card)
            (gen/sample)
            (take limit))))

   :db.selections/cards
   (fn [_resolve]
     (fn [& {:keys [limit]}]
       (->> (s/gen ::selection/spec)
            (gen/sample)
            (take limit))))

   :db.reviews/cards
   (fn [_resolve]
     (fn [& {:keys [limit]}]
       (->> (s/gen ::review/spec)
            (gen/sample)
            (take limit))))

   :db.companies/cards
   (fn [_resolve]
     (fn [& {:keys [limit]}]
       (->> (s/gen ::company/spec)
            (gen/sample)
            (take limit))))

   :db.quests/page
   (fn [_resolve]
     (fn [_uuid]
       (->> (s/gen ::quest-projection/page)
            (gen/generate))))))
