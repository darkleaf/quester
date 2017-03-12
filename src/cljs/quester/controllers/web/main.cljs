(ns quester.controllers.web.main
  (:require [darkleaf.router :as r]))

(r/defcontroller controller
  (show [_req]
    :components.pages/main))
