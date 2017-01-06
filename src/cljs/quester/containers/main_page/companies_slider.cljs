(ns quester.containers.main-page.companies-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.company :as company]))

(defn container [props context]
  (let [state (.. context -state)
        companies (get-in state [:page :companies-cards])
        company->element (fn [company]
                           (e js/ui.CompanyCard
                              #js {:key (::c/uuid company)
                                   :name (::company/name company)
                                   :imageUrl (str "https://unsplash.it/190/140?image=" (rand-int 1000))
                                   :questCount 3}))]
    (e js/ui.Slider #js {:title "Компании"
                         :totalCount 25
                         :seeAllUrl "/companies"
                         :windowLength 6}
       (map company->element companies))))

(aset container
      "contextTypes"
      #js {:state js/ui.React.PropTypes.any.isRequired})
