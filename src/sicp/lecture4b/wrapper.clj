(ns sicp.lecture4b.wrapper)

;; Generic Operators
;; Lecture 4B, Part 1 - Text Section 2.3
;; Dispatch on Type (First Half)
;; https://www.youtube.com/watch?v=h6Z7vx9iUB8&index=8&list=PLB63C06FAF154F047

(defn ntype [z]
  (:type z))

(defn nvalue [z]
  (:value z))

(defn wrap [t z]
  {:type t
   :value z})
