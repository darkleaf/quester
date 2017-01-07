(ns quester.containers.main-page.best-quests-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as common]
            [quester.containers.adapters.quest-card :as quest-card]))

(defn container [props]
  (let [data (.. props -data)
        models (:best-quests-cards data)]
    (e js/ui.Slider #js {:title "Лучшие квесты"
                         :totalCount 10
                         :seeAllUrl "/best"
                         :windowLength 4}
       (map #(e quest-card/container #js{:quest %, :key (::common/uuid %)}) models))))
