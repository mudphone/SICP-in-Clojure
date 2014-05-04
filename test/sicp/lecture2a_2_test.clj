(ns sicp.lecture2a-2-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2a-2 :refer :all]))

_#(deftest sum-int-test
  (testing "sum of integers"
    (is (= 15 (sum-int 7 8)))))
