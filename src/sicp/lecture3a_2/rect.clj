(ns sicp.lecture3a-2.rect)

(defn make-rect
  "Create a rectangle representation"
  [o h v]
  [o h v])

(defn origin
  "Select the origin of a rect"
  [r]
  (first r))

(defn horiz
  "Select the horizontal vector of a rect"
  [r]
  (second r))

(defn vert
  "Select the vertical vector of a rect"
  [r]
  (last r))
