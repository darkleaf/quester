(ns quester.deps.db
  (:require [quester.container :as c]

            ;; for stubs
            [quester.entities.selection :as selection]
            [quester.entities.quest :as quest]
            [quester.entities.review :as review]
            [quester.entities.company :as company]))

(defn- main-selections-tmp-stub []
  [(selection/build {::selection/name "Перформансы"})
   (selection/build {::selection/name "Страшные"})
   (selection/build {::selection/name "Семейные"})
   (selection/build {::selection/name "Виртуальная реальность"})
   (selection/build {::selection/name "Крутые"})
   (selection/build {::selection/name "Для девочек"})])

(c/register :db/main-selections (fn [_] main-selections-tmp-stub))

(defn- main-best-quests-tmp-stub []
  [(quest/build {::quest/name "Гагарин"})
   (quest/build {::quest/name "Прометей"})
   (quest/build {::quest/name "Дядя Федор"})
   (quest/build {::quest/name "UT"})
   (quest/build {::quest/name "Барби"})])

(c/register :db/main-best-quests (fn [_] main-best-quests-tmp-stub))

(defn- main-reviews-tmp-stub []
  [(review/build {::review/name "Выбираем самый технологичный квест"})
   (review/build {::review/name "Квесты для любителей побегать"})
   (review/build {::review/name "Куда сходить семье с ребенком"})
   (review/build {::review/name "Выбираем самый необычный квест"})
   (review/build {::review/name "Барби"})])

(c/register :db/main-reviews (fn [_] main-reviews-tmp-stub))

(defn- main-new-quests-tmp-stub []
  [(quest/build {::quest/name "Гагарин"})
   (quest/build {::quest/name "Прометей"})
   (quest/build {::quest/name "Дядя Федор"})
   (quest/build {::quest/name "UT"})
   (quest/build {::quest/name "Барби"})])

(c/register :db/main-new-quests (fn [_] main-new-quests-tmp-stub))

(defn- main-companies-tmp-stub []
  [(company/build {::company/name "Гагарин"})
   (company/build {::company/name "Прометей"})
   (company/build {::company/name "Дядя Федор"})
   (company/build {::company/name "UT"})
   (company/build {::company/name "Барби"})
   (company/build {::company/name "Барби2"})])

(c/register :db/main-companies (fn [_] main-companies-tmp-stub))
