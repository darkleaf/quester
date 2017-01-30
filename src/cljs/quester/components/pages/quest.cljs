(ns quester.components.pages.quest
  (:require [reagent.core :as r]
            [quester.ui :as ui]
            [quester.entities.quest :as quest]
            [quester.projections.quest :as quest-projection]))

(defn gallery []
  [ui/gallery {:imageUrls ["http://placehold.it/991x495/555"
                           "http://placehold.it/990x495/222"
                           "http://placehold.it/992x495"]}])

(defn description [state]
  (let [quest-page (:quest-page state)]
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


(defn page [& {:as reagent-elements}]
  (assert (= (-> reagent-elements keys set)
             #{:nav
               :gallery
               :similar-quests
               :description
               :schedule
               :location
               :add-to-favorite
               :booking}))
  (let [react-elements (reduce-kv
                        (fn [acc k v] (assoc acc k (r/as-element v)))
                        {}
                        reagent-elements)]
    [ui/quest-page react-elements]))
