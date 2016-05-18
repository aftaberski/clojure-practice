(ns vampire
  (:gen-class))

(defn vampire
  []
  println "Say it")

(defn the-best
  [thing]
  (str thing " is the best"))

(def human-consumption [8.1 7.8 6.1 4.0])
(def critter-consumption [0.0 0.2 0.3 2.0])
(defn unify-diet-data
  [human critter]
  {:human human :critter critter})

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  ; iterating over vector of functions
  ; applying each func to numbers
  (map #(% numbers) [sum count avg]))

(def vampires
  [{:name "Bella" :age 18}
   {:name "Edward" :age 10000000}
   {:name "Renesmee" :age 0}])

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 45 :min 3})

(defn filter-with-reduce
  []
  (reduce (fn [new-map [key val]]
            (if (> val 5)
              (assoc new-map key val)
              new-map))
          {}
          {:item1 8 :item2 3}))

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(defn filter-human
  []
  (filter #(< (:human %) 5) food-journal))

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire? 

  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire? (map vampire-related-details social-security-numbers))))

(defn batman-ditty
  []
  (concat (take 8 (repeat "na")) ["Batman"]))

(defn rando-nums
  []
  (take 3 (repeatedly (fn [] (rand-int 5)))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(defn my-conj
  [target & additions]
  (into target additions))

(defn my-into
  [target additions]
  (apply conj target additions))

(def add10 (partial + 10))
