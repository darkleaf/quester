(ns quester.containers.companies-slider
  (:require [quester.react :refer [e]]
            [quester.entities.common :as c]
            [quester.entities.company :as company]))

(defn container [props context]
  (let [state (.. context -state)
        companies (get-in state [:page :companies-cards])
        company->element (fn [company]
                           (e js/ui.CompanyCard
                              {:key (::c/uuid company)
                               :name (::company/name company)
                               :imageUrl "http://placehold.it/190x140"
                               :questCount 3}))]
    (e js/ui.Slider {:title "Компании"
                     :totalCount 25
                     :seeAllUrl "/companies"
                     :windowLength 6}
       (map company->element companies))))

(aset container
      "contextTypes"
      (js-obj "state" js/ui.React.PropTypes.any.isRequired))
