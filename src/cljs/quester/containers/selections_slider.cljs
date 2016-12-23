(ns quester.containers.selections-slider
  (:require [quester.frontend :as f]
            [quester.react :refer [e create-class]]))

(def container
  (create-class
   :displayName "SelectionsSliderContainer"
   :render (fn []
            (e f/Slider {:title "Подборки квестов"
                         :totalCount 26
                         :seeAllUrl "/selections"}
               "hello"))))
