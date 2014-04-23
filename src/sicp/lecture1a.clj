(ns sicp.lecture1a)

(defn square
  "Square a number"
  [x]
  (* x x))

(defn abs [x]
  "Absolute value of number"
  (if (< x 0)
    (- x)
    x))

(defn average [& vec]
  (cond
   (empty? vec) nil
   :else (float (/ (apply + vec) (count vec)))))

(defn sqrt [x]
  "Square root of number"
  (let [improve (fn [guess]
                  (average guess (/ x guess)))
        good-enough? (fn [guess]
                       (< (abs (- (square guess) x))
                          0.001))
        try-guess (fn [guess]
              (if (good-enough? guess)
                guess
                (recur (improve guess))))]
    (try-guess 1)))
