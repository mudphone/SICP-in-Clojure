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
    (is (= (match '(?c x) 5 {}) {'x 5}))
    (is (= (match '(?c x) '(* 1 2) {}) 'failed))
    (is (= (match '(?c x) 5 {'x 20}) 'failed))))

(deftest match-arbitrary-variable-test
  (testing "matching arbitrary variable clauses"
    (is (= (match '(?v x) 'x {}) {'x 'x}))
    (is (= (match '(?v x) '(* 1 2) {}) 'failed))
    (is (= (match '(?v x) 'z {'x 'x}) 'failed))))

(deftest match-arbitrary-expression-test
  (testing "matching arbitrary expression clauses"
    (is (= (match '(? x) '(+ 1 2) {}) {'x '(+ 1 2)}))
    (is (= (match '(? x) '(+ 1 2) {'x 'x}) 'failed))))

(deftest extend-dict-test
  (testing "extension of dictionary"
    (is (= (extend-dict '(? x) 'y (empty-dict)) {'x 'y}))
    (is (= (extend-dict '(? x) 'y {'x 'y}) {'x 'y}))
    (is (= (extend-dict '(? x) 'y {'x 'z}) 'failed))
    (is (= (extend-dict '(?c x) 1 (empty-dict)) {'x 1}))
    (is (= (extend-dict '(?v x) 1 {'x 1}) {'x 1}))
    (is (= (extend-dict '(?v y) 1 {'x 2}) {'x 2 'y 1}))))

(deftest evaluate-test
  (testing "evaluation of expression"
    (is (= 5 (evaluate 'x {'x 5})))
    (is (= 3 (evaluate '(+ x y) {'+ + 'x 1 'y 2})))))

(deftest compound?-test
  (testing "check for compound expression"
    (is (compound? '(+ 1 2)))
    (is (not (compound? 'x)))
    (is (not (compound? 5)))))

(deftest pattern-test
  (testing "select pattern from rule"
    (let [rule '( (dd (?c c) (? v)) 0 )]
      (is (= '(dd (?c c) (? v)) (pattern rule))))))

(deftest skeleton-test
  (testing "select skeleton from rule"
    (let [rule '( (dd (+ (? x1) (? x2)) (? v))
                  (+ (dd (?= x1) (?= v))
                     (dd (?= x2) (?= v))) )]
      (is (= '(+ (dd (?= x1) (?= v))
                 (dd (?= x2) (?= v)))
             (skeleton rule))))))

(deftest simple-dsimp-test
  (testing "single simple rules"
    (let [rules '( ( (dd (?c c) (? v)) 0 ) )]
      (is (= ((simplifier rules)
              '(dd 5 y))
             0)))
    (let [rules '( ( (dd (?v v) (? v)) 1 ) )]
      (is (= ((simplifier rules)
              '(dd x x))
             1)))
    (let [rules '( ( (dd (?v u) (? v)) 0 ) )]
      (is (= ((simplifier rules)
              '(dd x y))
             0)))
    (let [rules '( ( (dd (?v u) (? v)) 0 ) )]
      (is (= ((simplifier rules)
              '(dd y x))
             0)))
    (let [rules '( ( (dd (?v v) (? v)) 1 )
                   ( (dd (?v u) (? v)) 0 ) )]
      (is (= ((simplifier rules)
              '(dd y x))
             0)))))

(deftest complex-match-test
  (testing "complex rule matching"
    (let [rule '( (dd (+ (? x1) (? x2)) (? v))
                  (+ (dd (?= x1) (?= v))
                     (dd (?= x2) (?= v))) )
          pat (pattern rule)]
      (is (= (match pat '(dd (+ x y) y)
                    (empty-dict))
             {'x1 'x
              'x2 'y
              'v 'y}
             ))
      )))

(deftest complex-dsimp-test
  (testing "single complex rules"
    (let [rules '( ( (dd (?c c) (? v)) 0 )
                   ( (dd (?v v) (? v)) 1 )
                   ( (dd (?v u) (? v)) 0 )

                   ( (dd (+ (? x1) (? x2)) (? v))
                     (+ (dd (?= x1) (?= v))
                        (dd (?= x2) (?= v))) ) )]
      (is (= ((simplifier rules)
              '(dd (+ x y) x))
             '(+ 1 0))))))

(deftest tree-test
  (testing "tree test"
    (let [pat '(+ (* (? x) (? y)) (? y))]
      (is (= (match pat '(+ (* 3 x) x) (empty-dict)) 
             {'x 3 'y 'x}))
      (is (= (match pat '(+ (* 3 x) y) (empty-dict))
             'failed)))))

(deftest dsimp-test
  (testing "simplifier for derivatives"
    (is (= (dsimp '(dd (+ x y) x))
           '(+ 1 0)))
    (is (= (dsimp '(dd (* x y) x))
           '(+ (* x 0)
               (* 1 y))))
    (is (= (dsimp '(dd (** x 5) x))
           '(* (* 5
                  (** x 4))
               1)))))
