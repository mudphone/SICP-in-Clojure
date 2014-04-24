(ns sicp.lecture1b)

(defn sq
  "Another square function"
  [x]
  (* x x))

(defn sos
  "Calculates the sum of squares"
  [x y]
  (+ (sq x) (sq y)))

(defn sum
  "Homegrown addition"
  [x y]
  (if (= x 0)
    y
    (recur (dec x) (inc y))))

(defn sum-b
  "Another Peano Arithmetic sum"
  [x y]
  (if (= x 0)
    y
    (inc (+ (dec x) y))))

(defn fib
  "Fibonacci number"
  [n]
  (if (< n 2)
    n
    (+ (fib (- n 1))
       (fib (- n 2)))))
