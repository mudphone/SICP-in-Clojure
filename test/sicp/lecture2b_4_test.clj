(ns sicp.lecture2b-4-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2b-4 :refer :all]))

(deftest car-test
  (testing "select first from cons'd thing"
    (is (= 1 (car (cons-l 1 2))))))

(deftest cdr-test
  (testing "select second from cons'd thing"
    (is (= 2 (cdr (cons-l 1 2))))))
