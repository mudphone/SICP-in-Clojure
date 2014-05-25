(ns sicp.lecture4a
  (:require [sicp.lecture3b-1 :refer [atom? car cdr]]))

;; Henderson Escher Example
;; Lecture 4A
;; Pattern-matching: Rule-based Substitution
;; https://www.youtube.com/watch?v=amf5lTZ0UTc

;; Derivative Rules from 5:34
;; dd = derivative
;; ?c = constant
;; ?v = variable
;; (? v) in dd = with respect to variable v
;; (? x1) = expression x1
;;        these are pattern variables for matching
;; : = substitution objects, skeleton evaluation

(defn ?= [?x])
(defn ?c [?x])
(defn ?v [?x])
(defn ? [?x])
(defn dd [?x])
(def deriv-rules
  '(
    ( (dd (?c c) (? v)) 0 )
    ( (dd (?v v) (? v)) 1 )
    ( (dd (?v u) (? v)) 0 )

    ( (dd (+ (? x1) (? x2)) (? v))
      (+ (dd (?= x1) (?= v))
         (dd (?= x2) (?= v))) )

    ( (dd (* (? x1) (? x2)) (? v))
      (+ (* (?= x1) (dd (?= x2) (?= v)))
         (* (dd (?= x1) (?= v)) (?= x2))) )

    ( (dd (** (? x) (?c n)) (? v))
      (* (* (?= n)
            (** (?= x) (?= (- n 1))))
         (dd (?= x) (?= v))) )
    ))

(def constant? number?)

(def variable? symbol?)

(defn arbitrary-constant?
  [pat]
  (= '?c (car pat)))

(defn arbitrary-variable?
  [pat]
  (= '?v (car pat)))

(defn arbitrary-expression?
  [pat]
  (= '? (car pat)))

(defn lookup
  [k dict]
  (dict k))

(defn addto
  [dict k v]
  (assoc dict k v))

(defn extend-dict
  [pat e dict]
  (if-let [v (lookup pat dict)]
    (if (= v e)
      dict
      'failed)
    (addto dict pat e)))

(defn match
  "Matcher
   ~26:26"
  [pat e dict]
  (cond
   (= dict 'failed) 'failed

   ;; Atomic patterns
   (atom? pat)
   (if (atom? e)
     (if (= pat e)
       dict
       'failed)
     'failed)

   ;; Pattern variable clauses
   (arbitrary-constant? pat)
   (if (constant? e)
     (extend-dict pat e dict)
     'failed)

   (arbitrary-variable? pat)
   (if (variable? e)
     (extend-dict pat e dict)
     'failed)

   (arbitrary-expression? pat)
   (extend-dict pat e dict)
   
   (atom? e) 'failed   
   :else
   (match (cdr pat)
          (cdr e)
          (match (car pat)
                 (car e)
                 dict))))

(defn skeleton-evaluation?
  [s]
  (= '?= (car s)))

(defn evaluate
  [form dict]
  (if (atom? form)
    (lookup form dict)
    (apply
     (eval (lookup (car form) dict))
     (map (fn [v]
            (lookup v dict))
          (cdr form)))))

(defn eval-exp
  [&x])

(defn instantiate
  [skeleton dict]
  (let [lp (fn lp [s]
             (cond
              (atom? s) s

              (skeleton-evaluation? s)
              (evaluate (eval-exp s) dict)

              :else (cons (lp (car s))
                          (lp (cdr s)))))]
    (lp skeleton)))

(defn simplifier
  [&x])

(def dsimp
  (simplifier deriv-rules))
