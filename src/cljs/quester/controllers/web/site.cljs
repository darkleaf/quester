(ns quester.controllers.web.site
  (:require [quester.react :refer [e]]))

(def controller
  {:show (fn [req]
           (e js/ui.MainPage))})
