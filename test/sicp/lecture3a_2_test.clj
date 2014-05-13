(ns sicp.lecture3a-2-test
  (:require [clojure.test :refer :all]
            [sicp.lecture3a-2.vector-math :refer :all]
            [sicp.lecture3a-2.rect :refer :all]))

(deftest vec+-test
  (testing "vector addition"
    (is (= [4 6] (vect+ [1 2] [3 4])))))

(deftest scale-test
  (testing "scalar multiplication of vector"
    (is (= [2 2] (scale 2 [1 1])))))

(deftest origin-test
  (testing "select origin from rect"
    (is (= [0 0] (origin (make-rect [0 0] [1 0] [0 1]))))))

(deftest horiz-test
  (testing "select horizontal vector from rect"
    (is (= [1 0] (horiz (make-rect [0 0] [1 0] [0 1]))))))

(deftest vert-test
  (testing "select vertical vector from rect"
    (is (= [0 1] (vert (make-rect [0 0] [1 0] [0 1]))))))
