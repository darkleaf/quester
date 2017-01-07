(ns quester.containers.adapters.quest-card
  (:require [quester.react :refer [e]]
            [quester.util.url :refer [url-for]]
            [quester.entities.common :as common]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]))

(defn container [props]
  (let [model (.. props -quest)]
    (e js/ui.QuestCard
       #js {:name (::quest/name model)
            :url (url-for :show [:quest] {:quest-id (::common/uuid model)})
            :imageUrl (str "https://unsplash.it/300/210?image=" (rand-int 1000))
            :priceMin (::quest-projection/price-min model)
            :priceMax (::quest-projection/price-max model)
            :participantsMin (::quest/participants-min model)
            :participantsMax (::quest/participants-max model)
            :rating (::quest-projection/total-rating model)})))
