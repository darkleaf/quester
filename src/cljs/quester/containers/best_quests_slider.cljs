(ns quester.containers.best-quests-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.quest :as quest]))

(defn container [props context]
  (let [state (.. context -state)
        quests (get-in @state [:page :best-quests-cards])
        quest->element (fn [quest]
                         (e js/ui.QuestCard
                            {:key (::c/uuid quest)
                             :name (::quest/name quest)
                             :imageUrl "http://placehold.it/300x210"
                             :priceMin 1000
                             :priceMax 5000
                             :participantsMin 2
                             :participantsMax 5
                             :rating 9.3}))]
    (e js/ui.Slider {:title "Лучшие квесты"
                     :totalCount 10
                     :seeAllUrl "/best"
                     :windowLength 4}
       (map quest->element quests))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
