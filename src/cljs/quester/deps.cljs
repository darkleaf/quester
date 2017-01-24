(ns quester.deps
  (:require [quester.util.container :as container]
            [cljs-http.client :as http]))

(defn register [registry]
  (container/register
   registry

   :http/request
   (fn [_] http/request)

   :components.pages.quest/core
   (fn [resolve]
     (fn []
       [:a {:href "/"} "main"]))

   :components.pages.main/core
   (fn [resolve]
     (fn []
       (let [state (resolve :page/state)
             dispatch (resolve :page/dispatch)]
         [:div
          [:a {:href "/quests/1"} "quest 1"]])))))
