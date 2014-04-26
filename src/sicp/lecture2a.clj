(ns sicp.lecture2a)

(defn sum-int
  "Sum of the integers from a to b"
  [a b]
  (if (> a b)
    0
    (+ a
       (sum-int (inc a) b))))

(defn square
  "Square of num"
  [a]
  (* a a))

(defn sum-sq
  "Sum of squares of a to b"
  [a b]
  (if (> a b)
    0
    (+ (square a)
       (sum-sq (inc a) b))))

(defn pi-sum
  "Leibnitz formula for pi/8"
  [a b]
  (if (> a b)
    0
    (float (+ (/ 1 (* a (+ a 2)))
              (pi-sum (+ a 4) b)))))
