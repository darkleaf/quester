(ns quester.containers.main-page.new-quests-slider
  (:require [quester.ui :as ui]
            [quester.containers.adapters.quest-card :as quest-card]
            [quester.entities.common :as c]))

(defn container [cards-ratom]
  [ui/slider {:title "Новые квесты"
              :totalCount 10
              :seeAllUrl "/quests"
              :windowLength 4}
   (for [card @cards-ratom]
    ^{:key (::c/uuid card)} [quest-card/container card])])
