(set-env!
  :source-paths #{"src/cljc" "src/clj"}
  :dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                  [ring/ring-core "1.5.0"]
                  [ring/ring-jetty-adapter "1.5.0"]
                  [darkleaf/router "0.1.0-20161110.194632-2"]
                  [mount "0.1.10"]
                  [com.cognitect/transit-clj "0.8.290"]
                  [org.clojure/test.check "0.9.0" :scope "test"]])

(task-options!
 repl {:init-ns 'user})

(replace-task!
 [r repl] (fn [& xs]
            (merge-env! :source-paths #{"dev"})
            (apply r xs)))
