(ns quester.react)

(defn e
  ([component]
   (e component nil))
  ([component props & children]
   (apply js/ui.React.createElement
          component
          props
          children)))

(defn- add-this-as-first-arg [spec]
  (reduce-kv
   (fn [acc k v]
     (if (fn? v)
       (assoc acc k (fn [& args]
                      (this-as this
                        (apply v this args))))
       (assoc acc k v)))
   {}
   spec))

(defn create-class [& {:as spec}]
  "methods take 'this' as first arg"
  (-> spec
      (add-this-as-first-arg)
      (clj->js)
      (js/ui.React.createClass)))
