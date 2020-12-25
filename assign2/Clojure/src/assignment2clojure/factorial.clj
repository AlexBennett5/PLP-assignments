(ns assignment2clojure.factorial)

(defn iterative_factorial [number]
  (reduce *' (range 1 (inc number))))

(defn regular_recursive_factorial [number]
  (if (< number 2) 1 (*' number (regular_recursive_factorial (dec number)))))

(defn tail_recursive_factorial [number & current_result]
  (if (< number 2) (or current_result 1)
                   (recur (dec number) (*' number (or current_result 1)))))
