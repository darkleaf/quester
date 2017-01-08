(ns quester.controllers.web.quests
  (:require [quester.containers.quest-page :as quest-page]))

(def controller
  {:show (fn [req] #'quest-page/container)})
