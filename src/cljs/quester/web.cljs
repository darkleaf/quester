(ns quester.web
  (:require [cognitect.transit :as t]
            [quester.react :refer [e] :as r]
            [quester.util.request-cache :as request-cache]
            [quester.containers.history :as history]))

;; HACK: TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

(enable-console-print!)

(defonce mount-point (.getElementById js/document "root"))
(defonce cache (request-cache/build))

(def payload
  (let [r (t/reader :json {:handlers {"u" cljs.core/uuid}})
        data (.-innerHTML (.getElementById js/document "payload"))]
    (t/read r data)))

(request-cache/put cache (:req-hash payload) (:data payload))

(defn restart []
  (js/ui.ReactDOM.render
   (e history/container #js {:cache cache})
   mount-point))
