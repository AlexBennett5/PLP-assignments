(ns assignment2clojure.factorialtest
  (:require [clojure.test :refer :all]
            [assignment2clojure.factorial :refer :all]))

(defn create_test [factorial function_name]
  (testing function_name
    (is (= 1  (factorial 0)))
    (is (= 1  (factorial 1)))
    (is (= 720  (factorial 6)))
    (is (= 479001600  (factorial 12)))
    (is (= 30414093201713378043612608166064768844377641568960512000000000000  (factorial 50))))
  )

(testing "canary"
  (is (= true true)))

(create_test iterative_factorial "iterative")
(create_test regular_recursive_factorial "regular_recursive")
(create_test tail_recursive_factorial "tail_recursive")
