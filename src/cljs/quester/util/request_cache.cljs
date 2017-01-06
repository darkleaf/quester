(ns quester.util.request-cache
  (:refer-clojure :exclude [get]))

(def ^:private seconds 1000)

(defn- timestamp []
  (.getTime (js/Date.)))

(defn build [] (atom {}))

(defn put [cache key value]
  (let [expired-at (+ (timestamp)
                      (* 10 seconds))]
    (swap! cache assoc key {:expired-at expired-at
                            :value value})))

(defn get [cache key]
  (when-let [{:keys [expired-at value]} (cljs.core/get @cache key)]
    (when (> expired-at (timestamp))
      value)))
