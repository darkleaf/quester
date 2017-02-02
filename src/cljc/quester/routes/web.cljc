(ns quester.routes.web
  (:require [darkleaf.router :as r]
            [mount.core :refer [defstate]]
            [quester.controllers.web.main :as main]
            [quester.controllers.web.quests :as quests]
            [quester.middlewares.web :refer [middleware]]))

(defstate routes
  :start
  (r/wrapper
   middleware
   (r/resource :main main/controller
               :segment false)
   (r/resources :quests :quest quests/controller)))
