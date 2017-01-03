(ns quester.entities.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]))

(s/def ::name (s/and string? not-empty))

(s/def ::spec (s/merge ::common/spec
                       (s/keys :req [::name])))
