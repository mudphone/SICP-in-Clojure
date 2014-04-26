(ns sicp.lecture2a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2a :refer :all]))

(deftest sum-int-test
  (testing "sum of integers"
    (is (= 15 (sum-int 7 8)))))

(deftest square-test
  (testing "square again"
    (is (= 9 (square 3)))))

(deftest sum-sq-test
  (testing "sum of squares"
    (is (= 25 (sum-sq 3 4)))))

(deftest pi-sum-test
  (testing "Leibnitz's formula"
    (let [pi_8 (/ 3.14159 8.0)]
      (is (> 0.001 (- pi_8 (pi-sum 1 1000)))))))

(deftest sum-int2-test
  (testing "more general solution for sum of integers"
    (is (= 15 (sum-int2 7 8)))
    (is (= 12 (sum-int2 3 5)))))
