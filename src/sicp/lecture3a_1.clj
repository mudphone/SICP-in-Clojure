(ns sicp.lecture3a-1
  (:require [sicp.lecture2b-4 :refer [car cons-l cdr]]))

;; Henderson Escher Example
;; Lecture 3A
;; Part 1
(def list-1-to-4
  (cons-l 1
          (cons-l 2
                  (cons-l 3
                          (cons-l 4 nil)))))

(defn scale-list
  "Scale a list by a scalar value"
  [s l]
  (if (nil? l)
    nil
    (cons-l (* (car l) s)
            (scale-list s (cdr l)))))

(defn map-2
  "Map a procedure via homegrown implementation"
  [p l]
  (if (nil? l)
    nil
    (cons-l (p (car l))
            (map-2 p (cdr l)))))

(defn scale-list-map
  "Scale a list using the map procedure"
  [s l]
  (map-2 (fn [item] (* item s))
         l))

(defn for-each
  "Do something with each item in list, for side effects"
  [p l]
  (cond
   (nil? l) "done"
   :else (do
           (p (car l))
           (recur p (cdr l)))))
