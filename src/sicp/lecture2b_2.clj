(ns sicp.lecture2b-2
  (:require [sicp.lecture2b-4 :refer [car cdr cons-l]]))

;; Compound Data
;; Lecture 2B
;; Part 2 - Text Section 2.1

(defn gcd
  "Greatest common denominator from SICP 1.2.5"
  [a b]
  (if (= b 0)
    a
    (recur b (rem a b))))

(defn make-rat
  "Make a rational number data structure"
  [n d]
  (cons-l n d))

(defn numer
  "Select numerator from rational"
  [x]
  (let [n (car x)
        d (cdr x)
        g (gcd n d)]
    (/ n g)))

(defn denom
  "Select denominator from rational"
  [x]
  (let [n (car x)
        d (cdr x)
        g (gcd n d)]
    (/ d g)))
