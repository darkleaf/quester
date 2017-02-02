(ns quester.deps.shared
  (:require [quester.util.container :as container]
            [quester.components.shared.selection-card :as selection-card]
            [quester.components.shared.review-card :as review-card]
            [quester.components.shared.quest-card :as quest-card]
            [quester.components.shared.company-card :as company-card]
            [quester.components.shared.nav :as nav]))


(defn register [registry]
  (container/register
   registry

   :components.shared/selection-card
   (fn [_] selection-card/container)

   :components.shared/review-card
   (fn [_] review-card/container)

   :components.shared/quest-card
   (fn [resolve]
     (fn quest-card-container [card]
       [quest-card/container
        card
        (resolve :routing/url-for)]))

   :components.shared/company-card
   (fn [_] company-card/container)

   :components.shared/nav
   (fn [_] nav/container)))
