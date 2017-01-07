(ns quester.containers.state
  (:require [quester.react :refer [e] :as r]))

(def container
  (r/create-class
   :displayName "State"

   :propTypes
   {:data js/ui.React.PropTypes.any.isRequired}

   :getInitialState
   (fn [this]
     (js-obj "data" (.. this -props -data)))

   :componentWillReceiveProps
   (fn [this next-props]
     (.setState this (js-obj "data" (.. next-props -data))))

   :updateData
   (fn [this updater]
     (.setState this (js-obj "data" (updater (.. this -state -data)))))

   :render
   (fn [this]
     (e "div" nil
        (js/ui.React.Children.map
         (.. this -props -children)
         #(js/ui.React.cloneElement % (js-obj "data" (.. this -state -data)
                                              "updateData" (.. this -updateData))))))))
