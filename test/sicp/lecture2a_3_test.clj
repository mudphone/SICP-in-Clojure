(ns sicp.lecture2a-3-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2a-3 :refer :all]
            [sicp.lecture1a :refer [abs]]))

(deftest sqrt-test
  (testing "sqrt via Newton's method"
    (is (> 0.0001 (abs (- 2.0 (sqrt 4)))))))

