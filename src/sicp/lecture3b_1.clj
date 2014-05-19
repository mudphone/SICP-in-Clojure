(ns sicp.lecture3b-1)

;; Henderson Escher Example
;; Lecture 3B
;; Part 1 - Section 2.2
;; NOTE: Not using car, cdr, cons-l anymore.

(def car first)

(def cdr rest)

(defn cadr
  [x]
  (car (cdr x)))

(defn caddr
  [x]
  (car (cdr (cdr x))))

(defn atom? [thing]
  "Added number? test for ch4, pg59, #1 from Little Lisper."
  (or (symbol? thing) (number? thing) (nil? thing)))

(defn constant?
  "Is this a derivative of a constant with respect to a variable?"
  [e v]
  (and (atom? e)
       (not (= e v))))

(defn same?
  "Is this a derivative of some expression with respect to itself?"
  [e v]
  (and (atom? e)
       (= e v)))

(defn sum?
  "Is this expression a sum?"
  [e]
  (and (not (atom? e))
       (= (car e) '+)))

(defn product?
  "Is this expression a product?"
  [e]
  (and (not (atom? e))
       (= (car e) '*)))

(defn make-sum
  "Make a sum expression"
  [a1 a2]
  (list '+ a1 a2))

(def a1 cadr)

(def a2 caddr)

(defn make-product
  "Make a product expression"
  [m1 m2]
  (list '* m1 m2))

(def m1 cadr)

(def m2 caddr)

(defn deriv
  "Simple derivative calculator of expression (e) with
   respect to a variable (v)."
  [e v]
  (cond
   (constant? e v) 0
   (same? e v) 1   
   (sum? e) (make-sum (deriv (a1 e) v)
                      (deriv (a2 e) v))

   (product? e) (make-sum
                 (make-product (m1 e)
                               (deriv (m2 e) v))
                 (make-product (deriv (m1 e) v)
                               (m2 e)))))
