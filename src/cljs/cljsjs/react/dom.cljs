(ns cljsjs.react.dom
  (:require [js.ui]))

(aset js/window "ReactDOM" (js/ui "ReactDOM"))
