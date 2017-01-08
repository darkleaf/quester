(ns quester.containers.main-page
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.containers.main-page.main-carousel :as carousel]
            [quester.containers.main-page.reviews-slider :as reviews-slider]
            [quester.containers.main-page.best-quests-slider :as best-quests-slider]
            [quester.containers.main-page.companies-slider :as companies-slider]
            [quester.containers.main-page.selections-slider :as selections-slider]
            [quester.containers.main-page.new-quests-slider :as new-quests-slider]
            [quester.containers.shared.nav :as nav]
            [quester.ui :as ui]))

(defn stub []
  [:div "stub"])

(defn container [data]
  [ui/main-page {:nav
                 (r/as-element [nav/container])

                 :main-carousel
                 (r/as-element [carousel/container])

                 :selections-slider
                 (r/as-element
                  [selections-slider/container (r/cursor data [:selections-cards])])

                 :best-quests-slider
                  (r/as-element
                   [best-quests-slider/container (r/cursor data [:best-quests-cards])])

                 :reviews-slider
                 (r/as-element
                  [reviews-slider/container (r/cursor data [:reviews-cards])])

                 :new-quests-slider
                 (r/as-element
                  [new-quests-slider/container (r/cursor data [:new-quests-cards])])

                 :companies-slider
                 (r/as-element
                  [companies-slider/container (r/cursor data [:companies-cards])])}])
