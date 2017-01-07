(ns quester.pages.main
  (:require [quester.react :refer [e]]
            [quester.containers.main-page.main-carousel :as carousel]))

(defn stub []
  (e "div" nil "stub"))


(defn page [props]
  (e js/ui.MainPage
     (js-obj "nav" (e stub)
             "mainCarousel" (e carousel/container)
             "selectionsSlider" (e stub)
             "bestQuestsSlider" (e stub)
             "reviewsSlider" (e stub)
             "newQuestsSlider" (e stub)
             "companiesSlider" (e stub))))
