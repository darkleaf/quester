(ns quester.use-cases.welcome
  (:require [quester.use-cases.context :as context]))

(defprotocol WelcomeProtocol
  (foo [_]))

(defrecord Welcome [ctx]
  WelcomeProtocol
  (foo [_] "foo 124"))
