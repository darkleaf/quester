(ns quester.controllers.web.site
  (:require [quester.frontend :as f]
            [quester.react :refer [e]]))

(def controller
  {:show (fn [req]
           (e f/MainPage {}))})
