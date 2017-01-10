(ns quester.controllers.web.quests
  (:require [darkleaf.router :as router]
            [ring.util.response :as r]))

(def controller
  {:show (fn [req]
           (let [resolve (:resolve req)
                 uc (resolve :use-cases.quests/show)
                 {:keys [quest-id]} (::router/params req)
                 data (uc quest-id)]
             (r/response data)))})
