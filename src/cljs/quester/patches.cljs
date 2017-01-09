(ns quester.patches
  (:require [com.cognitect.transit.types :as ty]))

;; TypeError: Cannot convert a Symbol value to a string
(extend-protocol IPrintWithWriter
  js/Symbol
  (-pr-writer [sym writer _]
    (-write writer (str "\"" (.toString sym) "\""))))

;; cljs.core/uuid? not work with ty/UUID
;; https://github.com/cognitect/transit-cljs/issues/18
(extend-type ty/UUID
  IUUID)
