(ns quester.containers.quest-page
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.containers.shared.nav :as nav]))


(defn stub []
  [:div "stub"])


(defn gallery []
  [ui/gallery {:left "http://placehold.it/991x495/555"
               :center "http://placehold.it/990x495/222"
               :right "http://placehold.it/992x495"}])

(defn description []
  [ui/quest-description])

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
                   [description])

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
