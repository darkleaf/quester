(ns quester.components.shared.quest-card
  (:require [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]))

(defn container [card url-for]
  [ui/quest-card {:name (::quest/name card)
                  :url (url-for :show [:quest] {:quest (::common/uuid card)})
                  :imageUrl (str "https://unsplash.it/300/210?image=" (rand-int 1000))
                  :priceMin (::quest-projection/price-min card)
                  :priceMax (::quest-projection/price-max card)
                  :participantsMin (::quest/participants-min card)
                  :participantsMax (::quest/participants-max card)
                  :rating (::quest-projection/total-rating card)}])
