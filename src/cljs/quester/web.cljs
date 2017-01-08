(ns quester.web
  (:require [reagent.core :as r]
            [cognitect.transit :as t]
            [quester.containers.history :as history]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(def mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json {:handlers {"u" cljs.core/uuid}})]
    (t/read r text)))

(defonce state (r/atom {}))

(def initial-data (-> (.getElementById js/document "initial-data")
                      (.-innerHTML)
                      (read-transit)))

(defn restart []
  (r/render-component [history/container :state state, :initial-data initial-data]
                      mount-point))
