(ns quester.web
  (:require [cognitect.transit :as t]
            [quester.react :refer [e] :as r]
            [quester.containers.history :as history]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(defonce mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json {:handlers {"u" cljs.core/uuid}})]
    (t/read r text)))

(defn restart []
  (let [initial-data (when-let [el (.getElementById js/document "initial-data")]
                       (let [text (.-innerHTML el)]
                         (.remove el)
                         (read-transit text)))]
    (js/ui.ReactDOM.render
     (e history/container #js{:initialData initial-data})
     mount-point)))
