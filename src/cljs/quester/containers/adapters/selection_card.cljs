(ns quester.containers.adapters.selection-card
  (:require #_[quester.util.url :refer [url-for]]
            [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.entities.selection :as selection]))

(defn container [card]
  [ui/selection-card {:name (::selection/name card)
                      :imageUrl (str "https://unsplash.it/300/300?image=" (rand-int 1000))}])
