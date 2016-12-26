(ns quester.controllers.web.quests
  (:require [quester.react :refer [e]]))

(def controller
  {:show (fn [req]
           (e "div" {} "quest page"))})
