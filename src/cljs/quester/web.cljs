(ns quester.web
  (:require [pushy.core :as pushy]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]
            [quester.frontend :as f]
            [quester.react :refer [e] :as react]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(defn left-nav-section-container []
  (e f/NavSection {}
     (e f/NavBrand {:name "Quester"})
     (e f/NavItem {:name "Квесты"})
     (e f/NavItem {:name "Подборки"})
     (e f/NavItem {:name "Обзоры"})
     (e f/NavItem {:name "Компании"})
     (e f/NavSearch {})))

(defn right-nav-section-container []
  (e f/NavSection {}
     (e f/NavItem {:name "Москва"})
     (e f/NavItem {:name "Избранное"})
     (e f/NavItem {:name "Выйти"})))

(defn main-carousel-container []
  (e f/MainCarousel {:title "<b>Москва 2048,</b> Клаустрофобия"
                     :currentImageUrl "http://placehold.it/1900x500"
                     :indicators [{:onClick (constantly nil)}
                                  {:onClick (constantly nil), :active  true}
                                  {:onClick (constantly nil)}]}
     (e f/MainFilter {})))

(def selections-slider-container
  (react/create-class
   :displayName "SelectionsSliderContainer"
   :render (fn []
            (e f/Slider {:title "Подборки квестов"
                         :totalCount 26
                         :seeAllUrl "/selections"}
               "hello 11"))))

(def deps
  {:LeftNavSection left-nav-section-container
   :RightNavSection right-nav-section-container
   :MainCarousel main-carousel-container
   :SelectionsSlider selections-slider-container
   :BestQuestsSlider #(e "div" {} "b")
   :ReviewsSlider #(e "div" {} "r")
   :NewQuestsSlider #(e "div" {} "n")
   :CompaniesSlider #(e "div" {} "c")})


(def render f/ReactDOM.render)
(def root (.getElementById js/document "root"))

(defn dispatch-h [element]
  (prn history)
  (render
   (e f/IntlProvider {:locale "ru", :messages f/messages}
      (e DependencyProvider {}
         element))
   root))

(def handler (router/make-handler web-routes/routes))
(defn match-h [uri] (handler {:uri uri, :request-method :get}))

(def history (pushy/pushy dispatch-h match-h))
(def DependencyProvider
  (f/dependencyProviderBuilder (clj->js deps)))

(pushy/start! history)



(comment
  (pushy/replace-token! history "/"))
