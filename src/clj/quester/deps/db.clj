(ns quester.deps.db
  (:require [quester.container :as c]

            ;; for stubs
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(def selections
  [(selection/build {::selection/name "Перформансы"})
   (selection/build {::selection/name "Страшные"})
   (selection/build {::selection/name "Семейные"})
   (selection/build {::selection/name "Виртуальная реальность"})
   (selection/build {::selection/name "Крутые"})
   (selection/build {::selection/name "Для девочек"})])

(def quests
  [(quest/build {::quest/name "Гагарин"})
   (quest/build {::quest/name "Прометей"})
   (quest/build {::quest/name "Дядя Федор"})
   (quest/build {::quest/name "UT"})
   (quest/build {::quest/name "Барби"})
   (quest/build {::quest/name "Геннадий"})
   (quest/build {::quest/name "В гостях у Ктулху"})
   (quest/build {::quest/name "Кот Матроскин"})
   (quest/build {::quest/name "Чужой"})
   (quest/build {::quest/name "Хищник"})])

(def reviews
  [(review/build {::review/name "Выбираем самый технологичный квест"})
   (review/build {::review/name "Квесты для любителей побегать"})
   (review/build {::review/name "Куда сходить семье с ребенком"})
   (review/build {::review/name "Выбираем самый необычный квест"})
   (review/build {::review/name "Барби"})])

(def companies
  [(company/build {::company/name "Гагарин"})
   (company/build {::company/name "Прометей"})
   (company/build {::company/name "Дядя Федор"})
   (company/build {::company/name "UT"})
   (company/build {::company/name "Барби"})
   (company/build {::company/name "Барби2"})])

(def selection->card identity)
(def quest->card identity)
(def review->card identity)
(def company->card identity)

(c/register :db/best-quests-cards (fn [_]
                                    (constantly (->> quests
                                                     (random-sample 0.7)
                                                     (quest->card)))))

(c/register :db/new-quests-cards (fn [_]
                                   (constantly (->> quests
                                                    (random-sample 0.7)
                                                    (quest->card)))))

(c/register :db/selections-cards (fn [_]
                                   (constantly (->> selections
                                                    (selection->card)))))

(c/register :db/reviews-cards (fn [_]
                                (constantly (->> reviews
                                                 (review->card)))))

(c/register :db/companies-cards (fn [_]
                                  (constantly (->> companies
                                                   (company->card)))))
