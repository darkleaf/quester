(ns quester.containers.main-page.reviews-slider
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.containers.adapters.review-card :as review-card]
            [quester.entities.common :as c]))

(defn container [reviews]
  [ui/slider {:title "Обзоры"
              :total-count 25
              :see-all-url "/reviews"
              :window-length 4
              :highlighted true}
   (for [review @reviews]
     ^{:key (::c/uuid review)} [review-card/container review])])
