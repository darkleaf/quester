(ns quester.containers.main-carousel
  (:require [quester.react :refer [e]]))

(defn container []
  (e js/ui.MainCarousel {:title "<b>Москва 2048,</b> Клаустрофобия"
                         :currentImageUrl "http://placehold.it/1900x500"
                         :indicators [{:onClick (constantly nil)}
                                      {:onClick (constantly nil), :active  true}
                                      {:onClick (constantly nil)}]}
     (e js/ui.MainFilter {})))
