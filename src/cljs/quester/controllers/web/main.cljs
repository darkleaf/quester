(ns quester.controllers.web.main
  (:require [darkleaf.router :as r]
            [quester.use-cases.welcome :as use-cases.welcome]
            [quester.components.pages.main :as pages.main]
            [quester.components.context :as context]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          use-case (use-cases.welcome/->Welcome ctx)
          use-case-provider (context/provider :welcome)
          presenter (context/receiver :welcome (fn [uc] [:div (use-cases.welcome/foo uc)]))]
      [use-case-provider use-case
       [presenter]])
    #_pages.main/component))
