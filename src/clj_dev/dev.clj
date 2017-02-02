(ns dev
  (:require [clojure.spec :as s]
            [mount.core :as mount]
            [quester.web-server]))

(s/check-asserts true)

(defn setup-class-path []
  (let [separator (System/getProperty "path.separator")
        re-separator (re-pattern separator)
        curr-class-path (System/getProperty "java.class.path")
        curr-class-path-items (clojure.string/split curr-class-path re-separator)
        dirs  (boot.core/get-env :directories)
        new-class-path-items (distinct (into curr-class-path-items dirs))  ;; distinct for idempotence
        new-class-path (clojure.string/join separator new-class-path-items)]
    (System/setProperty "java.class.path" new-class-path)))

(setup-class-path)

(mount/defstate cljs-processor
  :start (future
           (boot.core/boot
            (boot.task.built-in/watch)
            (adzerk.boot-cljs-repl/cljs-repl-env)
            (adzerk.boot-reload/reload :asset-path "/public"
                                       :on-jsload 'quester.web/restart)
            (adzerk.boot-cljs/cljs)))
  :stop (future-cancel cljs-processor))

(defn start []
  (mount/start))

(defn stop []
  (mount/stop))

(defn restart []
  (stop)
  (start))
