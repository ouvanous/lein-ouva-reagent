(ns {{ns-name}}.states
  (:require [reagent.core :as r :refer [atom]]
            [{{ns-name}}.utils :as u]
            [historian.core :as hist]
            [reagent.cursor :as rc]
            [ajax.core :refer [GET POST]]))






; app state
(defonce state (r/atom {:app {:name "{{ns-name}}"}
                        :ts (u/get-timestamp)
                        :data {}}))







; history 
(hist/record! state :state)

(defn undo! []
  (hist/undo!))







; services 
(defn load-test
  []
  (GET "/api" {:handler #(swap! state assoc :data %)}))







; cursors
(def app-name (rc/cursor [:app :name] state))