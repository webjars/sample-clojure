(ns web
  (:use noir.core)
  (:require [noir.server :as server]))

(defpage "/" [] "hello, world")

(server/start (Integer/parseInt (or (System/getenv "PORT") "8080")))
