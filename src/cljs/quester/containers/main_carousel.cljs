(ns quester.containers.main-carousel
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.MainCarousel {:slides [{:title "<b>Москва 2048,</b> Клаустрофобия"
                                   :imageUrl "http://placehold.it/1900x500"}
                                  {:title "2"
                                   :imageUrl "http://placehold.it/1900x500/222"}
                                  {:title "3"
                                   :imageUrl "http://placehold.it/1900x500"}]}
     (e js/ui.MainFilter {})))
