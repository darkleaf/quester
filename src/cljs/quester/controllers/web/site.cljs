(ns quester.controllers.web.site
  (:require [quester.pages.main :as main]))

(def controller
  {:show (fn [_req] #'main/page)})
