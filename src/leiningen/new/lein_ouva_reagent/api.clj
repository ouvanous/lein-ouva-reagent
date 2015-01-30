(ns {{ns-name}}.api
  (:use compojure.core
        ring.util.response
        propertea.core)
  (:require 
      [clojure.java.io :as io]
      [clojure.data.json :as json]
      [clj-time.core :as time]
      [clj-time.coerce :as tc]
      [clj-time.format :as tf]))







(def props (read-properties (.getPath (clojure.java.io/resource "{{ns-name}}.properties"))))






(defn index 
  [req]
  {:status 200
   :headers {"Content-Type" "application/json; charset=utf-8"}
   :body {:index true}})



