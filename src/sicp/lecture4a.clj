(ns sicp.lecture4a
  (:require [sicp.lecture3b-1 :refer [car cdr]]))

;; Henderson Escher Example
;; Lecture 4A
;; Pattern-matching: Rule-based Substitution
;; https://www.youtube.com/watch?v=amf5lTZ0UTc

(defn atom? [thing]
  "Added number? test for ch4, pg59, #1 from Little Lisper."
  (or (symbol? thing) (number? thing) (nil? thing)
      (and (seq? thing)
           (empty? thing))))

;; Derivative Rules from 5:34
;; dd = derivative
;; ?c = constant
;; ?v = variable
;; (? v) in dd = with respect to variable v
;; (? x1) = expression x1
;;        these are pattern variables for matching
;; : = substitution objects, skeleton evaluation

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

(defn arbitrary-value
  [pat]
  (second pat))

(defn lookup
  "Contains replacement for user-initial-environment
   in video lecture at ~40:08.
   Apparently required to make sense of arbitrary
   expressions."
  [k dict]
  (cond
   (number? k) k
   (= '+ k) '+
   (= '- k) '-
   (= '* k) '*
   (= '/ k) '/
   :else (dict k)))

(defn addto
  [dict k v]
  (assoc dict k v))

(defn empty-dict
  []
  {})

(defn extend-dict
  [pat e dict]
  (let [k (arbitrary-value pat)]
    (if-let [v (lookup k dict)]
      (if (= v e)
        dict
        'failed)
      (addto dict k e))))

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
  (if (or
       (atom? form)
       (lookup form dict))
    (lookup form dict)
    (apply
     (eval (lookup (car form) dict))
     (map #(lookup % dict)
          (cdr form)))))

(defn eval-exp
  [s]
  (second s))

(defn instantiate
  [skeleton dict]
  (let [lp (fn lp [s]
             (cond
              (atom? s) s

              (skeleton-evaluation? s)
              (evaluate (eval-exp s) dict)

              :else
              (cons (lp (car s))
                    (lp (cdr s)))))]
    (lp skeleton)))

(defn compound?
  [e]
  (not (atom? e)))

(defn pattern
  [rule]
  (first rule))

(defn skeleton
  [rule]
  (second rule))

(defn scan
  [e simplify-fn rules]
  (if (not (seq rules))
    e
    (let [dict (match (pattern (car rules))
                      e
                      (empty-dict))]
      (if (= dict 'failed)
        (scan e simplify-fn (cdr rules))
        (simplify-fn
         (instantiate
          (skeleton (car rules))
          dict))))))

(defn simplifier
  [the-rules]
  (let [try-rules (fn try-rules [simplify-fn e]
                    (scan e simplify-fn the-rules))
        simplify-exp (fn simplify-exp [e]
                       (try-rules simplify-exp
                        (if (compound? e)
                          (map simplify-exp e)
                          e)))]
    simplify-exp))

(def dsimp
  (simplifier deriv-rules))
