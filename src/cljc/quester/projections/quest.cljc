(ns quester.projections.quest
  (:require [clojure.spec :as s]
            [quester.entities.common :as common]
            [quester.entities.quest :as quest]))

(s/def ::price-min pos-int?)
(s/def ::price-max pos-int?)
(s/def ::total-rating (s/double-in :min 0, :max 10, :NaN? false, :infinite? false))

(s/def ::card (s/keys :req [::common/uuid
                            ::quest/name
                            ::quest/participants-min
                            ::quest/participants-max
                            ::price-min
                            ::price-max
                            ::total-rating]))
