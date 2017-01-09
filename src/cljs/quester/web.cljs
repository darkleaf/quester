(ns quester.web
  (:require [quester.patches]
            [reagent.core :as r]
            [cognitect.transit :as t]
            [quester.containers.history :as history]))


(enable-console-print!)

(def mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json)]
    (t/read r text)))

(defonce state (r/atom {}))

(def initial-data (-> (.getElementById js/document "initial-data")
                      (.-innerHTML)
                      (read-transit)))

(defn restart []
 (r/render-component [history/container :state state, :initial-data initial-data]
                    mount-point))
