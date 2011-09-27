(ns sicp.chapter1
  "# Building Abstractions with Procedures
   [fulltext](http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-9.html#%_chap_1)")

;; ## Elements of Programming
;;
;; + Primitive Arithmetic Operations
;; + Composite Operations
;; + Abstraction of Composite Operations
;;
;;
;; ## Knowing vs Understanding
;;
;; A&S state that understanding the 'shape' of a process is key to
;; being a good developer. They liken this understanding to that of a
;; good chess player. Understanding the rules of chess will let you
;; participate in a game, however, to become good at chess you must
;; understand what the patterns of pieces on the board mean for
;; possible ways the game can play out.
;;
;;
;; ## Recursive vs Iterative Processes
;;
;; "A procedure is a **pattern** for the local evolution of a
;; computational process. It specifies how each stage of the process
;; is **built upon the previous stage**."
;;
;; *Recursive* can describe both a conceptual solution to a problem,
;; and / or it's implementation

(defn recursive-factorial
  "A *linear recursive* process for finding the factorial of `n`.

  The evolution of the execution of this bit of code is marked by two
  phases: an expansion of calls to `recursive-factorial`, and a contraction of
  the wholly expanded version down to one term.

      => (factorial 3)
      -> (* 3 (factorial 2))
      -> (* 3 (* 2 (factorial 1)))
      -> (* 3 (* 2 1))
      -> 6"
  [n]
  (if (= n 1)
    1
    (* n (recursive-factorial (- n 1)))))

;; OTOH, an iterative process for calculating factorials is marked by
;; an execution state that stays constant in weight, where state
;; variables are updated at each execution up to a pre-defined exit
;; condition.

(defn iterative-factorial
  "An *linear iterative* process for finding the factorial of `n`."
  [accumulator counter max]
  (if (> counter max)
    accumulator
    (recur (* accumulator counter)
           (inc counter)
           max)))

;; Notice the differences.  The recursive process implicitly encodes
;; state in the unfolding process, where state is defined explicitly
;; in the iterative process (`accumulator`, `counter`, `max-count`).
;;
;; However, there are practical benefits to the iterative solution,
;; such as running in constant space, where the recursive solution
;; grows with each recursive call.


;; ## Recursion: Process vs. Procedure
;;
;; Both `recursive-factorial` and `iterative-factorial` are
;; *implemented* using recursion, and are said to be *recursive
;; procedures*.  However, they differ in their processes. The
;; iterative version, at each execution of the procedure, contains all
;; information required to execute the next step of the process.  The
;; recursive version does not contain this information.


;; # Example 1.9
;;
;; Illustrate the process generated for `+x` and `+y` on arguments 4
;; and 5.


;; (+ 4 5)
;; (inc (+ (dec 4) 5)                    => (inc (+ 3 5)
;; (inc (inc (+ (dec 3) 5)))             => (inc (inc (+ 2 5)))
;; (inc (inc (inc (+ (dec 2) 5))))       => (inc (inc (inc (+ 1 5))))
;; (inc (inc (inc (inc (+ (dec 1) 5))))) => (inc (inc (inc (inc (+ 0 5)))))
;; (inc (inc (inc (inc 5))))             => (inc (inc (inc 6)))
;; (inc (inc (inc 6)))                   => (inc (inc 7))
;; (inc (inc 7))                         => (inc 8)
;; (inc 8)                               => 9

(defn + [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))


;; (+ 4 5)
;; (+ (dec 4) (inc 5))  =>  (+ 3 6)
;; (+ (dec 3) (inc 6))  =>  (+ 2 7)
;; (+ (dec 2) (inc 7))  =>  (+ 1 8)
;; (+ (dec 1) (inc 8))  =>  (+ 0 9)
;; 9

(defn + [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b))))

;; One thing I've noticed is that the final result of substitution at
;; each step of the iterative process leaves `+` as the outer most
;; call. Perhaps this is the test to see if a function is allowed to
;; be tail-call optimized.


;; # Excercise 1.10

(defn A [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else   (A (- x 1)
                   (A x (- y 1)))))





