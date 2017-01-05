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

(c/register :db/best-quests-cards
            (fn [_]
              (constantly (->> (s/gen ::quest-projection/card)
                               (gen/sample)
                               (take 10)))))

(c/register :db/new-quests-cards
            (fn [_]
              (constantly (->> (s/gen ::quest-projection/card)
                               (gen/sample)
                               (take 10)))))

(c/register :db/selections-cards
            (fn [_]
              (constantly (->> (s/gen ::selection/spec)
                               (gen/sample)
                               (take 10)))))

(c/register :db/reviews-cards
            (fn [_]
              (constantly (->> (s/gen ::review/spec)
                               (gen/sample)
                               (take 10)))))

(c/register :db/companies-cards
            (fn [_]
              (constantly (->> (s/gen ::company/spec)
                               (gen/sample)
                               (take 10)))))

(c/register :db/find-quest
            (fn [_]
              (fn [_uuid]
                1)))
