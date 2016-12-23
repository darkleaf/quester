(ns quester.web
  (:require [pushy.core :as pushy]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]
            [quester.frontend :as f]
            [quester.react :refer [e] :as react]
            [quester.containers.left-nav-section :as left-nav-section]
            [quester.containers.right-nav-section :as right-nav-section]
            [quester.containers.main-carousel :as main-carousel]
            [quester.containers.selections-slider :as selections-slider]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(def handler (router/make-handler web-routes/routes))

(def root (.getElementById js/document "root"))

(defn dispatch-h [element] (f/ReactDOM.render element root))

(defn match-h [uri] (handler {:uri uri, :request-method :get}))

(def history (pushy/pushy dispatch-h match-h))

(pushy/start! history)

(comment
  (pushy/replace-token! history "/"))
