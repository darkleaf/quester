(ns quester.deps.use-cases
  (:require [quester.container :as c]
            [quester.use-cases.welcome :as uc-welcome]))

(c/register :use-cases/welcome
            (fn [resolve]
              (partial uc-welcome/perform
                       {:selections  (resolve :db/main-selections)
                        :best-quests (resolve :db/main-best-quests)
                        :reviews     (resolve :db/main-reviews)})))
