(ns sicp.lecture4b-1-rectangular-test
  (:require [clojure.test :refer :all]
            [sicp.lecture4b-1.rectangular :refer :all]))

(def complex-rec [3 4])

(deftest real-part-test
  (testing "selection of real part"
    (is (= 3 (real-part complex-rec)))))

(deftest imaginary-part-test
  (testing "selection of imaginary part"
    (is (= 4 (imag-part complex-rec)))))

(deftest magnitude-test
  (testing "calc of magnitude"
    (is (= 5.0 (magnitude complex-rec)))))

(deftest angle-test
  (testing "calc of angle"
    (is (= 0.0 (angle [0 1])))
    (let [degrees (* (/ 180.0 Math/PI) (angle [1 0.00001]))]
      (is (> 90.0 degrees))
      (is (< 89.9 degrees)))))
