(ns quester.deps.other
  (:require [quester.util.container :as container]
            [cljs-http.client :as http]))

(defn register [registry]
  (container/register
   registry

   :http/request
   (fn [_] http/request)))
