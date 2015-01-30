(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2727"]
                 [cljs-ajax "0.3.9"]
                 [reagent/reagent-cursor "0.1.2"]
                 [historian "1.0.7"]
                 [cljsjs/moment "2.6.0-3"]
                 [http-kit "2.1.16"]
                 [figwheel "0.2.2-SNAPSHOT"]  
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.2"]
                 [compojure "1.3.1"]
                 [prone "0.8.0"]
                 [reagent "0.5.0-alpha"]
                 [hiccup "1.0.5"]
                 [org.slf4j/slf4j-log4j12 "1.7.9"]
                 [clj-time "0.9.0"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [javax.servlet/servlet-api "2.5"]
                 [amalloy/ring-gzip-middleware "0.1.3"]
                 [propertea "1.2.3"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]
                 [org.clojure/tools.logging "0.3.1"]]

  :min-lein-version "2.5.0"

  :plugins [[lein-ring "0.8.13"]
            [lein-cljsbuild "1.0.4"]
            [lein-figwheel "0.2.2-SNAPSHOT"]]

  :source-paths ["src/clj"]

  :ring {:handler {{ns-name}}.handler/app
         :servlet-path-info? true
         :servlet-name "{{ns-name}}Servlet"
         :uberwar-name "{{ns-name}}.war"
       }

  :figwheel {
     :http-server-root "public"
     :server-port 3449
     :css-dirs ["resources/public/css"]
     :ring-handler {{ns-name}}.handler/fw-app
     :open-file-command "st"
  } 
  :cljsbuild {:builds [{:id "{{ns-name}}"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :optimizations :none
                                   :source-map true}}]})