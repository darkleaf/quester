(ns quester.routes.core
  (:require [darkleaf.router :as r]
            [quester.routes.web :as web]
            [quester.middlewares.core :as core-mw]
            [quester.middlewares.web :as web-mw]))

(def routes
  (r/wrapper
   core-mw/wrap-charset
   (r/wrapper
     web-mw/wrap-response-body
     web/routes)))
