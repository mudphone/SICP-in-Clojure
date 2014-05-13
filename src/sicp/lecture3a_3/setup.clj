(ns sicp.lecture3a-3.setup
  (:require [quil.core :as qc]))

(def WIDTH 800)
(def HEIGHT 600)
(def tick (atom 0))

(defn setup
  []
  (qc/stroke 255 255 255)
  (qc/fill 255 0 0))
