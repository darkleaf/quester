(ns quester.pages.main
  (:require [quester.react :refer [e]]
            [quester.containers.main-page.main-carousel :as carousel]))

(defn stub []
  (e "div" nil "stub"))

(defn page [props]
  (e js/ui.MainPage
     (js-obj "Nav" stub
             "MainCarousel" carousel/container
             "SelectionsSlider" stub
             "BestQuestsSlider" stub
             "ReviewsSlider" stub
             "NewQuestsSlider" stub
             "CompaniesSlider" stub)))
