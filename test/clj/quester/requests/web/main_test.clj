(ns quester.requests.web.main-test
  (:require [clojure.test :refer [deftest testing is]]
            [ring.mock.request :as mock]
            [ring.util.http-predicates :as http-predicates]
            [darkleaf.router :as r]
            [quester.routes.core :refer [build-routes]]
            [quester.use-cases.protocols.persistence.quests :as persistence.quests]))

(deftest main
  (testing :show
    (let [ctx (reify
                persistence.quests/NewCards
                (-new-cards [_ limit])
                persistence.quests/BestCards
                (-best-cards [_ limit]))
          handler (r/make-handler (build-routes))
          req (-> (mock/request :get "/")
                  (assoc :quester/ctx ctx))
          resp (handler req)]
      (is (http-predicates/success? resp)))))
