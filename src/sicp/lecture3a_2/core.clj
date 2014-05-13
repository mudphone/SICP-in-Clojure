(ns sicp.lecture3a-2.core
  (:require [sicp.lecture3a-2.draw :as dynamic-draw]
            [sicp.lecture3a-2.setup :refer [HEIGHT WIDTH]]
            [sicp.lecture3a-2.setup :as dynamic-setup]
            [quil.core :as qc]))

;; Henderson Escher Example
;; Lecture 3A
;; Part 2

(defn on-close-sketch []
  ;;(stop)
  )

(defn run-sketch []
  (qc/defsketch the-sketch
    :title "Hello Metronome"
    :setup dynamic-setup/setup
    :draw dynamic-draw/draw
    :on-close on-close-sketch
    :size [WIDTH HEIGHT]))

(defn stop-sketch [] (qc/sketch-stop the-sketch))
(defn restart-sketch [] (qc/sketch-start the-sketch))
(defn close-sketch [] (qc/sketch-close the-sketch))

;;(run-sketch)
;;(qc/sketch-stop the-sketch)
;;(qc/sketch-start the-sketch)
;;(qc/sketch-close the-sketch)
