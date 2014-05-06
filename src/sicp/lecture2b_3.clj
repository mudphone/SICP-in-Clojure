(ns sicp.lecture2b-3
  (:require [sicp.lecture1a :refer [average sqrt square]]))

;; Compound Data
;; Lecture 2B
;; Part 3 - Text Section 2.1

(defn make-vector
  "Vector representation of a point in a plane"
  [x y]
  [x y])

(defn xcor
  "Select x-coordinate of point"
  [p]
  (first p))

(defn ycor
  "Select y-coordinate of point"
  [p]
  (last p))

(defn make-seg
  "Create a line segment"
  [p q]
  [p q])

(defn seg-start
  "Select starting point of line segment"
  [s]
  (first s))

(defn seg-end
  "Select ending point of line segment"
  [s]
  (last s))

(defn midpoint
  "Calculate midpoint of line segment"
  [s]
  (let [a (seg-start s)
        b (seg-end s)]
    (make-vector
     (average (xcor a) (xcor b))
     (average (ycor a) (ycor b)))))

(defn length
  "Calculate length of line segment"
  [s]
  (let [dx (- (xcor (seg-end s))
              (xcor (seg-start s)))
        dy (- (ycor (seg-end s))
              (ycor (seg-start s)))]
    (sqrt (+ (square dx)
             (square dy)))))
