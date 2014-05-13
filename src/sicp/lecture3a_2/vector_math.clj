(ns sicp.lecture3a-2.vector-math)

(defn vect+ [& vs]
  (vec (apply map + vs)))

(defn scale [scalar v]
  (vec (map * (repeat scalar) v)))
