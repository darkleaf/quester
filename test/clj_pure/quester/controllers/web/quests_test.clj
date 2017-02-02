(ns quester.controllers.web.quests-test
  (:require [clojure.test :refer [deftest is]]
            [quester.test-utils.request :refer [testing-page]]))

(deftest show (testing-page "/quests/1"))
