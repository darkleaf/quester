(ns quester.container
  (:refer-clojure :exclude [resolve]))

(defn build []
  (atom {}))

(defn register [registry & {:as factories}]
  (swap! registry merge factories))

(defn- resolve-impl [registry-map dep]
  (let [factory (get registry-map dep)
        resolver #(resolve-impl registry-map %)]
    (assert (some? factory) (str "Factory not found for " dep))
    (factory resolver)))

(defn resolve [registry dep & {:as overrides}]
  (resolve-impl (merge @registry overrides) dep))
