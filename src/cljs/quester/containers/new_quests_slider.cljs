(ns quester.containers.new-quests-slider
  (:require [quester.react :refer [e]]
            [quester.util.url :refer [url-for]]
            [quester.entities.common :as c]
            [quester.entities.quest :as quest]))

(defn container [props context]
  (let [state (.. context -state)
        quests (get-in state [:page :new-quests-cards])
        quest->element (fn [quest]
                         (e js/ui.QuestCard
                            {:key (::c/uuid quest)
                             :name (::quest/name quest)
                             :url (url-for :show [:quest] {:quest-id (::c/uuid quest)})
                             :imageUrl (str "https://unsplash.it/300/210?image=" (rand-int 1000))
                             :priceMin 1000
                             :priceMax 5000
                             :participantsMin (::quest/participants-min quest)
                             :participantsMax (::quest/participants-max quest)
                             :rating 9.3}))]
    (e js/ui.Slider {:title "Новые квесты"
                     :totalCount 10
                     :seeAllUrl "/quests"
                     :windowLength 4}
       (map quest->element quests))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
