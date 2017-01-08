(ns quester.containers.adapters.review-card
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.entities.review :as review]))

(defn container [model]
  [ui/review-card {:name (::review/name model)
                   :image-url (str "https://unsplash.it/300/350?image=" (rand-int 1000))}])
