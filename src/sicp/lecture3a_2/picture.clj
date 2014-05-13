(ns sicp.lecture3a-2.picture
  (:require [sicp.lecture3a-2.rect :refer [horiz origin vert]]
            [sicp.lecture3a-2.vector-math :refer [scale vect+]]
            [sicp.lecture3a-1 :refer [for-each]]
            [sicp.lecture2b-3 :refer [seg-start seg-end xcor ycor]]
            [quil.core :as qc]))

(defn coord-map
  "Gives a procedure on points, to translate from unit square to given rectangle r."
  [r]
  (fn [p]
    (vect+
     (vect+ (scale (xcor p)
                   (horiz r))
            (scale (ycor p)
                   (vert r)))
     (origin r))))

(defn drawline
  "Draw a line between two points"
  [p1 p2]
  (qc/line (first p1) (second p1) (first p2) (second p2)))

(defn make-picture
  "Contruct primitive picture from list of segments"
  [seglist]
  (fn [r]
    (for-each
     (fn [s]
       (drawline
        ((coord-map r) (seg-start s))
        ((coord-map r) (seg-end s))))
     seglist)))
