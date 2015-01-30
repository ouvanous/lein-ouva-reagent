(ns {{ns-name}}.core
    (:require [reagent.core :as r :refer [atom]]
              [{{ns-name}}.utils :as u]
              [figwheel.client :as fw]
              [reagent.cursor :as rc]
              [historian.core :as hist]
              [ajax.core :refer [GET POST]]))






(def dev? true)

(enable-console-print!)

(defn set-dev-env [b]
  (if b
    (fw/start {
             :websocket-url "ws://localhost:3449/figwheel-ws"
             :build-id "reagent-test1"
             :on-jsload (fn [] (print "reloaded"))})))

(set-dev-env dev?)





; app state
(defonce state (r/atom {:app {:name "{{name}}"}}))






; cursors
(def app-name (rc/cursor [:app :name] state))






; app 
(defn app []
  [:div [:h1 @app-name]])






; render-component
(r/render-component [app] 
  (.getElementById js/document "app"))
