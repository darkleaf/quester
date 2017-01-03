(ns quester.util.request-hash
  (:require [darkleaf.router :as r]))

(defn req->hash [req]
  (-> req
      (select-keys [::r/action ::r/scope ::r/params])
      (hash)))
