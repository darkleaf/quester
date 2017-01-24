(ns quester.components.shared.company-card
  (:require [quester.ui :as ui]
            [quester.entities.company :as company]))

(defn container [card]
  [ui/company-card {:name (::company/name card)
                    :imageUrl (str "https://unsplash.it/190/140?image=" (rand-int 1000))
                    :questCount 7}])
