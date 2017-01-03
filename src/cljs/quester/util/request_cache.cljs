(ns quester.util.request-cache
  (:refer-clojure :exclude [get]))

(def ^:private seconds 1000)

(defn- timestamp []
  (.getTime (js/Date.)))

(defn put [state key value]
  (let [expired-at (+ (timestamp)
                      (* 1 seconds))]
    (assoc-in state [::storage key] {:expired-at expired-at
                                     :value value})))

(defn get [state key]
  (when-let [{:keys [expired-at value]} (get-in state [::storage key])]
    (when (> expired-at (timestamp))
      value)))
