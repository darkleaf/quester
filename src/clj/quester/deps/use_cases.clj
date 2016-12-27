(ns quester.deps.use-cases
  (:require [quester.container :as c]
            [quester.use-cases.welcome :as uc-welcome]))

(c/register :use-cases/welcome
            (fn [resolve]
              (partial uc-welcome/perform
                       {:selections-cards  (resolve :db/selections-cards)
                        :best-quests-cards (resolve :db/best-quests-cards)
                        :reviews-cards     (resolve :db/reviews-cards)
                        :new-quests-cards  (resolve :db/new-quests-cards)
                        :companies-cards   (resolve :db/companies-cards)})))
