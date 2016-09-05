(ns quester.router
  (:require [clojure.core.match :refer [match]])
  (:require [clojure.walk :refer [walk postwalk prewalk]]))

(defrecord Route [pattern handler])

(defn add-namespace [rns-part & routes]
  (map
   (fn [route]
     (-> route
         (update-in [:pattern :uri] #(into [rns-part] %))))
   (flatten routes)))

(defn resources [rs-name controller]
  (apply
   add-namespace
   (name rs-name)
   (cond-> ()
     (:index controller) (conj (Route. '{:uri []} (:index controller)))
     (:show controller)  (conj (Route. '{:uri [id]} (:show controller))))))


(def routes
  (add-namespace "admin"
                 (resources :posts {:index (fn [_] "index"), :show (fn [_] "show")})
                 (resources :users {:show (fn [_] "show")})))

routes

(defn- route->match-clause [route]
  (list [(:pattern route)] (:handler route)))

(defmacro compile-handler [routes-var-name]
  `(fn [req#]
     (let [route-handler# (match [req#]
                                 ~@(->> (var-get (resolve routes-var-name))
                                        (map route->match-clause)
                                        (reduce into [])))]
       (route-handler# req#))))

(def handler (compile-handler routes))

(handler {:uri ["admin" "users" 1]})


(defn extract-symbols [form]
  (walk
   (fn [x]
     (println x)
     x)
   form))


(extract-symbols '(foo (bar (buz 1)) (bar 2)))
