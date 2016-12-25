(ns quester.web
  (:require [pushy.core :as pushy]
            [cognitect.transit :as t]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]
            [quester.frontend :as f]
            [quester.react :refer [e]]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(def init-data
  (let [r (t/reader :json)
        data (.-innerHTML (.getElementById js/document "init-data"))]
   (t/read r data)))

(def handler (router/make-handler web-routes/routes))

(def root (.getElementById js/document "root"))
(def history)

(defn dependency-provider-builder [deps]
  (f/dependencyProviderBuilder "deps" (clj->js deps)))

(defn wrap-deps [handler deps]
  (fn [req]
    (let [element (handler req)
          dependency-provider (dependency-provider-builder deps)]
      (e dependency-provider {} element))))

(defn handle [uri]
  (let [req {:uri uri, :request-method :get}
        initial-state init-data
        page-state (atom initial-state)
        deps {:pageState page-state}

        handler (-> handler (wrap-deps deps))
        element (handler req)

        render #(f/ReactDOM.render element root)]

    (when element
      (add-watch page-state :rerender (fn [_key _ref _old _new] (render)))
      (render))))


(def history (pushy/pushy handle identity))

(pushy/start! history)

(comment
  (pushy/replace-token! history "/"))
