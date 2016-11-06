(ns quester.use-cases-deps.setup
  (:require [quester.use-cases-deps.container :refer [register]]
            ;; for stubs
            [quester.entities.selection :as selection]))

(defn- selections-for-slider-stub []
  [(selection/build {::selection/name "Перформансы"})
   (selection/build {::selection/name "Страшные"})
   (selection/build {::selection/name "Семейные"})
   (selection/build {::selection/name "Виртуальная реальность"})
   (selection/build {::selection/name "Крутые"})
   (selection/build {::selection/name "Для девочек"})])

(defn setup []
  (register :selections-for-slider #'selections-for-slider-stub))
