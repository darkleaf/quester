(ns quester.controllers.web.main
  (:require [ring.util.response :refer [response]]
            [darkleaf.router :as r]
            [quester.use-cases.welcome :as welcome]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          data (welcome/use-case ctx)]
      (response data))))
