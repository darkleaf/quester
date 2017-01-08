(ns quester.containers.shared.nav
  (:require [quester.ui :as ui]))

(defn container []
  [ui/nav
   [ui/nav-section
    [ui/nav-brand {:name "Quester"}]
    [ui/nav-item {:name "Квесты"}]
    [ui/nav-item {:name "Подборки"}]
    [ui/nav-item {:name "Обзоры"}]
    [ui/nav-item {:name "Компании"}]]
   [ui/nav-section
    [ui/nav-item {:name "Москва"}]
    [ui/nav-item {:name "Избранное"}]
    [ui/nav-item {:name "Выйти"}]]])
