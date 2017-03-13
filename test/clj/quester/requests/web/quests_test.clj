(ns quester.requests.web.quests-test
  (:require [clojure.test :refer [deftest testing is]]
            [ring.mock.request :as mock]
            [ring.util.http-predicates :as http-predicates]
            [darkleaf.router :as r]
            [quester.routes.core :refer [build-routes]]
            [quester.use-cases.protocols.queries :as queries]))

(deftest quests
  (testing :show
    (let [handler (r/make-handler (build-routes))
          ctx (reify
                queries/FindQuestPage
                (-find-quest-page [_ id]
                  nil))
          req (-> (mock/request :get "/quests/1")
                  (assoc :quester/ctx ctx))
          resp (handler req)]
      (is (http-predicates/success? resp)))))
