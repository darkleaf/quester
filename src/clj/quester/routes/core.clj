(ns quester.routes.core
  (:require [darkleaf.router :as r]
            [quester.routes.web :as web]
            [quester.middlewares.core :refer [middleware]]))

(defn build-routes []
  (r/group :middleware middleware
    (web/build-routes)))
