(ns quester.controllers.web.quests
  (:require [darkleaf.router :as router]
            [ring.util.response :as r]
            [quester.util.container :as c]))

(def controller
  {:show (fn [req]
           (let [deps (:deps-registry req)
                 uc (c/resolve deps :use-cases.quests/show)
                 {:keys [quest-id]} (::router/params req)
                 data (uc quest-id)]
             (r/response data)))})
