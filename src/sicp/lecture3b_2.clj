(ns sicp.lecture3b-2
  (:require [sicp.lecture3b-1 :refer [constant? same? sum? product? a1 a2 m1 m2]])
  )

;; Henderson Escher Example
;; Lecture 3B
;; Part 2 - Section 2.2
;; NOTE: Not using car, cdr, cons-l anymore.

(defn better-make-sum
  "Make a better sum expression"
  [a1 a2]
  (cond
   (and (number? a1)
        (number? a2))
   (+ a1 a2)
   
   (and (number? a1) (= a1 0))
   a2
   
   (and (number? a2) (= a2 0))
   a1

   :else (list '+ a1 a2)))

(defn better-make-product
  "Make a better product expression"
  [m1 m2]
  (cond
   (and (number? m1)
        (number? m2))
   (* m1 m2)

   (or
    (and (number? m1) (= m1 0))
    (and (number? m2) (= m2 0)))
   0

   (and (number? m1) (= m1 1))
   m2

   (and (number? m2) (= m2 1))
   m1

   :else (list '* m1 m2)))

(defn better-deriv
  "Better derivative calculator of expression (e) with
   respect to a variable (v)."
  [e v]
  (cond
   (constant? e v) 0
   (same? e v) 1   
   (sum? e) (better-make-sum (better-deriv (a1 e) v)
                             (better-deriv (a2 e) v))

   (product? e) (better-make-sum
                 (better-make-product (m1 e)
                                      (better-deriv (m2 e) v))
                 (better-make-product (better-deriv (m1 e) v)
                                      (m2 e)))))
