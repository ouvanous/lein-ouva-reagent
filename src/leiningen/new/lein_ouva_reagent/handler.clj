(ns {{ns-name}}.handler
  (:use 
    ring.middleware.json
    [ring.adapter.jetty :only [run-jetty]]
    ring.util.response
    ring.middleware.params
    ring.middleware.gzip
    ring.middleware.multipart-params
    [org.httpkit.server :only [run-server]])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [{{ns-name}}.views :as views]
            [{{ns-name}}.api :as api])
  (:gen-class))




; teststststststst


(defroutes api-routes
  (GET "/" [] api/index))







(defroutes app-routes
  (GET "/" [] views/index)
  (context "/api" [] api-routes)
  (route/resources "/")
  (route/not-found "Not Found"))







(def app
  (-> (handler/site app-routes)
      ; (wrap-params)
      ; (wrap-multipart-params)
      (wrap-json-response)
      (wrap-gzip)))

(def fw-app
  (-> (handler/site app-routes)
      (reload/wrap-reload)
      ; (wrap-params)
      ; (wrap-multipart-params)
      (wrap-json-response)
      (wrap-gzip)))







(defn start-server
  []
  (run-jetty #'app {:port 9090 :join? false}))







(defn -main [& args]
  (start-server))