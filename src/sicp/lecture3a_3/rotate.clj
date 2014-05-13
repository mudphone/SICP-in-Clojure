(ns sicp.lecture3a-3.rotate
  (:require [sicp.lecture3a-2.rect :refer [horiz make-rect origin vert]]
            [sicp.lecture3a-2.vector-math :refer [scale vect+]]
            [quil.core :as qc]))

(defn rotate90
  "Rotate a procedure to draw a picture by 90 degrees"
  [pict]
  (fn [r]
    (pict (make-rect
           (vect+ (origin r)
                  (horiz r))
           (vert r)
           (scale -1 (horiz r))))))
