(ns quester.deps.db
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [quester.container :as c]

            ;; for stubs
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(c/register :db.quests/best-cards
            (fn [_resolve]
              (fn [& {:keys [limit]}]
                (->> (s/gen ::quest-projection/card)
                     (gen/sample)
                     (take limit)))))

(c/register :db.quests/new-cards
            (fn [_resolve]
              (fn [& {:keys [limit]}]
                (->> (s/gen ::quest-projection/card)
                     (gen/sample)
                     (take limit)))))

(c/register :db.selections/cards
            (fn [_resolve]
              (fn [& {:keys [limit]}]
                (->> (s/gen ::selection/spec)
                     (gen/sample)
                     (take limit)))))

(c/register :db.reviews/cards
            (fn [_resolve]
              (fn [& {:keys [limit]}]
                (->> (s/gen ::review/spec)
                     (gen/sample)
                     (take limit)))))

(c/register :db.companies/cards
            (fn [_resolve]
              (fn [& {:keys [limit]}]
                (->> (s/gen ::company/spec)
                     (gen/sample)
                     (take limit)))))

(c/register :db.quests/page
            (fn [_resolve]
              (fn [_uuid]
                (->> (s/gen ::quest-projection/page)
                     (gen/generate)))))
