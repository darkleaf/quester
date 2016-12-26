(ns quester.containers.right-nav-section
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.NavSection {}
     (e js/ui.NavItem {:name "Москва"})
     (e js/ui.NavItem {:name "Избранное"})
     (e js/ui.NavItem {:name "Выйти"})))
