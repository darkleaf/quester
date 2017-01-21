(ns quester.controllers.web.site)

(def controller
  {:show (fn [_req] :components.pages.main/core)})
