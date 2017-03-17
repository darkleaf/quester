(ns quester.controllers.web.quests
  (:require
   [darkleaf.router :as r]
   [quester.use-cases.quests.show :refer [->UseCase]]
   [quester.components.pages.quest :as pages.quest]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          use-case (->UseCase ctx)]
      [pages.quest/component use-case])))
