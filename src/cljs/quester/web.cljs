(ns quester.web
  (:require [cognitect.transit :as t]
            [quester.react :refer [e] :as r]
            [quester.util.request-cache :as cache]
            [quester.containers.history :as history]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(def payload
  (let [r (t/reader :json {:handlers {"u" cljs.core/uuid}})
        data (.-innerHTML (.getElementById js/document "payload"))]
   (t/read r data)))

(defonce mount-point (.getElementById js/document "root"))

(defonce app-state (atom (-> {}
                             (cache/put (:req-hash payload)
                                        (:data payload)))))

(defn restart []
  (js/ui.ReactDOM.render
   (e history/container #js {:atom app-state})
   mount-point))
