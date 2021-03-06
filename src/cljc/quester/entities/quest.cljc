(ns quester.entities.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]))

(s/def ::not-empty-string (s/and string? not-empty))

(s/def ::name ::not-empty-string)
(s/def ::description ::not-empty-string)
(s/def ::participants-min (s/int-in 1 100))
(s/def ::participants-max (s/int-in 1 100))
(s/def ::participants-keys (s/and (s/keys :req [::participants-min ::participants-max])
                                  #(>= (::participants-max %) (::participants-min %))))

(s/def ::spec (s/and
               (s/merge ::common/spec
                        ::participants-keys
                        (s/keys :req [::name ::description]))))
