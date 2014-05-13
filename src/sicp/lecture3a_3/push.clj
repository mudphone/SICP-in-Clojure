(ns sicp.lecture3a-3.push
  (:require [sicp.lecture3a-3.beside :refer [beside]]
            [quil.core :as qc]))

(defn right-push
  "Rotate a procedure to draw a picture by 90 degrees"
  [p n a]
  (if (= n 0)
    p
    (beside p
            (right-push p (dec n) a)
            a)))

(defn compose
  [f g]
  (fn [x]
    (f (g x))))

(defn repeated
  [f x]
  (if (= x 1)
    f
    (compose f (repeated f (- x 1)))))

(defn push
  "Means of combination for push"
  [comb]
  (fn [pict n a]
    ((repeated
      (fn [p] (comb pict p a))
      n)
     pict)))

(def right-push2
  (push beside))
