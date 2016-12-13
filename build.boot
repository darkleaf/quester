(merge-env!
 :resource-paths #{"resources"}
 :source-paths #{"src/cljc" "src/clj" "src/cljs"}
 :dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [darkleaf/router "0.2.0-alpha1"]
                 [mount "0.1.10"]
                 [com.cognitect/transit-clj "0.8.290"]
                 [hiccup "1.0.5"]
                 [org.clojure/test.check "0.9.0" :scope "test"]
                 [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                 [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                 [com.cemerick/piggieback "0.2.1"  :scope "test"]
                 [weasel "0.7.0" :scope "test"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]])
(require '[adzerk.boot-cljs-repl :refer [cljs-repl-env start-repl]])

(replace-task!
 [r repl] (fn [& xs]
            ;; hack for cider
            (load-file "dev/user.clj")
            (apply r xs)))
