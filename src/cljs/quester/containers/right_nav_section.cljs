(ns quester.containers.right-nav-section
  (:require [quester.frontend :as f]
            [quester.react :refer [e]]))

(defn container []
  (e f/NavSection {}
     (e f/NavItem {:name "Москва"})
     (e f/NavItem {:name "Избранное"})
     (e f/NavItem {:name "Выйти"})))
