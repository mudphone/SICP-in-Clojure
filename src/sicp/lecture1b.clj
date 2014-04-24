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
