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

(def selections
  (->> (s/gen ::selection/spec)
       (gen/sample)
       (take 10)))

(def quests
  (->> (s/gen ::quest/spec)
       (gen/sample)
       (take 20)))

(def reviews
  (->> (s/gen ::review/spec)
       (gen/sample)
       (take 10)))

(def companies
  (->> (s/gen ::company/spec)
       (gen/sample)
       (take 10)))

(def selection->card identity)

(defn quest->card [q]
  (as-> q q
    (select-keys q
                 [::common/uuid
                  ::quest/name
                  ::quest/participants-min
                  ::quest/participants-max])
    (assoc q
           ::quest-projection/price-min 1000
           ::quest-projection/price-max 1500
           ::quest-projection/total-rating 9.342)
    (s/assert ::quest-projection/card q)))

(def review->card identity)
(def company->card identity)

(c/register :db/best-quests-cards
            (fn [_]
              (constantly (->> quests
                               (random-sample 0.5)
                               (map quest->card)))))

(c/register :db/new-quests-cards
            (fn [_]
              (constantly (->> quests
                               (random-sample 0.5)
                               (map quest->card)))))

(c/register :db/selections-cards
            (fn [_]
              (constantly (->> selections
                               (map selection->card)))))

(c/register :db/reviews-cards
            (fn [_]
              (constantly (->> reviews
                               (map review->card)))))

(c/register :db/companies-cards
            (fn [_]
              (constantly (->> companies
                               (map company->card)))))
