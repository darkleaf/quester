(ns quester.use-cases.welcome
  (:require [clojure.spec :as s]
            [quester.entities.selection :as selection]))

(defn perform [{:keys [selections-for-slider]}]
  {:selections-for-slider (selections-for-slider)})
