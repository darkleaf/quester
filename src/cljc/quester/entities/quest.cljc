(ns quester.entities.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]))

(s/def ::name (s/and string? not-empty))
(s/def ::participants-min (s/int-in 1 100))
(s/def ::participants-max (s/int-in 1 100))


(s/def ::spec (s/and
               (s/merge ::common/spec
                        (s/keys :req [::name
                                      ::participants-min
                                      ::participants-max]))
               #(>= (::participants-max %) (::participants-min %))))
