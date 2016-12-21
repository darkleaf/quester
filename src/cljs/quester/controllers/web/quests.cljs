(ns quester.controllers.web.quests
  (:require [quester.frontend :as f]
            [quester.react :refer [e]]))

(def controller
  {:show (fn [req]
           (e "div" {} "quest page"))})
