(ns quester.controllers.web.quests
  (:require [darkleaf.router :as r]))

(r/defcontroller controller
  (show [_req]
    :components.pages/quest))
