(ns quester.containers.root
  (:require [quester.react :refer [e] :as r]
            [quester.containers.left-nav-section :as left-nav-section]
            [quester.containers.right-nav-section :as right-nav-section]
            [quester.containers.main-carousel :as main-carousel]
            [quester.containers.selections-slider :as selections-slider]
            [quester.containers.best-quests-slider :as best-quests-slider]
            [quester.containers.reviews-slider :as reviews-slider]
            [quester.containers.new-quests-slider :as new-quests-slider]
            [quester.containers.companies-slider :as companies-slider]))

(defn container [props context]
  (let [deps {:LeftNavSection left-nav-section/container
              :RightNavSection right-nav-section/container
              :MainCarousel main-carousel/container
              :SelectionsSlider selections-slider/container
              :BestQuestsSlider best-quests-slider/container
              :ReviewsSlider reviews-slider/container
              :NewQuestsSlider new-quests-slider/container
              :CompaniesSlider companies-slider/container}
        state (.. context -state)
        element (:element state)]
    (e js/ui.IntlProvider {:locale "ru", :messages js/ui.messages}
       (e js/ui.DependencyProvider {:deps deps}
          element))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
