(ns quester.containers.left-nav-section
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.NavSection nil
     (e js/ui.NavBrand #js {:name "Quester"})
     (e js/ui.NavItem #js {:name "Квесты"})
     (e js/ui.NavItem #js {:name "Подборки"})
     (e js/ui.NavItem #js {:name "Обзоры"})
     (e js/ui.NavItem #js {:name "Компании"})
     (e js/ui.NavSearch)))
