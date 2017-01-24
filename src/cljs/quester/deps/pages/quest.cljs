(ns quester.deps.pages.quest
  (:require [quester.util.container :as container]))

(defn register [registry]
  (container/register
   registry

   :components.pages/quest
   (fn [resolve]
     (fn []
       [:a {:href "/"} "main"]))))
