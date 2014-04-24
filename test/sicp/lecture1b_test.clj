(ns sicp.lecture1b-test
  (:require [clojure.test :refer :all]
            [sicp.lecture1b :refer :all]))

(deftest sq-test
  (testing "simple test of squaring a number"
    (is (= 4 (sq 2)))))

(deftest sos-test
  (testing "sum of squares"
    (is (= 25 (sos 3 4)))))

(deftest sum-test
  (testing "homegrown addition function"
    (is (= 7 (sum 3 4)))
    (is (= 0 (sum 0 0)))))

(deftest sum-b-test
  (testing "peano addition function"
    (is (= 7 (sum-b 3 4)))
    (is (= 0 (sum-b 0 0)))))

(deftest fib-test
  (testing "fibonacci numbers"
    (is (= 0 (fib 0)))
    (is (= 1 (fib 1)))
    (is (= 1 (fib 2)))
    (is (= 3 (fib 4)))
    (is (= 5 (fib 5)))
    (is (= 21 (fib 8)))
    (is (= 55 (fib 10)))))
