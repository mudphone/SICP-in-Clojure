(ns sicp.lecture4b.core
  (:require [sicp.lecture4b.rectangular :as rec]
            [sicp.lecture4b.polar :as pol]))

;; Generic Operators
;; Lecture 4B, Part 1 - Text Section 2.3
;; Dispatch on Type (First Half)
;; https://www.youtube.com/watch?v=h6Z7vx9iUB8&index=8&list=PLB63C06FAF154F047

(def TABLE
  {:rectangular {:add rec/add-c
                 :sub rec/sub-c
                 :mul rec/mul-c
                 :div rec/div-c}
   :polar {:add pol/add-c
           :sub pol/sub-c
           :mul pol/mul-c
           :div pol/div-c}})

(defn ntype [z]
  (:type z))

(defn nvalue [z]
  (:value z))

(defn wrap [t z]
  {:type t
   :value z})

(defmulti add (fn [z1 z2]
                (let [t1 (:type z1)
                      t2 (:type z2)]
                  (if (= t1 t2)
                    t1
                    :error))))

(defmethod add :default
  [_ _]
  "Types do not match, or unknown types.")

(defmethod add :rectangular
  [z1 z2]
  (wrap (ntype z1)
        (rec/add-c (nvalue z1) (nvalue z2))))

(defmethod add :polar
  [z1 z2]
  (wrap (ntype z1)
        (pol/add-c (nvalue z1) (nvalue z2))))
