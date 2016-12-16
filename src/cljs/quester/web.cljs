(ns quester.web
  (:require [pushy.core :as pushy]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]))

(enable-console-print!)

(def handler (router/make-handler web-routes/routes))

(def history (pushy/pushy (fn [x] (println x))
                          (fn [uri] (handler {:uri uri
                                              :request-method :get}))))
(pushy/start! history)

(comment
  (pushy/replace-token! history "/quests/q"))
