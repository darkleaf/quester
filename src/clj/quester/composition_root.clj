(ns quester.composition-root
  (:require [quester.container :as c]
            [quester.use-cases.welcome :as uc-welcome]

            ;; for stubs
            [quester.entities.selection :as selection]))

(defn- main-selections-tmp-stub []
  [(selection/build {::selection/name "Перформансы"})
   (selection/build {::selection/name "Страшные"})
   (selection/build {::selection/name "Семейные"})
   (selection/build {::selection/name "Виртуальная реальность"})
   (selection/build {::selection/name "Крутые"})
   (selection/build {::selection/name "Для девочек"})])

(defn register-use-cases []
  (c/register :use-cases/welcome (fn [resolve]
                                   (partial uc-welcome/perform {:selections (resolve :db/main-selections)}))))

(defn register-db []
  (c/register :db/main-selections (fn [_] main-selections-tmp-stub)))

(defn register-all []
  (register-use-cases)
  (register-db))
