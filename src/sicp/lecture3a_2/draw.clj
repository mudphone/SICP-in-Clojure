(ns sicp.lecture3a-2.draw
  (:require [sicp.lecture3a-2.setup :refer [tick]]
            [sicp.lecture3a-2.picture :refer [make-picture]]
            [sicp.lecture3a-2.rect :refer [make-rect]]
            [sicp.lecture2b-4 :refer [car cdr cons-l]]
            [sicp.lecture2b-3 :refer [make-seg make-vector]]
            [quil.core :as qc]))

;; Primitive
;; - picture (image drawn in rect)

;; Operations / Means of Combination of One Element
;; - rotate
;; - flip

;; Means of Combination
;; - beside (picture, scale)
;; - above

(defn make-list
  [ & things ]
  (cond
   (not (seq things)) nil
   :else (cons-l (first things)
                 (apply make-list (rest things)))))

(defn draw-g
  []
                           ;; left of left leg, and bottom of left arm
  (let [seglist (make-list (make-seg (make-vector 0.2 1.0) (make-vector 0.4 0.55))
                           (make-seg (make-vector 0.4 0.55) (make-vector 0.3 0.5))
                           (make-seg (make-vector 0.3 0.5) (make-vector 0.15 0.6))
                           (make-seg (make-vector 0.15 0.6) (make-vector 0.0 0.45))

                           ;; crotch
                           (make-seg (make-vector 0.4 1.0) (make-vector 0.5 0.7))
                           (make-seg (make-vector 0.5 0.7) (make-vector 0.6 1.0))

                           ;; right of right leg, and bottom of right arm
                           (make-seg (make-vector 0.8 1.0) (make-vector 0.6 0.55))
                           (make-seg (make-vector 0.6 0.55) (make-vector 1.0 0.8))
                           
                           ;; top of left arm, and left of head
                           (make-seg (make-vector 0.0 0.2) (make-vector 0.15 0.45))
                           (make-seg (make-vector 0.15 0.45) (make-vector 0.3 0.4))
                           (make-seg (make-vector 0.3 0.4) (make-vector 0.4 0.4))
                           (make-seg (make-vector 0.4 0.4) (make-vector 0.35 0.2))
                           (make-seg (make-vector 0.35 0.2) (make-vector 0.4 0.0))

                           ;; right of head, and top of right arm
                           (make-seg (make-vector 0.6 0.0) (make-vector 0.65 0.2))
                           (make-seg (make-vector 0.65 0.2) (make-vector 0.6 0.4))
                           (make-seg (make-vector 0.6 0.4) (make-vector 0.8 0.4))
                           (make-seg (make-vector 0.8 0.4) (make-vector 1.0 0.6)))
        g (make-picture seglist)]
    (g (make-rect [0 0] [100 0] [0 100]))))

(defn draw
  []
  (swap! tick inc)
  (qc/background 0 0 0)
  (qc/translate (* 0.2 (qc/width)) (* 0.2 (qc/height)))
  (draw-g)
  )
