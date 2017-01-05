(ns quester.containers.selections-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.selection :as selection]))

(defn container [props context]
  (let [state (.. context -state)
        selections (get-in state [:page :selections-cards])
        selection->element (fn [selection]
                             (e js/ui.SelectionCard
                                #js {:key (::c/uuid selection)
                                     :name (::selection/name selection)
                                     :imageUrl (str "https://unsplash.it/300/300?image=" (rand-int 1000))}))]
    (e js/ui.Slider #js {:title "Подборки квестов 111"
                         :totalCount 25
                         :seeAllUrl "/selections"
                         :windowLength 4}
       (map selection->element selections))))

(aset container
      "contextTypes"
      #js {:state js/ui.React.PropTypes.any.isRequired})
