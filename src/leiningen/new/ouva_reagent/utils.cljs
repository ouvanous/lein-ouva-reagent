(ns {{ns-name}}.utils)







(defn class-set 
  [cs]
  (clojure.string/join " " (map #(first %) 
    (filter #(true? (second %)) 
      cs))))







(defn get-timestamp 
  []
  (.getTime (js/Date.)))
