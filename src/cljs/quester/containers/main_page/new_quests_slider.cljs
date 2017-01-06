(ns quester.containers.main-page.new-quests-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as common]
            [quester.containers.quest-card :as quest-card]))

(defn container [props context]
  (let [state (.. context -state)
        models (get-in state [:page :new-quests-cards])]
    (e js/ui.Slider #js {:title "Новые квесты"
                         :totalCount 10
                         :seeAllUrl "/quests"
                         :windowLength 4}
       (map #(e quest-card/container #js {:quest %, :key (::common/uuid %)}) models))))

(aset container
      "contextTypes"
      #js {:state js/ui.React.PropTypes.any.isRequired})
