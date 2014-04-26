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

(defn sum-sq2
  "Alternative sum of squares"
  [a b]
  (sum square a inc b))

(defn pi-sum2
  "Alternative pi sum"
  [a b]
  (sum (fn [i] (/ 1 (* i (+ i 2))))
       a
       (fn [i] (+ i 4))
       b))

(defn sum-iter
  "Iterative implementation of sum"
  [term-f a next-f b]
  (let [iter (fn [j ans]
               (if (> j b)
                 ans
                 (recur (next-f j)
                        (+ (term-f j) ans))))]
    (iter a 0)))

(defn sum-int-iter
  "Iterative sum of ints"
  [a b]
  (sum-iter (fn [i] i) a inc b))
