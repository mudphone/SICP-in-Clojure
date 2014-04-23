(ns sicp.lecture1b-test
  (:require [clojure.test :refer :all]
            [sicp.lecture1b :refer :all]))

(deftest sq-test
  (testing "simple test of squaring a number"
    (is (= 4 (sq 2)))))

(deftest sos-test
  (testing "sum of squares"
    (is (= 25 (sos 3 4)))))
