(ns sicp.lecture4b-core-test
  (:require [clojure.test :refer :all]
            [sicp.lecture4b.core :refer :all]
            [sicp.lecture4b.rectangular :as rec]
            [sicp.lecture4b.polar :as pol]))

(deftest type-test
  (testing "selection of type from generic number"
    (is (= :rectangular (ntype (rec/gen-rectangular 1 2))))))

(deftest value-test
  (testing "selection of value from generic number"
    (is (= 1 (rec/real-part (nvalue (rec/gen-rectangular 1 2)))))))

(deftest rectangular-add-test
  (testing "generic add test with rectangular complex numbers"
    (let [z1 (rec/gen-rectangular 1 2)
          z2 (rec/gen-rectangular 2 3)
          sum (add z1 z2)]
      (is (= :rectangular (ntype sum)))
      (is (= 3 (rec/real-part (nvalue sum)))))))

(deftest polar-add-test
  (testing "generic add test with polar complex numbers"
    (let [z1 (pol/gen-polar (Math/sqrt 2) (/ Math/PI 4))
          z2 (pol/gen-polar (* 2 (Math/sqrt 2)) (/ Math/PI 4))
          sum (add z1 z2)
          val (nvalue sum)
          radians (pol/angle val)]
      (is (= :polar (ntype sum)))
      (is (= (* 3 (Math/sqrt 2)) (pol/magnitude val)))
      (is (> 45.0 (* (/ 180.0 Math/PI) radians)))
      (is (< 44.999 (* (/ 180.0 Math/PI) radians))))))
