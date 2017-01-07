(ns quester.containers.main-page
  (:require [quester.react :refer [e]]
            [quester.containers.main-page.main-carousel :as carousel]
            [quester.containers.main-page.reviews-slider :as reviews-slider]
            #_[quester.containers.main-page.best-quests-slider :as best-quests-slider]))

(defn stub []
  (e "div" nil "stub"))

(defn container [props]
  (e js/ui.MainPage
     #js{:nav (e stub)
         :mainCarousel (e carousel/container)
         :selectionsSlider (e stub)
         :bestQuestsSlider (e stub) #_(e best-quests-slider/container props)
         :reviewsSlider   (e reviews-slider/container props)
         :newQuestsSlider (e stub)
         :companiesSlider (e stub)}))
