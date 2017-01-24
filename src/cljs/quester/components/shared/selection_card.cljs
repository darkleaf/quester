(ns quester.components.shared.selection-card
  (:require [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]))

(defn container [card]
  [ui/selection-card {:name (::selection/name card)
                      :imageUrl (str "https://unsplash.it/300/300?image=" (rand-int 1000))}])
