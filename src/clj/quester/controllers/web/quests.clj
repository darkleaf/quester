(ns quester.controllers.web.quests
  (:require [ring.util.response :as r]))

(def controller
  {:show (fn [req]
           (r/response {:foo :bar}))})
