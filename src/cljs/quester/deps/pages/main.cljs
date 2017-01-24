(ns quester.deps.pages.main
  (:require [quester.util.container :as container]
            [quester.components.pages.main :as main-page]))

(defn register [registry]
  (container/register
   registry

   :components.pages.main/carousel
   (fn [] main-page/main-carousel)

   :components.pages.main/selections-slider
   (fn [resolve]
     (fn selections-slider-container []
       [main-page/selections-slider
        (resolve :page/state)
        (resolve :components.shared/selection-card)]))

   :components.pages.main/reviews-slider
   (fn [resolve]
     (fn reviews-slider-container []
       [main-page/reviews-slider
        (resolve :page/state)
        (resolve :components.shared/review-card)]))

   :components.pages.main/best-quests-slider
   (fn [resolve]
     (fn best-quests-slider-container []
       [main-page/best-quests-slider
        (resolve :page/state)
        (resolve :components.shared/quest-card)]))

   :components.pages.main/new-quests-slider
   (fn [resolve]
     (fn new-quests-slider-container []
       [main-page/new-quests-slider
        (resolve :page/state)
        (resolve :components.shared/quest-card)]))

   :components.pages.main/companies-slider
   (fn [resolve]
     (fn companies-slider-container []
       [main-page/companies-slider
        (resolve :page/state)
        (resolve :components.shared/company-card)]))

   :components.pages/main
   (fn [resolve]
     (fn main-page-container []
       [main-page/main
        :nav [(resolve :components.shared/nav)]
        :main-carousel [(resolve :components.pages.main/carousel)]
        :selections-slider [(resolve :components.pages.main/selections-slider)]
        :best-quests-slider [(resolve :components.pages.main/best-quests-slider)]
        :reviews-slider [(resolve :components.pages.main/reviews-slider)]
        :new-quests-slider [(resolve :components.pages.main/new-quests-slider)]
        :companies-slider [(resolve :components.pages.main/companies-slider)]]))))
