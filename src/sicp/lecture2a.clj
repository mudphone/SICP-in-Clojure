(ns sicp.lecture2a)

(defn sum-int
  "Sum of the integers from a to b"
  [a b]
  (if (> a b)
    0
    (+ a
       (sum-int (inc a) b))))
