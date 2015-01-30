(ns {{ns-name}}.core
    (:require [reagent.core :as r :refer [atom]]
              [figwheel.client :as fw]
              [{{ns-name}}.states :as s]
              [{{ns-name}}.utils :as u]))






(def dev? true)

(enable-console-print!)

(defn set-dev-env [b]
  (if b
    (fw/start {
             :websocket-url "ws://localhost:3449/figwheel-ws"
             :build-id "{{ns-name}}"
             :on-jsload (fn [] (print "reloaded"))})))

(set-dev-env dev?)





(defn header 
  []
  [:div.header {:class (u/class-set {"test" true})}
    [:h1 @s/app-name]])


(defn app-ctrls
  []
  [:div.app-ctrls 
        [:span (:ts @s/state)]
        [:button.pure-button.refresh-button {:on-click #(swap! s/state assoc :ts (u/get-timestamp))} "refresh" ]
        [:button.pure-button {:on-click #(s/undo!)} "undo" ]])


; app 
(defn app []
  [:div [header]
        [app-ctrls]])






; render-component
(r/render-component [app] 
  (.getElementById js/document "app"))
