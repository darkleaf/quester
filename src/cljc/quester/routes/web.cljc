(ns quester.routes.web
  (:require [darkleaf.router :as r]
            [quester.controllers.web.site :as site]))

(def routes
  (r/resource :site site/controller
              :segment false))
