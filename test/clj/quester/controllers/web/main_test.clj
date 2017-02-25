(ns quester.controllers.web.main-test
  (:require [clojure.test :refer [deftest is]]
            [quester.test-utils.request :refer [testing-page]]))

(deftest show (testing-page "/"))
