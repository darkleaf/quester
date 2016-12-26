(ns quester.routes.core
  (:require [darkleaf.router :as r]
            [quester.routes.web :as web]
            [quester.middlewares.core :refer [middleware]]))

(def routes
  (r/wrapper
   middleware
   web/routes))
