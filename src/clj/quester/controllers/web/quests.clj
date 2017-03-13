(ns quester.controllers.web.quests
  (:require [darkleaf.router :as r]
            [ring.util.http-response :as response]
            [quester.use-cases.quests.show :as quests.show]))

(r/defcontroller controller
  (show [req]
    (let [{:keys [quest-id]} (::r/params req)
          ctx (:quester/ctx req)
          data (quests.show/use-case ctx quest-id)]
      (response/ok data))))
