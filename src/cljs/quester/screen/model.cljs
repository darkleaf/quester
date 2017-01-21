(ns quester.screen.model
  (:require [cljs.core.async :as a]))

;; Экран - это идентичность, выраженная, например атомом.
;; Страница - это значение экрана.

(defrecord Page [component state deps actions-receiver])

(defmulti handle-action :type)

(defn new-page [& {:as attrs}]
  (-> attrs
      (assoc :actions-receiver (a/chan))
      (map->Page)))

(defn modify-page [page action]
  (let [state (handle-action action)]
    (assoc page :state state)))

(defn replace-page [page new-page]
  (when page
    (a/close! (:actions-receiver page)))
  new-page)
