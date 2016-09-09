(ns quester.router
  (:require [clojure.core.match :refer [match]]))

(defrecord Route [name
                  vars pattern
                  handler scope])

(defn route
  [name & {:keys [vars pattern
                  handler]
           :or {vars #{}
                pattern {}}}]
  {:pre [(and
          (keyword? name)
          (set? vars)
          (map? pattern)
          (fn? handler))]}
  (Route. name
          vars pattern
          handler '()))

(defn- merge-segments-patterns [parent-segments child-segments]
  (into parent-segments child-segments))

(defn- merge-map-patterns [parent-map-pattern child-map-pattern]
  (reduce-kv (fn [result k v]
               (assoc result k
                      (cond
                        (and (map? (k result)) (map? v)) (merge-map-patterns (k result) v)
                        (not (contains? result k)) v
                        :else (throw (java.lang.IllegalArgumentException. "can't merge patterns")))))
             parent-map-pattern
             child-map-pattern))

(defn- merge-request-patterns [parent child]
  (let [parent-segments (get parent :segments [])
        child-segments (get child :segments [])

        parent-map-pattern (dissoc parent :segments)
        child-map-pattern (dissoc child :segments)

        result-segments (merge-segments-patterns parent-segments child-segments)
        result-map-pattern (merge-map-patterns parent-map-pattern child-map-pattern)]
    (assoc result-map-pattern :segments result-segments)))

(defn scope [s-name
             {:keys [vars pattern]
              :or {vars #{}
                   pattern {}}}
             & routes]
  {:pre [(and
          (keyword? s-name)
          (set? vars)
          (map? pattern))]}
  (map
   (fn [route]
     (-> route
         (update :scope conj s-name)
         (update :vars into vars)
         (update :pattern #(merge-request-patterns pattern %))))
   (flatten routes)))

(defn prefix [p-name & routes]
  (scope p-name
         {:pattern {:segments [(name p-name)]}}
         routes))

(defn resources [rs-name controller]
  (prefix rs-name
          (cond-> ()
            (:index controller) (conj (route :index
                                             :pattern {:request-method :get}
                                             :handler (:index controller)))
            (:create controller) (conj (route :create
                                              :pattern {:request-method :post}
                                              :handler (:create controller)))
            (:show controller)  (conj (route :show
                                             :vars '#{id}
                                             :pattern '{:segments [id] :request-method :get}
                                             :handler (:show controller))))))

(defn- build-params-map [route]
  (let [symbols (:vars route)
        m-keys (vec (map keyword symbols))
        m-vals (vec symbols)]
    `(zipmap ~m-keys ~m-vals)))

(defn- build-pattern-row [route]
  [(:pattern route)])

(defn- route->match-clause [route]
  (let [pattern-row (build-pattern-row route)
        action [route (build-params-map route)]]
    (list pattern-row action)))

(defmacro build-request-matcher [routes-var-name]
  `(fn [req#]
     (match
      [req#]
      ~@(let [routes (var-get (resolve routes-var-name))]
          (mapcat route->match-clause routes)))))

(defn build-handler [matcher]
  (fn [req]
    (let [[route params] (matcher req)
          route-handler (:handler route)
          req-with-info (assoc req :route-params params, :matched-route route)]
      (route-handler req-with-info))))

(def routes
  (prefix :admin
          (resources :posts {:index identity, :show identity, :create identity})
          (resources :users {:show identity})))

routes

(def matcher (build-request-matcher routes))

(def handler (build-handler matcher))

(handler {:segments ["admin" "posts"], :request-method :post})
