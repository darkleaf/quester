(ns quester.routes.core
  (:require [darkleaf.router :as r]
            [quester.routes.web :as web]
            [quester.middlewares.core :refer [middleware]]))

(defn build-routes []
  (r/wrapper
   middleware
   (web/build-routes)))
