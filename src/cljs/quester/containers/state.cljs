(ns quester.containers.state
  (:require [quester.react :refer [e] :as r]))

(def container
  (r/create-class
   :displayName "State"

   :childContextTypes
   {:state js/ui.React.PropTypes.any.isRequired
    :updateState js/ui.React.PropTypes.func.isRequired}

   :propTypes
   {:atom js/ui.React.PropTypes.any.isRequired}

   :getChildContext
   (fn []
     (this-as this
       (js-obj "state" (.. this -state -value)
               "updateState" (partial swap! (.. this -props -atom)))))

   :getInitialState
   (fn []
     (this-as this
       (js-obj "value" @(.. this -props -atom))))

   :componentDidMount
   (fn []
     (this-as this
       (add-watch (.. this -props -atom) :update
                  (fn [_key _ref _old new]
                    (prn "set new state")
                    (.setState this (js-obj "value" new))))))

   :componentWillUnmount
   (fn []
     (this-as this
       (remove-watch (.. this -props -atom) :update)))

   :render
   (fn []
     (this-as this
       (e "div" {} (.. this -props -children))))))
