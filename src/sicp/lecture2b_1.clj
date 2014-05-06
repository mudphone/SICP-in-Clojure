(ns sicp.lecture2b-1
  (:require [sicp.lecture2b-2 :refer [denom make-rat numer]]))

;; Compound Data
;; Lecture 2B
;; Part 1 - Text Section 2.1

(defn +rat
  "Sum of rationals"
  [x y]
  (make-rat
   (+ (* (numer x) (denom y))
      (* (numer y) (denom x)))
   (* (denom x) (denom y))))

(defn *rat
  "Product of rationals"
  [x y]
  (make-rat
   (* (numer x) (numer y))
   (* (denom x) (denom y))))
