(ns quester.containers.main-page.best-quests-slider
  (:require [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.containers.adapters.quest-card :as quest-card]))

(defn container [cards-ratom]
  [ui/slider {:title "Лучшие квесты"
              :totalCount 10
              :seeAllUrl "/best"
              :windowLength 4}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [quest-card/container card])])
