(ns quester.controllers.web.quests
  (:require [darkleaf.router :as r]
            [ring.util.response :refer [response]]
            [quester.util.container :as c]))

(r/defcontroller controller
  (show [req]
    (let [deps (:deps-registry req)
          uc (c/resolve deps :use-cases.quests/show)
          {:keys [quest-id]} (::r/params req)
          data (uc quest-id)]
      (response data))))
