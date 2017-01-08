(ns quester.containers.main-page.selections-slider
  (:require [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.containers.adapters.selection-card :as selection-card]))

(defn container [cards-ratom]
  [ui/slider {:title "Подборки квестов"
              :totalCount 25
              :seeAllUrl "/selections"
              :windowLength 4}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [selection-card/container card])])
