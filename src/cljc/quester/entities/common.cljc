(ns quester.entities.common
  (:require [clojure.spec :as s]))

(defn- generate-uuid []
  (java.util.UUID/randomUUID))

(s/def ::uuid uuid?)

(s/def ::spec (s/keys :req [::uuid]))

(defn defaults []
  {::uuid (generate-uuid)})
