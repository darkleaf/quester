(ns quester.controllers.web.quests
  (:require
   [darkleaf.router :as r]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)])

    :components.pages/quest))
