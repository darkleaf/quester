(ns quester.react)

(defn e [component props & children]
  (let [js-props (clj->js props)]
    (apply js/ui.React.createElement
           component
           js-props
           children)))

(defn create-class [& {:as spec}]
  (let [js-spec (clj->js spec)]
    (js/ui.React.createClass js-spec)))
