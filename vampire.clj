(ns vampire
  (:gen-class))

(defn vampire
  []
  println "Say it' ")

(defn the-best
  [thing]
  (str thing " is the best"))

(def human-consumption [8.1 7.8 6.1 4.0])
(def critter-consumption [0.0 0.2 0.3 2.0])
(defn unify-diet-data
  [human critter]
  {:human human :critter critter})

