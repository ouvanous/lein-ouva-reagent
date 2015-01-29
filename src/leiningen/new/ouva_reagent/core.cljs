(ns {{ns-name}}.core
    (:require [reagent.core :as r :refer [atom]]
              [figwheel.client :as fw]
              [ajax.core :refer [GET POST]]))







(enable-console-print!)
(fw/start {
           :websocket-url "ws://localhost:3449/figwheel-ws"
           :build-id "{{ns-name}}"
           :on-jsload (fn [] (print "reloaded"))})







(defonce state (r/atom {:app-name "{{name}}"}))







(defn app []
  [:div [:h1 (:app-name @state)]])







(r/render-component [app]
                          (.getElementById js/document "app"))
