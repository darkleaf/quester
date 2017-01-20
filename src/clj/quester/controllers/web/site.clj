(ns quester.controllers.web.site
  (:require [ring.util.response :as r]
            [quester.util.container :as c]))

(def controller
  {:show (fn [req]
           (let [deps (:deps-registry req)
                 uc (c/resolve deps :use-cases/welcome)
                 data (uc)]
             (r/response data)))})
