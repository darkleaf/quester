(merge-env!
 :resource-paths #{"resources"}
 :source-paths #{"src/cljc" "src/clj" "src/cljs"}
 :dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [darkleaf/router "0.2.0-alpha2"]
                 [kibu/pushy "0.3.6"]
                 [cljs-http "0.1.42"]
                 [org.clojure/core.async "0.2.395"]
                 [mount "0.1.10"]
                 [com.cognitect/transit-clj "0.8.290"]
                 [com.cognitect/transit-cljs "0.8.239"]
                 [hiccup "1.0.5"]

                 [org.clojure/test.check "0.9.0" :scope "test"]
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
(require '[adzerk.boot-cljs-repl :refer [cljs-repl-env start-repl]])

(deftask cider []
  (require 'boot.repl)
  (swap! @(resolve 'boot.repl/*default-dependencies*)
         concat '[[cider/cider-nrepl "0.14.0"]
                  [refactor-nrepl "2.2.0"]])
  (swap! @(resolve 'boot.repl/*default-middleware*)
         concat '[cider.nrepl/cider-middleware
                  refactor-nrepl.middleware/wrap-refactor])
  (merge-env! :source-paths #{"src/clj-dev"})
  (require ['user :as 'u])
  (comp
   (repl :server true)
   (watch)
   (refresh)
   (cljs-repl-env)
   (reload :asset-path "/public", :on-jsload 'quester.web/restart)
   (cljs)))
