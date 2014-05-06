(ns sicp.lecture2b-2)

;; Compound Data
;; Lecture 2B
;; Part 2 - Text Section 2.1

(defn gcd
  "Greatest common denominator from SICP 1.2.5"
  [a b]
  (if (= b 0)
    a
    (recur b (rem a b))))

(defn make-rat
  "Make a rational number data structure"
  [n d]
  (conj [n] d))

(defn numer
  "Select numerator from rational"
  [x]
  (let [n (first x)
        d (last x)
        g (gcd n d)]
    (/ n g)))

(defn denom
  "Select denominator from rational"
  [x]
  (let [n (first x)
        d (last x)
        g (gcd n d)]
    (/ d g)))
