(ns quester.container
  (:refer-clojure :exclude [resolve]))

(defonce ^:private registry (atom {}))

#_(defn replace [& {:as replacements}])

(defn clear []
  (reset! registry {}))

(defn register [& {:as factories}]
  (swap! registry merge factories))

(defn- resolve-impl [dep registry-map]
  (let [factory (get registry-map dep)
        resolver #(resolve-impl % registry-map)]
    (assert (some? factory) (str "Factory not found for " dep))
    (factory resolver)))

(defn resolve [dep & {:as overrides}]
  (resolve-impl dep (merge @registry overrides)))
