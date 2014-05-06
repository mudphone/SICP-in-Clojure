(ns sicp.lecture2b-4)

;; Compound Data
;; Lecture 2B
;; Part 4 - Text Section 2.1

(defn cons-l
  "Our custom cons, which creates pairs"
  [a b]
  (fn [pick]
    (cond
     (= pick 1) a
     (= pick 2) b)))

(defn car
  "Our custom car, which takes the first of a cons'd thing"
  [x]
  (x 1))

(defn cdr
  "Our custom car, which takes the second of a cons'd thing"
  [x]
  (x 2))
