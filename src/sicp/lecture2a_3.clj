(ns sicp.lecture2a-3
  (:require [sicp.lecture1a :refer [square]]
            [sicp.lecture2a-2 :refer [fixed-point]]))

;; Higher-order Procedures
;; Lecture 2A
;; Part 3 - Text Section 1.3
;; http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-001-structure-and-interpretation-of-computer-programs-spring-2005/video-lectures/2a-higher-order-procedures/

;; To find a y such that f(y) = 0.
;; Start with a guess, y0.
;;   y[n+1] = y[n] - f(y[n])/ df/dy |y=y[n]

(def dx 0.0000001)

(defn deriv
  "Derivative of a procedure"
  [f]
  (fn [x]
    (/ (- (f (+ x dx))
          (f x))
       dx)))

(defn newton
  "Finds roots of functions."
  [f guess]
  (let [df (deriv f)]
    (fixed-point
     (fn [x]
       (- x (/ (f x) (df x))))
     guess)))

(defn sqrt
  "Newton's method for finding roots of functions."
  [x]
  (newton (fn [y]
            (- x (square y)))
          1))
