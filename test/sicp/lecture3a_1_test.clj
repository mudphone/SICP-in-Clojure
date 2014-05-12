(ns sicp.lecture3a-1-test
  (:require [clojure.test :refer :all]
            [sicp.lecture3a-1 :refer :all]
            [sicp.lecture2b-4 :refer [car cdr]]))

(deftest list-1-to-4-test
  (testing "list of 4 values"
    (is (= 1 (car list-1-to-4)))
    (is (= 2 (car (cdr list-1-to-4))))
    (is (= 3 (car (cdr (cdr list-1-to-4)))))
    (is (= nil (cdr (cdr (cdr (cdr list-1-to-4))))))))

(deftest scale-list-test
  (testing "simple scaling of list values"
    (is (= 2 (car (scale-list 2 list-1-to-4))))
    (is (= 4 (car (cdr (scale-list 2 list-1-to-4)))))))

(deftest scale-list-map-test
  (testing "simple scaling via map procedure"
    (let [scaled (scale-list-map 10 list-1-to-4)]
      (is (= 10 (car scaled)))
      (is (= 20 (car (cdr scaled)))))))

(deftest for-each-test
  (testing "side effects"
    (is (= "done" (for-each (fn [n] (+ n 2)) list-1-to-4)))))
