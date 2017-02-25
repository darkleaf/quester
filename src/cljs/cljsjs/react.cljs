(ns cljsjs.react
  (:require [js.ui]))

(aset js/window "React" (js/ui "React"))
