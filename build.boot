(merge-env!
 :resource-paths #{"resources"}
 :source-paths #{"src/cljc" "src/clj" "src/cljs"}
 :dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [darkleaf/router "0.3.2"]
                 [kibu/pushy "0.3.6"]
                 [cljs-http "0.1.42"]
                 [org.clojure/core.async "0.2.395"]
                 [mount "0.1.10"]
                 [com.cognitect/transit-clj "0.8.290"]
                 [com.cognitect/transit-cljs "0.8.239"]
                 [hiccup "1.0.5"]
                 [reagent "0.6.0" :exclusions [cljsjs/react
                                               cljsjs/react-dom
                                               cljsjs/react-dom-server]]
                 [org.clojure/test.check "0.9.0" :scope "test"]
                 [adzerk/boot-test "1.2.0"]
                 [samestep/boot-refresh "0.1.0" :scope "test"]
                 [adzerk/boot-reload "0.4.13" :scope "test"]
                 [adzerk/boot-cljs "1.7.228-2" :scope "test"]
                 [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                 [com.cemerick/piggieback "0.2.1" :scope "test"]
                 [weasel "0.7.0" :scope "test"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require '[samestep.boot-refresh :refer [refresh]])
(require '[adzerk.boot-reload :refer [reload]])
(require '[adzerk.boot-cljs :refer [cljs]])
(require '[adzerk.boot-cljs-repl :refer [cljs-repl-env cljs-repl start-repl]])
(require '[adzerk.boot-test :refer [test run-tests]])

(replace-task!
 [t test] (fn [& xs]
            (merge-env! :source-paths #{"test/clj"})
            (apply t xs))
 [r repl] (fn [& xs]
            (merge-env! :source-paths #{"src/clj_dev" "test/clj"})
            (require 'dev)
            (apply r xs)))
