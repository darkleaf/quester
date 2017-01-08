(ns quester.containers.main-page.companies-slider
  (:require [quester.ui :as ui]
            [quester.entities.common :as common]
            [quester.containers.adapters.company-card :as company-card]))

(defn container [cards-ratom]
  [ui/slider  {:title "Компании"
               :totalCount 25
               :seeAllUrl "/companies"
               :windowLength 6}
   (for [card @cards-ratom]
     ^{:key (::common/uuid card)} [company-card/container card])])
