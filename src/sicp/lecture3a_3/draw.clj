(ns sicp.lecture3a-3.draw
  (:require [sicp.lecture3a-3.setup :refer [tick]]
            [sicp.lecture3a-3.beside :refer [beside]]
            [sicp.lecture3a-2.draw :refer [george]]
            [sicp.lecture3a-2.rect :refer [make-rect]]
            [quil.core :as qc]))

(defn draw
  []
  (swap! tick inc)
  (qc/background 0 0 0)
  (qc/translate (* 0.2 (qc/width)) (* 0.2 (qc/height)))
  (let [double-george (beside george george 0.25)]
    (double-george (make-rect [0 0] [200 0] [0 200]))))
