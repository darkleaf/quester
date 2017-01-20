(ns quester.util.container
  (:refer-clojure :exclude [resolve]))

(defn build [] {})

(defn register [registry & {:as factories}]
  (merge registry factories))

(defn resolve [registry dep]
  (let [factory (get registry dep)
        resolver #(resolve registry %)]
    (assert factory (str "Conntainer factory not found for " dep))
    (factory resolver)))
