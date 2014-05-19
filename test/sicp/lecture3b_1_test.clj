(ns sicp.lecture3b-1-test
  (:require [clojure.test :refer :all]
            [sicp.lecture3b-1 :refer :all]))

(def EXP-X '(+ (* a (* x x))
               (+ (* b x)
                  c)))

(deftest constant?-test
  (testing "test for constant"
    (is (constant? 2 'x))))

(deftest same?-test
  (testing "test for same"
    (is (same? 'x 'x))))

(deftest sum?-test
  (testing "test for sum expression"
    (is (sum? '(+ 2 2)))
    (is (not (sum? '(* 2 2))))))

(deftest make-sum-test
  (testing "making a sum expression"
    (is (= 2 (a1 (make-sum 2 3))))
    (is (= 3 (a2 (make-sum 2 3))))))

(deftest product?-test
  (testing "test for product expression"
    (is (product? '(* 4 5)))
    (is (not (product? '(+ 4 5))))))

(deftest make-product-test
  (testing "making a product expression"
    (is (= 4 (m1 (make-product 4 5))))
    (is (= 5 (m2 (make-product 4 5))))))

(deftest deriv-test
  (testing "simple derivative"
    (is (= '(+ (+ (* a (+ (* x 1) (* 1 x)))
                  (* 0 (* x x)))
               (+ (+ (* b 1) (* 0 x))
                  0))
           (deriv EXP-X 'x)))))
