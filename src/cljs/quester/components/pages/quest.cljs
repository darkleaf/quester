(ns quester.components.pages.quest
  (:require
   [reagent.core :as reagent]
   [quester.use-cases.quests.show :as uc]
   [quester.ui :as ui]
   [quester.components.shared.nav :as nav]
   [quester.entities.quest :as quest]
   [quester.projections.quest :as quest-projection]))

(defn gallery []
  [ui/gallery {:imageUrls ["http://placehold.it/991x495/555"
                           "http://placehold.it/990x495/222"
                           "http://placehold.it/992x495"]}])

(defn description [use-case]
  (let [quest-page (uc/get-quest-page use-case)]
    [ui/quest-description {:name (::quest/name quest-page)
                           :description (::quest/description quest-page)
                           :rating (::quest-projection/total-rating quest-page)
                           :commentsCount (::quest-projection/comments-count quest-page)}]))

(defn schedule []
  [ui/quest-schedule])

(defn location []
  [ui/quest-location])

(defn similar-quests []
  [:div "foo"])

(defn add-to-favorite []
  [:div "add to favorite"])

(defn booking []
  [:div {:style {:height "100px"
                 :border "1px gray solid"}}
   "quest booking form"])

(defn component [use-case]
  (js/console.log use-case)

  [ui/quest-page {:nav (reagent/as-element [nav/container])
                  :gallery (reagent/as-element [gallery])
                  :similar-quests (reagent/as-element [similar-quests])
                  :description (reagent/as-element [description use-case])
                  :schedule (reagent/as-element [schedule])
                  :location (reagent/as-element [location])
                  :add-to-favorite (reagent/as-element [add-to-favorite])
                  :booking (reagent/as-element [booking])}])
