(ns quester.containers.reviews-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.review :as review]))

(defn container [props context]
  (let [state (.. context -state)
        reviews (get-in @state [:page :reviews])
        review->element (fn [review]
                          (e js/ui.ReviewCard
                             {:key (::c/uuid review)
                              :name (::review/name review)
                              :imageUrl "http://placehold.it/300x350"}))]
    (e js/ui.Slider {:title "Обзоры"
                     :totalCount 25
                     :seeAllUrl "/reviews"
                     :highlighted true}
       (map review->element reviews))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
