(ns sicp.lecture2b-1-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2b-1 :refer :all]
            [sicp.lecture2b-2 :refer [denom make-rat numer]]))

(deftest make-rat-numer-test
  (testing "select numerator of rational"
    (is (= 2 (numer (make-rat 2 3))))
    (is (= 1 (numer (make-rat 2 4))))))

(deftest make-rat-denom-test
  (testing "select denomenator of rational"
    (is (= 4 (denom (make-rat 3 4))))
    (is (= 2 (denom (make-rat 2 4))))))

(deftest plus-rat-numer-test
  (testing "rational addition"
    (let [rat (+rat (make-rat 1 2)
                    (make-rat 1 4))]
      (is (= 3 (numer rat)))
      (is (= 4 (denom rat))))))

(deftest mult-rat-numer-test
  (testing "rational multiplication"
    (let [rat (*rat (make-rat 3 4)
                    (make-rat 2 3))]
      (is (= 1 (numer rat)))
      (is (= 2 (denom rat))))))
