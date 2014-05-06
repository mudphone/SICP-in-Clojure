(ns sicp.lecture2b-2-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2b-2 :refer :all]))

(deftest gcd-test
  (testing "greatest common denominator"
    (is (= 5 (gcd 10 15)))))

(deftest numer-test
  (testing "selection of numerator"
    (is (= 1 (numer (make-rat 1 2))))
    (is (= 1 (numer (make-rat 2 4))))
    (is (= 3 (numer (make-rat 6 8))))))

(deftest denom-test
  (testing "selection of denominator"
    (is (= 2 (denom (make-rat 1 2))))
    (is (= 2 (denom (make-rat 2 4))))
    (is (= 4 (denom (make-rat 6 8))))))
