(ns sicp.lecture3b-2-test
  (:require [clojure.test :refer :all]
            [sicp.lecture3b-2 :refer :all]))

(def EXP-X '(+ (* a (* x x))
               (+ (* b x)
                  c)))

(deftest better-deriv-test
  (testing "better derivative"
    (is (= '(+ (* a (+ x x))
               b)
           (better-deriv EXP-X 'x)))
    (is (= '(* x x)
           (better-deriv EXP-X 'a)))
    (is (= 'x
           (better-deriv EXP-X 'b)))
    (is (= 1
           (better-deriv EXP-X 'c)))))
