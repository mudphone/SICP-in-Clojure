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
