(ns quester.controllers.web.main
  (:require
   [darkleaf.router :as r]
   [quester.use-cases.main :as use-cases.main]
   [quester.components.pages.main :as pages.main]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          use-case (use-cases.main/use-case ctx)]
      [pages.main/component use-case])))
