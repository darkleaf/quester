(ns quester.middlewares.web
  (:require [quester.react :refer [e]]
            [quester.containers.left-nav-section :as left-nav-section]
            [quester.containers.right-nav-section :as right-nav-section]
            [quester.containers.main-carousel :as main-carousel]
            [quester.containers.selections-slider :as selections-slider]))

(def ^:private deps
  {:LeftNavSection left-nav-section/container
   :RightNavSection right-nav-section/container
   :MainCarousel main-carousel/container
   :SelectionsSlider selections-slider/container
   :BestQuestsSlider #(e "div" {} "b")
   :ReviewsSlider #(e "div" {} "r")
   :NewQuestsSlider #(e "div" {} "n")
   :CompaniesSlider #(e "div" {} "c")})

(def DependencyProvider
  (js/ui.dependencyProviderBuilder "containers" (clj->js deps)))

(defn add-deps [handler]
  (fn [req]
    (let [element (handler req)]
      (e js/ui.IntlProvider {:locale "ru", :messages js/ui.messages}
         (e DependencyProvider {}
            element)))))

(def middleware (comp add-deps))
