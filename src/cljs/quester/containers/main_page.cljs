(ns quester.containers.main-page
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.containers.adapters.quest-card :as quest-card]
            [quester.containers.adapters.company-card :as company-card]
            [quester.containers.adapters.review-card :as review-card]
            [quester.containers.adapters.selection-card :as selection-card]
            [quester.containers.shared.nav :as nav]))

(defn main-carousel []
  [ui/main-carousel {:slides [{:title "<b>Москва 2048,</b> Клаустрофобия"
                               :imageUrl "https://unsplash.it/1900/500?image=101"}
                              {:title "2"
                               :imageUrl "https://unsplash.it/1900/500?image=672"}
                              {:title "3"
                               :imageUrl "https://unsplash.it/1900/500?image=978"}]}
   [ui/main-filter]])

(defn selections-slider [cards-ratom]
  [ui/slider {:title "Подборки квестов"
              :totalCount 25
              :seeAllUrl "/selections"
              :windowLength 4}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [selection-card/container card])])

(defn reviews-slider [cards-ratom]
  [ui/slider {:title "Обзоры"
              :total-count 25
              :see-all-url "/reviews"
              :window-length 4
              :highlighted true}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [review-card/container card])])

(defn best-quests-slider [cards-ratom]
  [ui/slider {:title "Лучшие квесты"
              :totalCount 10
              :seeAllUrl "/best"
              :windowLength 4}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [quest-card/container card])])

(defn new-quests-slider [cards-ratom]
  [ui/slider {:title "Новые квесты"
              :totalCount 10
              :seeAllUrl "/quests"
              :windowLength 4}
   (for [card @cards-ratom]
    ^{:key (::common/uuid card)} [quest-card/container card])])

(defn companies-slider [cards-ratom]
  [ui/slider  {:title "Компании"
               :totalCount 25
               :seeAllUrl "/companies"
               :windowLength 6}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [company-card/container card])])

(defn container [data]
  [ui/main-page {:nav
                 (r/as-element [nav/container])

                 :main-carousel
                 (r/as-element [main-carousel])

                 :selections-slider
                 (r/as-element
                  [selections-slider (r/cursor data [:selections-cards])])

                 :best-quests-slider
                  (r/as-element
                   [best-quests-slider (r/cursor data [:best-quests-cards])])

                 :reviews-slider
                 (r/as-element
                  [reviews-slider (r/cursor data [:reviews-cards])])

                 :new-quests-slider
                 (r/as-element
                  [new-quests-slider (r/cursor data [:new-quests-cards])])

                 :companies-slider
                 (r/as-element
                  [companies-slider (r/cursor data [:companies-cards])])}])
