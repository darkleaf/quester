(ns quester.containers.main-page.reviews-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.review :as review]))

(defn container [props]
  (let [data (.. props -data)
        reviews (:reviews-cards data)
        review->element (fn [review]
                          (e js/ui.ReviewCard
                             #js {:key (::c/uuid review)
                                  :name (::review/name review)
                                  :imageUrl (str "https://unsplash.it/300/350?image=" (rand-int 1000))}))]
    (e js/ui.Slider #js {:title "Обзоры"
                         :totalCount 25
                         :seeAllUrl "/reviews"
                         :windowLength 4
                         :highlighted true}
       (map review->element reviews))))
