(ns quester.ui
  (:require [reagent.core :as r]))

;; это не будет перезагружаться нагорячую =(

(def nprogress js/ui.NProgress)

(def wrapper (r/adapt-react-class js/ui.Wrapper))

(def main-page (r/adapt-react-class js/ui.MainPage))
(def quest-page (r/adapt-react-class js/ui.QuestPage))

(def nav (r/adapt-react-class js/ui.Nav))
(def nav-section (r/adapt-react-class js/ui.NavSection))
(def nav-brand (r/adapt-react-class js/ui.NavBrand))
(def nav-item (r/adapt-react-class js/ui.NavItem))
(def nav-search (r/adapt-react-class js/ui.NavSearch))

(def main-carousel (r/adapt-react-class js/ui.MainCarousel))
(def main-filter (r/adapt-react-class js/ui.MainFilter))
(def slider (r/adapt-react-class js/ui.Slider))
(def gallery (r/adapt-react-class js/ui.Gallery))

(def selection-card (r/adapt-react-class js/ui.SelectionCard))
(def quest-card (r/adapt-react-class js/ui.QuestCard))
(def review-card (r/adapt-react-class js/ui.ReviewCard))
(def company-card (r/adapt-react-class js/ui.CompanyCard))

(def quest-similar-quests (r/adapt-react-class js/ui.QuestSimilarQuests))
(def quest-description (r/adapt-react-class js/ui.QuestDescription))
(def quest-schedule (r/adapt-react-class js/ui.QuestSchedule))
(def quest-location (r/adapt-react-class js/ui.QuestLocation))
