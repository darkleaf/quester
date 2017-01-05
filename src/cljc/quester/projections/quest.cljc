(ns quester.projections.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]
            [quester.entities.quest :as quest]))

(s/def ::price-min pos-int?)
(s/def ::price-max pos-int?)
(s/def ::price-keys (s/and (s/keys :req [::price-min ::price-max])
                           #(>= (::price-max %) (::price-min %))))
(s/def ::total-rating (s/double-in :min 0, :max 10, :NaN? false, :infinite? false))

(s/def ::card (s/merge ::price-keys
                       ::quest/participants-keys
                       (s/keys :req [::common/uuid
                                     ::quest/name
                                     ::total-rating])))

(s/def ::page (s/merge ::quest/spec
                       ::price-keys
                       (s/keys :req [::total-rating])))
