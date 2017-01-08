(ns quester.containers.main-page.reviews-slider
  (:require [quester.ui :as ui]
            [quester.containers.adapters.review-card :as review-card]
            [quester.entities.common :as c]))

(defn container [cards-ratom]
  [ui/slider {:title "Обзоры"
              :total-count 25
              :see-all-url "/reviews"
              :window-length 4
              :highlighted true}
   (for [card @cards-ratom]
     ^{:key (::c/uuid card)} [review-card/container card])])
