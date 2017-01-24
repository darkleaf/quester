(ns quester.screen
  (:require [reagent.core :as r]
            [pushy.core :as pushy]
            [darkleaf.router :as router]
            [quester.routes.web :as web-routes]
            [quester.util.container :as c]
            [cljs.core.async :as a])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defrecord Screen [component db req])

(def ^:private handler (router/make-handler web-routes/routes))
(def ^:private request-for (router/make-request-for web-routes/routes))

(defn- matcher [uri]
  (let [req {:uri uri, :request-method :get}]
    (handler req)))

(defn history [screen-identity deps initial-state]
  (let [initial-dispatch
        (fn [{:keys [component req]}]
          (reset! screen-identity (Screen. component
                                           (r/atom initial-state)
                                           req)))

        usual-dispatch
        (fn [{:keys [component req]}]
          (when (not= req (:req @screen-identity))
            (let [http-request (c/resolve deps :http/request)
                  api-req (assoc-in req [:headers "accept"] "application/transit+json")]
              (go
                (let [api-response (<! (http-request api-req))
                      state (:body api-response)]
                  (reset! screen-identity (Screen. component
                                                   (r/atom state)
                                                   req)))))))

        dispatch
        (fn [router-resp]
          (if (empty? @screen-identity)
            (initial-dispatch router-resp)
            (usual-dispatch router-resp)))

        history
        (pushy/pushy dispatch matcher)]
    (r/create-class
     {:display-name
      "History"

      :component-will-mount
      #(pushy/start! history)

      :component-will-unmount
      #(pushy/stop! history)

      :reagent-render
      (fn [& _] [:div "history"])})))

(defn page [screen-identity deps]
  (let [{:keys [component db req]} @screen-identity
        deps (c/register deps
                         :page/req (fn [_] req)
                         :page/state (fn [_] @db)
                         :page/dispatch (fn [_] #(swap! db %)))
        component (c/resolve deps component)]
    [component]))

(defn screen [screen-identity deps initial-state]
  [:div
   [history screen-identity deps initial-state]
   [page screen-identity deps]])
