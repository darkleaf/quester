(ns quester.react
  (:require [quester.frontend :as f]))

(defn e [component props & children]
  (let [js-props (clj->js props)]
    (apply f/React.createElement
           component
           js-props
           children)))

(defn create-class [& {:as spec}]
  (let [js-spec (clj->js spec)]
    (f/React.createClass js-spec)))
