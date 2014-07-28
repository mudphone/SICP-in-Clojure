(ns sicp.lecture4b-polar-test
  (:require [clojure.test :refer :all]
            [sicp.lecture4b.polar :refer :all]))

(def TRI-3-4-5 (make-rectangular 3 4))
(def TRI-CLOSE-TO-90-DEG (make-rectangular 0.001 1))
(def TRI-WITH-0-DEG (make-rectangular 1 0))

(def TRI-WITH-45-DEG (make-polar 1 (/ Math/PI 4)))

(deftest make-polar-test
  (testing "creation of a complex representation using polar inputs"
    (let [complex (make-polar 1 (/ Math/PI 2))
          x (real-part complex)
          y (imag-part complex)]
      (is (> 0.1 x))
      (is (< 0.0 x))
      (is (= 1.0 y)))))

(deftest real-part-test
  (testing "selection of real part"
    (let [real (real-part TRI-3-4-5)]
      (is (> 3.1 real))
      (is (< 3 real)))))

(deftest imaginary-part-test
  (testing "selection of imaginary part"
    (let [imag (imag-part TRI-3-4-5)]
      (is (> 4 imag))
      (is (< 3.9 imag)))))

(deftest magnitude-test
  (testing "calc of magnitude"
    (is (= 5.0 (magnitude TRI-3-4-5)))))

(deftest angle-test
  (testing "calc of angle"
    (is (= 0.0 (angle TRI-WITH-0-DEG)))
    (let [degrees (* (/ 180.0 Math/PI) (angle TRI-CLOSE-TO-90-DEG))]
      (is (> 90.0 degrees))
      (is (< 89.9 degrees)))
    (let [degrees (* (/ 180.0 Math/PI) (angle TRI-WITH-45-DEG))]
      (is (= 45.0 degrees)))))

(deftest add-c-test
  (testing "polar complex addition operator"
    (let [sum (add-c (make-rectangular 2 3)
                     (make-rectangular 4 7))]
      (is (= 6.0 (real-part sum)))
      (is (= 10.0 (imag-part sum))))))

(deftest sub-c-test
  (testing "polar complex subtraction operator"
    (let [diff (sub-c (make-rectangular 4 5)
                      (make-rectangular 1 3))]
      (let [real (real-part diff)
            imag (imag-part diff)]
        (is (> 3 real))
        (is (< 2.999 real))
        (is (> 2 imag))
        (is (< 1.999 imag))))))

(deftest mul-c-test
  (testing "polar complex multiplication operator"
    (let [prod (mul-c (make-rectangular 3 7)
                      (make-rectangular 5 6))
          real (real-part prod)]
      (is (< -27.1 real))
      (is (> -27.0 real))
      (is (= 53.0 (imag-part prod))))))

(deftest div-c-test
  (testing "polar complex division operator"
    (let [quoti (div-c (make-rectangular 3 7)
                       (make-rectangular 5 6))
          real (real-part quoti)
          imag (imag-part quoti)]
      (is (> 0.94 real))
      (is (< 0.93 real))
      (is (> 0.28 imag))
      (is (< 0.27 imag)))))
