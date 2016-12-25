(ns quester.containers.selections-slider
  (:require [quester.react :refer [e create-class]]))

(def container
  (create-class
   :displayName "SelectionsSliderContainer"
   :contextTypes {:pageState js/ui.React.PropTypes.any}
   :pageState (fn []
                (this-as this
                  (.. this -context -pageState)))
   :render (fn []
             (this-as this
              (let [state (.pageState this)]
                (e js/ui.Slider {:title "Подборки квестов"
                                 :totalCount 26
                                 :seeAllUrl "/selections"}
                   "hello"
                   (str @state)))))))
