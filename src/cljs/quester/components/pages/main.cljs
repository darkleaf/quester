(ns quester.components.pages.main
  (:require
   [reagent.core :as reagent]
   [quester.use-cases.main :as uc]
   [quester.ui :as ui]
   [quester.components.shared.nav :as nav]
   [quester.components.shared.selection-card :as selection-card]
   [quester.components.shared.review-card :as review-card]
   [quester.components.shared.quest-card :as quest-card]
   [quester.components.shared.company-card :as company-card]
   [quester.entities.common :as common]))

(defn main-carousel []
  [ui/main-carousel {:slides [{:title "<b>Москва 2048,</b> Клаустрофобия"
                               :imageUrl "https://unsplash.it/1900/500?image=101"}
                              {:title "2"
                               :imageUrl "https://unsplash.it/1900/500?image=672"}
                              {:title "3"
                               :imageUrl "https://unsplash.it/1900/500?image=978"}]}
   [ui/main-filter]])

(defn selections-slider [use-case]
  [ui/slider {:title "Подборки квестов"
              :totalCount 25
              :seeAllUrl "/selections"
              :windowLength 4}
   (for [card (uc/get-selections-cards use-case)]
     ^{:key (::common/uuid card)} [selection-card/container card])])

(defn reviews-slider [use-case]
  [ui/slider {:title "Обзоры"
              :total-count 25
              :see-all-url "/reviews"
              :window-length 4
              :highlighted true}
   (for [card (uc/get-reviews-cards use-case)]
     ^{:key (::common/uuid card)} [review-card/container card])])

(defn best-quests-slider [use-case]
  [ui/slider {:title "Лучшие квесты"
              :totalCount 10
              :seeAllUrl "/best"
              :windowLength 4}
   (for [card (uc/get-best-quests-cards use-case)]
     ^{:key (::common/uuid card)} [quest-card/container card])])

(defn new-quests-slider [use-case]
  [ui/slider {:title "Новые квесты"
              :totalCount 10
              :seeAllUrl "/quests"
              :windowLength 4}
   (for [card (uc/get-new-quests-cards use-case)]
    ^{:key (::common/uuid card)} [quest-card/container card])])

(defn companies-slider [use-case]
  [ui/slider  {:title "Компании"
               :totalCount 25
               :seeAllUrl "/companies"
               :windowLength 6}
   (for [card (uc/get-companies-cards use-case)]
     ^{:key (::common/uuid card)} [company-card/container card])])

(defn component [use-case]
  [ui/main-page {:nav (reagent/as-element [nav/container])
                 :main-carousel (reagent/as-element [main-carousel])
                 :selections-slider (reagent/as-element [selections-slider use-case])
                 :reviews-slider (reagent/as-element [reviews-slider use-case])
                 :best-quests-slider (reagent/as-element [best-quests-slider use-case])
                 :new-quests-slider (reagent/as-element [new-quests-slider use-case])
                 :companies-slider (reagent/as-element [companies-slider use-case])}])
