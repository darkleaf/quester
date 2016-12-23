(ns quester.containers.left-nav-section
  (:require [quester.frontend :as f]
            [quester.react :refer [e]]))

(defn container []
  (e f/NavSection {}
     (e f/NavBrand {:name "Quester"})
     (e f/NavItem {:name "Квесты"})
     (e f/NavItem {:name "Подборки"})
     (e f/NavItem {:name "Обзоры"})
     (e f/NavItem {:name "Компании"})
     (e f/NavSearch {})))
