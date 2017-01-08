(ns quester.containers.main-page.main-carousel
  (:require [quester.ui :as ui]))

(defn container []
  [ui/main-carousel {:slides [{:title "<b>Москва 2048,</b> Клаустрофобия"
                               :imageUrl "https://unsplash.it/1900/500?image=101"}
                              {:title "2"
                               :imageUrl "https://unsplash.it/1900/500?image=672"}
                              {:title "3"
                               :imageUrl "https://unsplash.it/1900/500?image=978"}]}
   [ui/main-filter]])
