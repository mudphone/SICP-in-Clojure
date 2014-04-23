(ns sicp.lecture1a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture1a :refer :all]))

(deftest square-test
  (testing "simple test of squaring a number"
    (is (= 4 (square 2)))))
