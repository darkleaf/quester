(ns quester.web
  (:require [quester.patches]
            [reagent.core :as r]
            [cognitect.transit :as t]
            [cljs-http.client :as http]
            [quester.util.container :as container]
            [quester.screen.components :as screen-c]))

(enable-console-print!)

(def mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json)]
    (t/read r text)))

(defonce screen-identity (r/atom nil))

(def initial-data (-> (.getElementById js/document "initial-data")
                      (.-innerHTML)
                      (read-transit)))

(defn restart []
  (let [initial-deps (-> (container/build)
                         (container/register :http/request (fn [_] http/request)))]
    (r/render-component
     [screen-c/screen screen-identity initial-data initial-deps]
     mount-point)))
