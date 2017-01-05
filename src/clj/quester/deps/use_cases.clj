(ns quester.deps.use-cases
  (:require [quester.container :as c]
            [quester.use-cases.welcome :as uc-welcome]
            [quester.use-cases.quest-show :as uc-quest-show]))

(c/register :use-cases/welcome
            (fn [resolve]
              (partial uc-welcome/perform
                       {:selections-cards  (resolve :db/selections-cards)
                        :best-quests-cards (resolve :db/best-quests-cards)
                        :reviews-cards     (resolve :db/reviews-cards)
                        :new-quests-cards  (resolve :db/new-quests-cards)
                        :companies-cards   (resolve :db/companies-cards)})))

(c/register :use-cases/quest-show
            (fn [resolve]
              (partial uc-quest-show/perform
                       {:find-quest (resolve :db/find-quest)})))
