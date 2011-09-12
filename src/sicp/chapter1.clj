(ns sicp.chapter1
  "# Building Abstractions with Procedures
   [fulltext](http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-9.html#%_chap_1)")

;; ## Elements of Programming
;;
;; + Primitive Arithmetic Operations
;; + Composite Operations
;; + Abstraction of Composite Operations
;;
;; ## Knowing vs Understanding
;;
;; A&S state that understanding the 'shape' of a process is key to
;; being a good programmer. They liken this understanding to that of a
;; good chess player. Understanding the rules of chess will let you
;; participate in a game, however, to become good at chess you must
;; understand what the patterns of pieces on the board mean for
;; possible ways the game can play out.
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
    (* n (factorial (- n 1)))))

;; OTOH, an iterative process for calculating factorials is marked by
;; an execution state that stays constant in weight, where state
;; variables are updated at each execution up to a pre-defined exit
;; condition.

(defn iterative-factorial
  "An *linear iterative* process for finding the factorial of `n`.

   "
  [n product counter max-count])

;; Notice the differences.  The recursive process implicitly encodes
;; state in the unfolding process, where state is defined explicitly
;; in the iterative process (`product`, `counter`, `max-count`).
;;
;; However, there are practical benefits to the iterative solution,
;; such as running in constant space, where the recursive solution
;; grows with each recursive call.


