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

(defn sum
  "Generic sum-er"
  [term-f a next-f b]
  (if (> a b)
    0
    (+ (term-f a)
       (sum term-f (next-f a) next-f b))))

(defn sum-int2
  "Alternative sum of integers"
  [a b]
  (let [identity (fn [x] x)]
    (sum identity a inc b)))
