(ns quester.routes.web
  (:require [darkleaf.router :as r]
            [quester.controllers.web.site :as site]
            [quester.controllers.web.quests :as quests]
            [quester.middlewares.web :refer [middleware]]))

(def routes
  (r/wrapper middleware
   (r/resource :site site/controller
               :segment false)
   (r/resources :quests :quest quests/controller)))
