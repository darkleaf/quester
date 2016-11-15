(ns user
  (:require [boot.core :refer :all]
            [mount.core]
            [quester.container]
            [quester.composition-root]
            [quester.web-server]))

(defn start []
  (mount.core/start))

(defn stop []
  (mount.core/stop))

(defn restart []
  (stop)
  (start))

(defn setup-class-path []
  (let [separator (System/getProperty "path.separator")
        re-separator (re-pattern separator)
        curr-class-path (System/getProperty "java.class.path")
        curr-class-path-items (clojure.string/split curr-class-path re-separator)
        dirs  (get-env :directories)
        new-class-path-items (distinct (into curr-class-path-items dirs))
        new-class-path (clojure.string/join separator new-class-path-items)]
    (System/setProperty "java.class.path" new-class-path)))

(setup-class-path)

(quester.composition-root/register-all)
