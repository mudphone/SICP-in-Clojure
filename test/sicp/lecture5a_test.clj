(ns sicp.lecture5a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture5a :refer :all]))

(deftest estimate-pi-test
  (testing "an estimated pi"
    (is (let [pi-ish (estimate-pi 10)]
          (or
           (= "Error: Divide by zero." pi-ish)
           (and
            (< 0.1 pi-ish)
            (> 6.0 pi-ish)))) "Somewhat near Pi")))
