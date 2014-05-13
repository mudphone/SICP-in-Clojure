(ns sicp.lecture3a-3.draw
  (:require [sicp.lecture3a-3.setup :refer [tick]]
            [sicp.lecture3a-3.beside :refer [beside]]
            [sicp.lecture3a-3.push :refer [right-push right-push2]]
            [sicp.lecture3a-3.rotate :refer [rotate90]]
            [sicp.lecture3a-2.draw :refer [george]]
            [sicp.lecture3a-2.rect :refer [make-rect]]
            [quil.core :as qc]))

(defn draw
  []
  (swap! tick inc)
  (qc/background 0 0 0)
  (qc/translate (* 0.2 (qc/width)) (* 0.2 (qc/height)))
  (let [double-george (beside george george 0.25)
        rotate-george (rotate90 george)
        recursive-george (right-push george 4 0.5)
        recursive-george2 (right-push2 george 4 0.5)]
    (double-george (make-rect [0 0] [200 0] [0 200]))
    (rotate-george (make-rect [0 220] [200 0] [0 200]))
    (recursive-george (make-rect [220 0] [400 0] [0 200]))
    (recursive-george2 (make-rect [220 220] [400 0] [0 200]))))
