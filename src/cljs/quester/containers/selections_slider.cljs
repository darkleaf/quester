(ns quester.containers.selections-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.selection :as selection]))

(defn container [props context]
  (let [state (.. context -state)
        selections (get-in @state [:page :selections])
        selection->element (fn [selection]
                             (e js/ui.SelectionCard
                                {:key (::c/uuid selection)
                                 :name (::selection/name selection)
                                 :imageUrl "http://placehold.it/300x300"}))]
    (e js/ui.Slider {:title "Подборки квестов"
                     :totalCount 25
                     :seeAllUrl "/selections"}
       (map selection->element selections))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
