(ns quester.handlers.web.special
  (:require [ring.util.response :as r]
            [quester.container :as c]))

(defn welcome [req]
  (let [uc (c/resolve :use-cases/welcome)
        data (uc)]
    (r/response data)))
