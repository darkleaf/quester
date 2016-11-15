(ns quester.routes.web
  (:require [darkleaf.router :refer :all]
            [quester.handlers.web.special :as special]))

(def routes
  (build-routes
   (root special/welcome)))
