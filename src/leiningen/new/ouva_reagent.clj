(ns leiningen.new.ouva-reagent
  (:require [leiningen.new.templates :refer [renderer sanitize-ns name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "ouva-reagent"))

(defn ouva-reagent
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' ouva-reagent project. .....")
    (->files data ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
                  ["src/cljs/{{sanitized}}/utils.cljs" (render "utils.cljs" data)]
                  ["src/cljs/{{sanitized}}/states.cljs" (render "states.cljs" data)]
                  ["project.clj" (render "project.clj" data)]
                  ["gulpfile.js" (render "gulpfile.js")]
                  ["src/clj/{{sanitized}}/handler.clj" (render "handler.clj" data)]
                  ["src/clj/{{sanitized}}/views.clj" (render "views.clj" data)]
                  ["src/clj/{{sanitized}}/api.clj" (render "api.clj" data)]
                  ["resources/{{ns-name}}.properties" (render "project.properties" data)]
                  ["resources/log4j.properties" (render "log4j.properties" data)]
                  ["resources/public/css/app.styl" (render "app.styl" data)]
                  ["resources/public/css/pure-min.css" (render "pure-min.css")]
                  ["resources/public/css/ionicons.min.css" (render "ionicons.min.css")]
                  ["resources/public/css/ie.css" (render "ie.css")]
                  ["resources/public/fonts/ionicons.ttf" (render "fonts/ionicons.ttf")]
                  ["resources/public/fonts/ionicons.eot" (render "fonts/ionicons.eot")]
                  ["resources/public/fonts/ionicons.svg" (render "fonts/ionicons.svg")]
                  ["resources/public/fonts/ionicons.woff" (render "fonts/ionicons.woff")]
                  ["resources/public/js/react.min.js" (render "react.min.js")]
                  "resources/public/data"
                  "resources/public/img")))