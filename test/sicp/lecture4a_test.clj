(ns sicp.lecture4a-test
  (:require [clojure.test :refer :all]
            [sicp.lecture4a :refer :all]))

;; https://www.youtube.com/watch?v=amf5lTZ0UTc

;; Pattern Match - ~10:05
;; foo matches exactly foo
;; (f a b) matches a list whose first element is f
;;                              second        is a
;;                              third         is b
;; (? x) matches anything, call it x
;; (?c x) matches a constant, call it x
;; (?v x) matches a variable, call it x

;; Skeletons - ~10:47
;; foo instantiates to itself
;; (f a b) instantiates to a 3-list result of
;;         instantiating each of f, a, b
;; (: x) instantiate to the value of x
;;       in the matched pattern

(deftest arbitrary-constant?-test
  (testing "check for arbitrary constant pattern"
    (is (arbitrary-constant? '(?c x)))
    (is (not (arbitrary-constant? '(?v x))))
    (is (not (arbitrary-constant? '(? x))))))

(deftest arbitrary-variable?-test
  (testing "check for arbitrary variable pattern"
    (is (not (arbitrary-variable? '(?c x))))
    (is (arbitrary-variable? '(?v x)))
    (is (not (arbitrary-variable? '(? x))))))

(deftest arbitrary-expression?-test
  (testing "check for arbitrary expression pattern"
    (is (not (arbitrary-expression? '(?c x))))
    (is (not (arbitrary-expression? '(?v x))))
    (is (arbitrary-expression? '(? x)))))

(deftest match-atomic-patterns-test
  (testing "matching atomic patterns"
    (is (= (match 1 1 'failed) 'failed))
    (is (= (match 'x 'x {'x 1}) {'x 1}))
    (is (= (match 'x 'y nil) 'failed))
    (is (= (match 'x '(+ 1 1) nil) 'failed))
    (is (= (match '(+ 1 1) 'y nil) 'failed))))

(deftest match-arbitrary-constant-test
  (testing "matching arbitrary constant clauses"
    (is (= (match '(?c x) 5 {}) {'(?c x) 5}))
    (is (= (match '(?c x) '(* 1 2) {}) 'failed))
    (is (= (match '(?c x) 5 {'(?c x) 20}) 'failed))))

(deftest match-arbitrary-variable-test
  (testing "matching arbitrary variable clauses"
    (is (= (match '(?v x) 'x {}) {'(?v x) 'x}))
    (is (= (match '(?v x) '(* 1 2) {}) 'failed))
    (is (= (match '(?v x) 'z {'(?v x) 'x}) 'failed))))

(deftest match-arbitrary-expression-test
  (testing "matching arbitrary expression clauses"
    (is (= (match '(? x) '(+ 1 2) {}) {'(? x) '(+ 1 2)}))
    (is (= (match '(? x) '(+ 1 2) {'(? x) 'x}) 'failed))))

(deftest extend-dict-test
  (testing "extension of dictionary"
    (is (= (extend-dict 'x 1 {'x 2}) 'failed))
    (is (= (extend-dict 'x 1 {'x 1}) {'x 1}))
    (is (= (extend-dict 'y 1 {'x 2}) {'x 2 'y 1}))))

(deftest evaluate-test
  (testing "evaluation of expression"
    (is (= 5 (evaluate 'x {'x 5})))
    (is (= 3 (evaluate '(+ x y) {'+ + 'x 1 'y 2})))))

#_(deftest dsimp-test
  (testing "simplifier for derivatives"
    (is (= (dsimp '(dd (+ x y) x))
           '(+ 1 0)))))

#_(deftest tree-test
  (testing "tree test"
    (let [pat '(+ (* (? x) (? y)) (? y))]
      (is (= (match pat '(+ (* 3 x) x))
             {'x 3 'y 'x}))
      (is (= (match pat '(+ (* 3 )))
             'failed)))))
