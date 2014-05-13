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
