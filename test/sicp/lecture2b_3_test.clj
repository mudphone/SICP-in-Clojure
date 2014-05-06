(ns sicp.lecture2b-3-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2b-3 :refer :all]
            [sicp.lecture1a :refer [abs]]))

(deftest xcor-test
  (testing "select x-coordinate of point"
    (is (= 1 (xcor (make-vector 1 2))))))

(deftest ycor-test
  (testing "select y-coordinate of point"
    (is (= 2 (ycor (make-vector 1 2))))))

(deftest midpoint-test
  (testing "calculation of midpoint of line segment"
    (let [a (make-vector -1 -1)
          b (make-vector 1 1)
          s (make-seg a b)
          mid (midpoint s)]
      (is (= 0.0 (xcor mid)))
      (is (= 0.0 (ycor mid))))))

(deftest length-test
  (testing "calculation of length of line segment"
    (let [a (make-vector 0 0)
          b (make-vector 0 1)
          s (make-seg a b)]
      (is (= 1.0 (float (length s)))))
    (let [a (make-vector 1 2)
          b (make-vector 10 11)
          s (make-seg a b)]
      (is (> 0.0001 (abs (- 12.7279221
                            (length s))))))))
