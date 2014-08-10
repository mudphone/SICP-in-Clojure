(ns sicp.lecture5a
  (:require [sicp.lecture2b-2 :refer [gcd]]))

;; Assignment, State & Side-effects
;; Lecture 5A
;; Text Section 3.1 & 3.2
;; https://www.youtube.com/watch?v=jl8EHP1WrWY&index=9&list=PLB63C06FAF154F047

;; Part 1 - 0:00
;; Functional and imperative factorial implementations

;; Part 3 - 47:16
;; Cesaro's method for estimating Pi

;; 1:08:15
(defn my-rand []
  (inc (rand-int 10)))

;; 1:06:44
(defn monte-carlo
  [trials experiment]
  (let [iter (fn [remaining passed]
               (cond (= remaining 0)
                     (/ passed trials)
                  
                     (experiment)
                     (recur (dec remaining)
                            (inc passed))
                     :else
                     (recur (dec remaining)
                            passed)))]
    (iter trials 0)))

;; 1:03:54
(defn cesaro
  []
  (= 1 (gcd (my-rand) (my-rand))))

(defn estimate-pi
  [n]
  (let [mc (monte-carlo n cesaro)]
    (if (= 0 mc)
      "Error: Divide by zero."
      (Math/sqrt (/ 6 mc)))))


;;
;; 1:09:56 estimate-pi without state
;; 1:10:47
;; 1:10:58
;; 1:11:51
