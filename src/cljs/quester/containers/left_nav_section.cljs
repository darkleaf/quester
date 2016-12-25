(ns quester.containers.left-nav-section
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.NavSection {}
     (e js/ui.NavBrand {:name "Quester"})
     (e js/ui.NavItem {:name "Квесты"})
     (e js/ui.NavItem {:name "Подборки"})
     (e js/ui.NavItem {:name "Обзоры"})
     (e js/ui.NavItem {:name "Компании"})
     (e js/ui.NavSearch {})))
