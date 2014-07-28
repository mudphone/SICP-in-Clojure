(ns sicp.lecture4b.rectangular
  (:require [sicp.lecture4b.math :refer [atan square]]
            [sicp.lecture4b.wrapper :refer [wrap]]))

;; Generic Operators
;; Lecture 4B, Part 1 - Text Section 2.3
;; Dispatch on Type (First Half)
;; https://www.youtube.com/watch?v=h6Z7vx9iUB8&index=8&list=PLB63C06FAF154F047

;; Selectors - RECTANGULAR
;; Complex number represented as a pair of real part, and imaginary part.

(defn real-part
  [z]
  (first z))

(defn imag-part
  [z]
  (last z))

(defn magnitude
  [z]
  (Math/sqrt (+ (square (real-part z))
                (square (imag-part z)))))

(defn angle
  [z]
  (atan (imag-part z) (real-part z)))


;; Constructors 12:36
(defn make-rectangular
  "Make rectangular representation from real part and imaginary part"
  [x y]
  [x y])

(defn make-polar
  "Make rectagular representation from magnitude and angle"
  [r a]
  [(* r (Math/cos a))
   (* r (Math/sin a))])

(defn gen-rectangular
  [x y]
  (wrap :rectangular
        (make-rectangular x y)))


;; Complex Math Operators

(defn add-c
  [z1 z2]
  (make-rectangular
   (+ (real-part z1) (real-part z2))
   (+ (imag-part z1) (imag-part z2))))

(defn sub-c
  [z1 z2]
  (make-rectangular
   (- (real-part z1) (real-part z2))
   (- (imag-part z1) (imag-part z2))))

(defn mul-c
  [z1 z2]
  (make-polar
   (* (magnitude z1) (magnitude z2))
   (+ (angle z1) (angle z2))))

(defn div-c
  [z1 z2]
  (make-polar
   (/ (magnitude z1) (magnitude z2))
   (- (angle z1) (angle z2))))
