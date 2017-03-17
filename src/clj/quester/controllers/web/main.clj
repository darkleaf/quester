(ns quester.controllers.web.main
  (:require [ring.util.http-response :as response]
            [darkleaf.router :as r]
            [quester.use-cases.main :refer [use-case]]))

(r/defcontroller controller
  (show [req]
    (let [ctx (:quester/ctx req)
          data (use-case ctx)]
      (response/ok data))))
