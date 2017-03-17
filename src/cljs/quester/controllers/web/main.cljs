(ns quester.controllers.web.main
  (:require
   [darkleaf.router :as r]
   [quester.use-cases.main :refer [->UseCase]]
   [quester.components.pages.main :as pages.main]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          use-case (->UseCase ctx)]
      [pages.main/component use-case])))
