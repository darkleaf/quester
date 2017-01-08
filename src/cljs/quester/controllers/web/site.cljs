(ns quester.controllers.web.site
  (:require [quester.containers.main-page :as main-page]))

(def controller
  {:show (fn [_req] #'main-page/container)})
