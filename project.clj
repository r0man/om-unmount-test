(defproject om-unmount "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [om "0.1.0"]]
  :plugins [[lein-cljsbuild "1.0.1"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:output-to "app.js"
                                   :output-dir "target"
                                   :optimizations :advanced
                                   :preamble ["react/react.min.js"]
                                   :externs ["react/externs/react.js"]
                                   :pretty-print true}}]})
