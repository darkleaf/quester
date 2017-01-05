(ns quester.controllers.web.quests
  (:require [darkleaf.router :as router]
            [ring.util.response :as r]
            [quester.container :as c]))

(def controller
  {:show (fn [req]
           (let [uc (c/resolve :use-cases/quest-show)
                 {:keys [quest-id]} (::router/params req)
                 data (uc quest-id)]
             (r/response data)))})
