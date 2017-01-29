(ns quester.deps.pages.quest
  (:require [quester.util.container :as container]
            [quester.components.pages.quest :as quest-page]
            [quester.components.shared.nav :as nav]))

(defn register [registry]
  (container/register
   registry

   :components.pages.quest/description
   (fn [resolve]
     (fn description-container []
       [quest-page/description
        (resolve :page/state)]))

   :components.pages/quest
   (fn [resolve]
     (fn quest-page-container []
       [quest-page/page
        :nav [nav/container]
        :gallery [quest-page/gallery]
        :similar-quests [:div "stub"]
        :description [(resolve :components.pages.quest/description)]
        :schedule [quest-page/schedule]
        :location [quest-page/location]
        :add-to-favorite [quest-page/add-to-favorite]
        :booking [quest-page/booking]]))))
