(ns sicp.lecture4b-rectangular-test
  (:require [clojure.test :refer :all]
            [sicp.lecture4b.rectangular :refer :all]))

(def TRI-3-4-5 (make-rectangular 3 4))
(def TRI-CLOSE-TO-90-DEG (make-rectangular 0.001 1))
(def TRI-WITH-0-DEG (make-rectangular 1 0))

(def TRI-WITH-45-DEG (make-polar 1 (/ Math/PI 4)))

(deftest make-rectangular-test
  (testing "creation of a complex representation useing rectangular inputs"
    (is (= 3 (real-part (make-rectangular 3 4))))
    (is (= 4 (imag-part (make-rectangular 3 4))))))

(deftest make-polar-test
  (testing "creation of a complex representation using polar inputs"
    (let [complex (make-polar 1 (/ Math/PI 2))
          x (real-part complex)
          y (imag-part complex)]
      (is (and (> 0.1 x) (< 0.0 x)))
      (is (= 1.0 y)))))

(deftest real-part-test
  (testing "selection of real part"
    (is (= 3 (real-part TRI-3-4-5)))))

(deftest imaginary-part-test
  (testing "selection of imaginary part"
    (is (= 4 (imag-part TRI-3-4-5)))))

(deftest magnitude-test
  (testing "calc of magnitude"
    (is (= 5.0 (magnitude TRI-3-4-5)))))

(deftest angle-test
  (testing "calc of angle"
    (is (= 0.0 (angle TRI-WITH-0-DEG)))
    (let [degrees (* (/ 180.0 Math/PI) (angle TRI-CLOSE-TO-90-DEG))]
      (is (and (> 90.0 degrees) (< 89.9 degrees))))
    (let [degrees (* (/ 180.0 Math/PI) (angle TRI-WITH-45-DEG))]
      (is (= 45.0 degrees)))))

(deftest add-c-test
  (testing "rectangular complex addition operator"
    (let [sum (add-c (make-rectangular 2 3)
                     (make-rectangular 4 7))]
      (is (= 6 (real-part sum)))
      (is (= 10 (imag-part sum))))))

(deftest sub-c-test
  (testing "rectangular complex subtraction operator"
    (let [diff (sub-c (make-rectangular 4 5)
                      (make-rectangular 1 3))]
      (is (= 3 (real-part diff)))
      (is (= 2 (imag-part diff))))))

(deftest mul-c-test
  (testing "rectangular complex multiplication operator"
    (let [prod (mul-c (make-rectangular 3 7)
                      (make-rectangular 5 6))
          real (real-part prod)]
      (is (and (< -27.1 real) (> -27.0 real)))
      (is (= 53.0 (imag-part prod))))))

(deftest div-c-test
  (testing "rectangular complex division operator"
    (let [quoti (div-c (make-rectangular 3 7)
                       (make-rectangular 5 6))
          real (real-part quoti)
          imag (imag-part quoti)]
      (is (and (> 0.94 real) (< 0.93 real)))
      (is (and (> 0.28 imag) (< 0.27 imag))))))
