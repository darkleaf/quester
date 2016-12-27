(ns quester.web
  (:require [pushy.core :as pushy]
            [cognitect.transit :as t]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]
            [quester.react :refer [e] :as r]
            [quester.containers.left-nav-section :as left-nav-section]
            [quester.containers.right-nav-section :as right-nav-section]
            [quester.containers.main-carousel :as main-carousel]
            [quester.containers.selections-slider :as selections-slider]
            [quester.containers.best-quests-slider :as best-quests-slider]
            [quester.containers.reviews-slider :as reviews-slider]
            [quester.containers.new-quests-slider :as new-quests-slider]
            [quester.containers.companies-slider :as companies-slider]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(def init-page-data
  (let [r (t/reader :json {:handlers {"u" cljs.core/uuid}})
        data (.-innerHTML (.getElementById js/document "init-data"))]
   (t/read r data)))

(def root (.getElementById js/document "root"))

(defonce state (atom {:page init-page-data}))
(defonce history (atom nil))

(def ^:private deps
  {:LeftNavSection left-nav-section/container
   :RightNavSection right-nav-section/container
   :MainCarousel main-carousel/container
   :SelectionsSlider selections-slider/container
   :BestQuestsSlider best-quests-slider/container
   :ReviewsSlider reviews-slider/container
   :NewQuestsSlider new-quests-slider/container
   :CompaniesSlider companies-slider/container})

(def state-provider
  (r/create-class
   :childContextTypes {:state js/ui.React.PropTypes.any.isRequired}
   :propTypes         {:state js/ui.React.PropTypes.any.isRequired}
   :getChildContext (fn []
                      (this-as this
                        (js-obj "state" (.. this -props -state))))
   :render (fn []
             (this-as this
               (e "div" {} (.. this -props -children))))))

(defn restart []
  (when @history
    (pushy/stop! @history))
  (let [handler (comp (router/make-handler web-routes/routes)
                     (fn [uri] {:uri uri, :request-method :get}))
        dispatch (fn [element]
                   (js/ui.ReactDOM.render
                    (e state-provider {:state state}
                       (e js/ui.IntlProvider {:locale "ru", :messages js/ui.messages}
                          (e js/ui.DependencyProvider (clj->js {:deps deps})
                             element)))
                    root))]
   (reset! history (pushy/pushy dispatch handler)))
 (pushy/start! @history))


(comment
  (pushy/replace-token! history "/"))
