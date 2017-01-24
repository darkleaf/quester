(ns quester.components.shared.review-card
  (:require [quester.ui :as ui]
            [quester.entities.review :as review]))

(defn container [card]
  [ui/review-card {:name (::review/name card)
                   :image-url (str "https://unsplash.it/300/350?image=" (rand-int 1000))}])
