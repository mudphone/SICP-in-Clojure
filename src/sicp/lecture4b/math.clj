(ns sicp.lecture4b.math)

;; Generic Operators
;; Lecture 4B, Part 1 - Text Section 2.3
;; Dispatch on Type (First Half)
;; https://www.youtube.com/watch?v=h6Z7vx9iUB8&index=8&list=PLB63C06FAF154F047


;; Some Math
(defn square
  [x]
  (* x x))

(defn atan
  [y x]
  (Math/atan (/ y x)))
