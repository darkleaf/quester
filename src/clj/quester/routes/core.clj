(ns quester.routes.core
  (:require [darkleaf.router :refer :all]
            [quester.routes.web :as web]))

(def routes
  (build-routes
   web/routes))

(def handler (build-handler routes))
#_(def request-for (build-request-for routes))
