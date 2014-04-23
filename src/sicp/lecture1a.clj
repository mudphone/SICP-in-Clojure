(ns sicp.lecture1a)

(defn square
  "Square a number"
  [x]
  (* x x))

(defn abs [x]
  (if (< x 0)
    (- x)
    x))
