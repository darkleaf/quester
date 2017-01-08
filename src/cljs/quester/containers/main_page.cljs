(ns quester.containers.main-page
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.containers.main-page.main-carousel :as carousel]
            [quester.containers.main-page.reviews-slider :as reviews-slider]
            #_[quester.containers.main-page.best-quests-slider :as best-quests-slider]
            [quester.ui :as ui]))

(defn stub []
  [:div "stub"])

(defn container [data]
  [ui/main-page {:nav
                 (r/as-element [stub])

                 :main-carousel
                 (r/as-element [carousel/container])

                 :selections-slider
                 (r/as-element [stub])

                 :best-quests-slider
                 (r/as-element [stub])

                 :reviews-slider
                 (r/as-element
                  [reviews-slider/container (r/cursor data [:reviews-cards])])

                 :new-quests-slider
                 (r/as-element [stub])

                 :companies-slider
                 (r/as-element [stub])}])
