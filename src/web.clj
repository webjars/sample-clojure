(ns web
  (:use [ring.adapter.jetty]
        [ring.middleware.resource]))

(defn handler [request]
    {:status 404
     :headers {"Content-Type" "text/html"}
     :body (str "Cannot find " (:uri request))})

(def app
  (-> handler
    (wrap-resource "public")
    (wrap-resource "/META-INF/resources")))

(defn -main []
  (run-jetty app {:port (Integer/parseInt (or (System/getenv "PORT") "8080"))}))
