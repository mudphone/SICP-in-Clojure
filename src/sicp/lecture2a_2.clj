(ns sicp.lecture2a-2
  (:require [sicp.lecture1a :refer [abs average]]))

;; Higher-order Procedures
;; Lecture 2A
;; Part 2 - Text Section 1.3
;; http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-001-structure-and-interpretation-of-computer-programs-spring-2005/video-lectures/2a-higher-order-procedures/

(defn fixed-point
  "Find fixed point of the procedure whose name will be f in
   this procedure"
  [f start]
  (let [tolerance 0.00001
        close-enuf? (fn [u v]
                      (< (abs (- u v)) tolerance))
        iter (fn [old new]
               (if (close-enuf? old new)
                 new
                 (recur new (f new))))]
    (iter start (f start))))

(defn sqrt
  "Square root via Fixed-Point"
  [x]
  (fixed-point (fn [y]
                 (average (/ x y) y))
               1))

(defn average-damp
  "A procedure which takes a procedure and returns a procedure
   which averages the application with the input."
  [f]
  (fn [x]
    (average (f x) x)))

(defn sqrt-avg-damp
  "Square root via average-damping method"
  [x]
  (fixed-point
   (average-damp (fn [y]
                   (/ x y)))
   1))
