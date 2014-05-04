(ns sicp.lecture2a-2-test
  (:require [clojure.test :refer :all]
            [sicp.lecture2a-2 :refer :all]))

(deftest sqrt-test
  (testing "sqrt via heron method"
    (is (= 2.0 (sqrt 4)))))

(deftest sqrt-avg-damp-test
  (testing "sqrt via average damping simplification"
    (is (= 2.0 (sqrt-avg-damp 4)))))
