(ns sicp.lecture2a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2a :refer :all]))

(deftest sum-int-test
  (testing "sum of integers"
    (is (= 15 (sum-int 7 8)))))
