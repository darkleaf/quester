(ns quester.controllers.web.main
  (:require [ring.util.response :refer [response]]
            [darkleaf.router :as r]
            [quester.util.container :as c]))

(r/defcontroller controller
  (show [req]
    (let [deps (:deps-registry req)
          uc (c/resolve deps :use-cases/welcome)
          data (uc)]
      (response data))))
