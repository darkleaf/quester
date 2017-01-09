(ns quester.util.url-helpers
  (:require [reagent.core :as r]))

(defn provider [& _]
  (let [helpers (atom {})]
    (r/create-class
     {:displayName
      "UrlHelpersProvider"

      :getChildContext
      (fn [] #js{:urlHelpers @helpers})

      :childContextTypes
      #js{:urlHelpers js/React.PropTypes.any.isRequired}

      :reagent-render
      (fn [request-for & children]
        (let [url-for (fn [& args]
                        (let [req (apply request-for args)]
                          (assert (= :get (:request-method req)))
                          (assert (= #{:request-method :uri}  (-> req keys set)))
                          (:uri req)))]
          (reset! helpers {:request-for request-for
                           :url-for url-for})
          (into [:div] children)))})))

(defn wrapper [component]
  "Higher-Order Component"
  (r/create-class
   {:displayName
    "UrlHelpersWrapper"

    :contextTypes
    #js{:urlHelpers js/React.PropTypes.any.isRequired}

    :reagent-render
    (fn [& args]
      (let [this (r/current-component)
            url-helpers (.. this -context -urlHelpers)]
        (into [component url-helpers] args)))}))
