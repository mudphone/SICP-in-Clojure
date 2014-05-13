(ns sicp.lecture3a-2.draw
  (:require [sicp.lecture3a-2.setup :refer [tick]]
            [sicp.lecture3a-2.rect :refer [horiz origin vert]]
            [sicp.lecture3a-2.vector-math :refer [scale vect+]]
            [sicp.lecture2b-3 :refer [xcor ycor]]
            [quil.core :as qc]))

;; Primitive
;; - picture (image drawn in rect)

;; Operations / Means of Combination of One Element
;; - rotate
;; - flip

;; Means of Combination
;; - beside (picture, scale)
;; - above

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

(defn draw
  []
  (swap! tick inc)
  (qc/background 0 0 0)
  (qc/translate (* 0.5 (qc/width)) (* 0.5 (qc/height)))
  (let [theta (* 0.05 @tick)
        x (* 0.5 (qc/width) (Math/sin theta))]
    (qc/ellipse x 0 20 20)))
