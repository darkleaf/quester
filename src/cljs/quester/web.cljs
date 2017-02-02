(ns quester.web
  (:require [quester.patches]
            [mount.core :as mount]
            [reagent.core :as r]
            [cognitect.transit :as t]
            [quester.util.container :as container]
            [quester.screen :refer [screen]]
            [quester.deps :as deps]))

(enable-console-print!)

(def mount-point (.getElementById js/document "root"))

(defn read-transit [text]
  (let [r (t/reader :json)]
    (t/read r text)))

(def initial-state (-> (.getElementById js/document "initial-data")
                       (.-innerHTML)
                       (read-transit)))

(defonce screen-identity (r/atom nil))

(defn restart []
  (mount/stop)
  (mount/start)
  (let [deps-container (-> (container/build)
                           (deps/register))]

    (r/render-component
     [screen screen-identity deps-container initial-state]
     mount-point)))
