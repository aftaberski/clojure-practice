(defn test
  []
  println "Test hobbit")

(def hobbit-body-parts 
  [{:name "head" :size 3}
   {:name "left-eye" :size 1}
   {:name "left-ear" :size 1}
   {:name "mouth" :size 1}
   {:name "nose" :size 1}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(def list-of-foods-i-am-eating-right-now
  ["Bananas" "Crakers" "Peanut Butter"])

(defn print-all-of-the-foodz 
  []
  (loop [food list-of-foods-i-am-eating-right-now]
    (println food)))
