(ns quester.containers.selections-slider
  (:require [quester.frontend :as f]
            [quester.react :refer [e create-class PropTypes]]))

(def container
  (create-class
   :displayName "SelectionsSliderContainer"
   :contextTypes {:pageState (.-any PropTypes)}
   :pageState (fn []
                (this-as this
                  (.. this -context -pageState)))
   :render (fn []
             (this-as this
              (let [state (.pageState this)]
                (e f/Slider {:title "Подборки квестов"
                             :totalCount 26
                             :seeAllUrl "/selections"}
                   "hello"
                   (str @state)))))))
