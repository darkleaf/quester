(ns quester.routes.core
  (:require [darkleaf.router :refer :all]
            [quester.routes.web :as web]
            [quester.middlewares.core :as core-mw]
            [quester.middlewares.web :as web-mw]))

(def routes
  (build-routes
   (wrap-handler
    core-mw/wrap-charset
    (wrap-handler
     web-mw/wrap-response-body
     web/routes))))

(def handler (build-handler routes)
 #_(def request-for (build-request-for routes)))
