(ns quester.entities.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]))

(s/def ::name (s/and string? not-empty))

(s/def ::spec (s/merge ::common/spec
                       (s/keys :req [::name])))

(defn build
  ([] (build {}))
  ([attrs]
   (let [common-defaults (common/defaults)
         defaults {::name ""}]
     (merge common-defaults defaults attrs))))
