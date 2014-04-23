(ns sicp.lecture1a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture1a :refer :all]))

(deftest square-test
  (testing "simple test of squaring a number"
    (is (= 4 (square 2)))))

(deftest abs-test
  (testing "simple test of absolute value"
    (is (= 4 (abs -4)))
    (is (= 4 (abs 4)))
    (is (= 0 (abs 0)))))

(deftest average-test
  (testing "caluclates an average of the given numbers"
    (is (= 2.0 (average 2 2 2)))
    (is (nil? (average)))
    (is (= 3.5 (average 5 2)))))

(defn round [x]
  (read-string (format "%.3f" x)))

(deftest sqrt-test
  (testing "square root of num"
    (is (= 2.0 (round (sqrt 4))))
    (is (= 3.0 (round (sqrt 9))))
    (is (= 5.0 (round (sqrt 25))))
    (is (= 10.0 (round (sqrt 100))))))
