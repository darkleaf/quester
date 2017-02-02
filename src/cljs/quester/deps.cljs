(ns quester.deps
  (:require [quester.util.container :as container]
            [quester.deps.shared :as shared]
            [quester.deps.pages.main :as main-page]
            [quester.deps.pages.quest :as quest-page]
            [quester.deps.routing :as routing]
            [quester.deps.other :as other]))

(defn register [registry]
  (-> registry
      (shared/register)
      (main-page/register)
      (quest-page/register)
      (routing/register)
      (other/register)))
