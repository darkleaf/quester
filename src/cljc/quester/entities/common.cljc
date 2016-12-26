(ns quester.entities.common
  (:require [clojure.spec :as s]))

(defn- generate-uuid []
  #?(:clj  (java.util.UUID/randomUUID)
     :cljs (random-uuid)))
(s/def ::uuid uuid?)

(s/def ::spec (s/keys :req [::uuid]))

(defn defaults []
  {::uuid (generate-uuid)})
