(ns sicp.lecture3a-3.beside
  (:require [sicp.lecture3a-2.rect :refer [horiz make-rect origin vert]]
            [sicp.lecture3a-2.vector-math :refer [scale vect+]]
            [quil.core :as qc]))

(defn beside
  "Draw two pictures beside each other in rect, split vertically be scale factor a"
  [p1 p2 a]
  (fn [r]
    (p1 (make-rect
         (origin r)
         (scale a (horiz r))
         (vert r)))
    (p2 (make-rect
         (vect+ (origin r)
                (scale a (horiz r)))
         (scale (- 1 a) (horiz r))
         (vert r)))))
