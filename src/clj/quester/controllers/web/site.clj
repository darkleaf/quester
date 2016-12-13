(ns quester.controllers.web.site
  (:require [ring.util.response :as r]
            [quester.container :as c]))

(def controller
  {:show (fn [req]
           (let [uc (c/resolve :use-cases/welcome)
                 data (uc)]
             (r/response data)))})
