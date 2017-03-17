(ns quester.use-cases.context)

(defprotocol Context
  (get-state [_])
  (-update-state [_ args])
  (request [_ req]))

(defn update-state [ctx & args]
  (-update-state ctx args))
