(ns quester.deps.db
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [quester.container :as c]

            ;; for stubs
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(def selections
  (->> (s/gen ::selection/spec)
       (gen/sample)
       (take 10)))

(def quests
  (->> (s/gen ::quest/spec)
       (gen/sample)
       (take 10)))

(def reviews
  (->> (s/gen ::review/spec)
       (gen/sample)
       (take 10)))

(def companies
  (->> (s/gen ::company/spec)
       (gen/sample)
       (take 10)))

(def selection->card identity)
(def quest->card identity)
(def review->card identity)
(def company->card identity)

(c/register :db/best-quests-cards
            (fn [_]
              (constantly (->> quests
                               (take-nth 2)
                               (quest->card)))))

(c/register :db/new-quests-cards
            (fn [_]
              (constantly (->> quests
                               (rest)
                               (take-nth 2)
                               (quest->card)))))

(c/register :db/selections-cards
            (fn [_]
              (constantly (->> selections
                               (selection->card)))))

(c/register :db/reviews-cards
            (fn [_]
              (constantly (->> reviews
                               (review->card)))))

(c/register :db/companies-cards
            (fn [_]
              (constantly (->> companies
                               (company->card)))))
