(ns quester.components.pages.main
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.entities.common :as common]))

;; (defn main-carousel []
;;   [ui/main-carousel {:slides [{:title "<b>Москва 2048,</b> Клаустрофобия"
;;                                :imageUrl "https://unsplash.it/1900/500?image=101"}
;;                               {:title "2"
;;                                :imageUrl "https://unsplash.it/1900/500?image=672"}
;;                               {:title "3"
;;                                :imageUrl "https://unsplash.it/1900/500?image=978"}]}
;;    [ui/main-filter]])

;; (defn selections-slider [state card-component]
;;   [ui/slider {:title "Подборки квестов"
;;               :totalCount 25
;;               :seeAllUrl "/selections"
;;               :windowLength 4}
;;    (for [card (:selections-cards state)]
;;      ^{:key (::common/uuid card)} [card-component card])])

;; (defn reviews-slider [state card-component]
;;   [ui/slider {:title "Обзоры"
;;               :total-count 25
;;               :see-all-url "/reviews"
;;               :window-length 4
;;               :highlighted true}
;;    (for [card (:reviews-cards state)]
;;      ^{:key (::common/uuid card)} [card-component card])])

;; (defn best-quests-slider [state card-component]
;;   [ui/slider {:title "Лучшие квесты"
;;               :totalCount 10
;;               :seeAllUrl "/best"
;;               :windowLength 4}
;;    (for [card (:best-quests-cards state)]
;;      ^{:key (::common/uuid card)} [card-component card])])

;; (defn new-quests-slider [state card-component]
;;   [ui/slider {:title "Новые квесты"
;;               :totalCount 10
;;               :seeAllUrl "/quests"
;;               :windowLength 4}
;;    (for [card (:new-quests-cards state)]
;;     ^{:key (::common/uuid card)} [card-component card])])

;; (defn companies-slider [state card-component]
;;   [ui/slider  {:title "Компании"
;;                :totalCount 25
;;                :seeAllUrl "/companies"
;;                :windowLength 6}
;;    (for [card (:companies-cards state)]
;;      ^{:key (::common/uuid card)} [card-component card])])

(defn component []
  [:div "main 3"]
  #_(assert (= (-> reagent-elements keys set)
               #{:nav
                 :main-carousel
                 :selections-slider
                 :best-quests-slider
                 :reviews-slider
                 :new-quests-slider
                 :companies-slider}))

  #_(let [react-elements (reduce-kv
                          (fn [acc k v] (assoc acc k (r/as-element v)))
                          {}
                          reagent-elements)]
      [ui/main-page react-elements]))
