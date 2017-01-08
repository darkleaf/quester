(ns quester.ui
  (:require [reagent.core :as r]))

;; это не будет перезагружаться нагорячую =(

(def wrapper (r/adapt-react-class js/ui.Wrapper))

(def main-page (r/adapt-react-class js/ui.MainPage))
(def quest-page (r/adapt-react-class js/ui.QuestPage))

(def nav-selection (r/adapt-react-class js/ui.NavSection))
(def nav-brand (r/adapt-react-class js/ui.NavBrand))
(def nav-item (r/adapt-react-class js/ui.NavItem))
(def nav-search (r/adapt-react-class js/ui.NavSearch))

(def main-carousel (r/adapt-react-class js/ui.MainCarousel))
(def main-filter (r/adapt-react-class js/ui.MainFilter))
(def slider (r/adapt-react-class js/ui.Slider))

(def selection-card (r/adapt-react-class js/ui.SelectionCard))
(def quest-card (r/adapt-react-class js/ui.QuestCard))
(def review-card (r/adapt-react-class js/ui.ReviewCard))
(def company-card (r/adapt-react-class js/ui.CompanyCard))
