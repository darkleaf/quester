(ns quester.use-cases-deps.container)

(defonce deps (atom {}))

(defn register [k v]
  (swap! deps assoc k v))

(defn clear []
  (reset! deps {}))

(defn inject [f]
  (fn [& xs]
    (assert (not-empty @deps) "You must setup deps")
    (apply f @deps xs)))
