(ns quester.containers.adapters.quest-card
  (:require [quester.util.url-helpers :as url-helpers]
            [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]))

(def container
  (url-helpers/wrapper
   (fn container [{:keys [url-for]} card]
     [ui/quest-card {:name (::quest/name card)
                     :url (url-for :show [:quest] {:quest-id (::common/uuid card)})
                     :imageUrl (str "https://unsplash.it/300/210?image=" (rand-int 1000))
                     :priceMin (::quest-projection/price-min card)
                     :priceMax (::quest-projection/price-max card)
                     :participantsMin (::quest/participants-min card)
                     :participantsMax (::quest/participants-max card)
                     :rating (::quest-projection/total-rating card)}])))
