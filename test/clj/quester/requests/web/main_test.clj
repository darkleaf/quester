(ns quester.requests.web.main-test
  (:require [clojure.test :refer [deftest testing is]]
            [ring.mock.request :as mock]
            [ring.util.http-predicates :as http-predicates]
            [darkleaf.router :as r]
            [quester.routes.core :refer [build-routes]]
            [quester.use-cases.protocols.queries :as queries]))

(deftest main
  (testing :show
    (let [handler (r/make-handler (build-routes))
          ctx (reify
                queries/GetNewQuestsCards
                (-get-new-quests-cards [_ limit]
                  [])
                queries/GetBestQuestsCards
                (-get-best-quests-cards [_ limit]
                  [])
                queries/GetCompnaiesCards
                (-get-companies-cards [_ limit]
                  [])
                queries/GetSelectionsCards
                (-get-selections-cards [_ limit]
                  [])
                queries/GetReviewsCards
                (-get-reviews-cards [_ limit]
                  []))
          req (-> (mock/request :get "/")
                  (assoc :quester/ctx ctx))
          resp (handler req)]
      (is (http-predicates/success? resp)))))
