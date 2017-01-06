(ns quester.controllers.web.quests
  (:require [darkleaf.router :as router]
            [quester.react :refer [e]]))

(def controller
  {:show (fn [req]
           #_(e "div" {} "quest page"))})
