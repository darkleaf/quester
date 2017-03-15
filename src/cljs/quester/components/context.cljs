(ns quester.components.context
  (:require [goog.object :refer [getValueByKeys]]
            [reagent.core :as r]))

(defn provider [key]
  (let [key-name (name key)]
    (r/create-class
     {:displayName
      (str "ContextProvider(" key-name ")")

      :getChildContext
      (fn []
        (this-as this
          (let [[_ value & _] (.. this -props -argv)]
            (js-obj key-name value))))

      :childContextTypes
      (js-obj key-name js/React.PropTypes.any.isRequired)

      :reagent-render
      (fn [_value & children]
        (into [:div] children))})))

(defn receiver [key component]
  "Higher-Order Component"
  (let [key-name (name key)]
    (r/create-class
     {:displayName
      (str "ContextReceiver(" key-name ")")

      :contextTypes
      (js-obj key-name js/React.PropTypes.any.isRequired)

      :reagent-render
      (fn [& args]
        (let [this (r/current-component)
              value (getValueByKeys this "context" key-name)]
          (into [component value] args)))})))
