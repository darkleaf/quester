(ns quester.controllers.web.site
  (:require [ring.util.response :as r]))

(def controller
  {:show (fn [req]
           (let [resolve (:resolve req)
                 uc (resolve :use-cases/welcome)
                 data (uc)]
             (r/response data)))})
