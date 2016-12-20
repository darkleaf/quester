(ns quester.use-cases.welcome)

(defn perform [{:keys [selections]}]
  {:selections (selections)})
