(ns quester.containers.quest-page
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.containers.shared.nav :as nav]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]))

(defn gallery []
  [ui/gallery {:imageUrls ["http://placehold.it/991x495/555"
                           "http://placehold.it/990x495/222"
                           "http://placehold.it/992x495"]}])

(defn description [page-ratom]
  [ui/quest-description {:name (::quest/name @page-ratom)
                         :description (::quest/description @page-ratom)
                         :rating (::quest-projection/total-rating @page-ratom)
                         :commentsCount (::quest-projection/comments-count @page-ratom)}])


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

(defn container [data]
  [ui/quest-page {:nav
                  (r/as-element [nav/container])

                  :gallery
                  (r/as-element [gallery])

                  :similarQuests
                  (r/as-element
                   [similar-quests])

                  :description
                  (r/as-element
                   [description (r/cursor data [:quest-page])])

                  :schedule
                  (r/as-element
                   [schedule])

                  :location
                  (r/as-element
                   [location])

                  :addToFavorite
                  (r/as-element
                   [add-to-favorite])

                  :booking
                  (r/as-element
                   [booking])}])
