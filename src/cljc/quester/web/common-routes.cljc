(ns quester.web.common-routes
  (:require [domkm.silk :as silk]))

(def routes
  (silk/routes {:root [[]]
                :quests [["quests"]]
                :quest [["quests" (silk/int :id)]]}))
