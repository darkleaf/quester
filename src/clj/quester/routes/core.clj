(ns quester.routes.core
  (:require [darkleaf.router :as r]
            [mount.core :refer [defstate]]
            [quester.routes.web :as web]
            [quester.middlewares.core :refer [middleware]]))

(defstate routes
  :start
  (r/wrapper
   middleware
   @web/routes))
