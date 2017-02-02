(ns quester.test-utils.request
  (:require [clojure.test :refer [testing is]]
            [clojure.string :as str]
            [darkleaf.router :as r]
            [quester.routes.core :refer [routes]]
            [quester.util.container :as container]
            [quester.deps.db :as db-deps]
            [quester.deps.use-cases :as use-cases-deps]))

(defn make-handler []
  (let [registry (-> (container/build)
                     (db-deps/register)
                     (use-cases-deps/register))
        original-handler (r/make-handler @routes)]
    (fn [req]
      (-> req
          (assoc :deps-registry registry)
          (original-handler)))))

(defn testing-page [uri]
  (testing (str "page: " uri)
    (let [handler (make-handler)
          req {:uri uri, :request-method :get}]
      (testing :html
        (let [resp (handler req)]
          (is (= 200 (:status resp)))
          (is (str/includes?
               (get-in resp [:headers "Content-Type"])
               "text/html"))))
      (testing :transit
        (let [req (assoc-in req [:headers "accept"] "application/transit+json")
              resp (handler req)]
          (is (= 200 (:status resp)))
          (is (str/includes?
               (get-in resp [:headers "Content-Type"])
               "application/transit+json")))))))
