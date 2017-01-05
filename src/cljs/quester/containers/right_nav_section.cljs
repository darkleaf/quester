(ns quester.containers.right-nav-section
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.NavSection nil
     (e js/ui.NavItem #js {:name "Москва"})
     (e js/ui.NavItem #js {:name "Избранное"})
     (e js/ui.NavItem #js {:name "Выйти"})))
