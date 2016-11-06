(ns quester.use-cases
  (:require
   [quester.use-cases-deps.container :refer [inject]]
   [quester.use-cases.welcome :as welcome-uc]))

(def welcome (inject welcome-uc/perform))
