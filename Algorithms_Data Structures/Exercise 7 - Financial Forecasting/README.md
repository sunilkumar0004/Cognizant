# Exercise 7: Financial Forecasting

## 1. Concept of Recursion
- **Definition**: Recursion is a programming technique where a method calls itself directly or indirectly to solve a problem. It solves a complex problem by breaking it down into smaller sub-problems of the same nature.
- **Simplification**: Many mathematical formulas (like Fibonacci, Factorials, tree traversals, and compounding growth) naturally fit a inductive definition, making recursive code highly clean and readable.

## 2. Complexity Analysis
- **Time Complexity**: $O(N)$ where $N$ is the number of periods (years/steps). Each recursive call performs $O(1)$ operations and decrements the period by 1.
- **Space Complexity**: $O(N)$ auxiliary call stack space. Each recursive call places a new frame on the system call stack. For extremely large $N$, this can trigger a `StackOverflowError`.

## 3. Optimizations to Avoid Excessive Computation
- **Memoization (Top-down caching)**: Storing the results of expensive function calls and returning the cached result when the same inputs occur again. (Crucial for sub-problems like Fibonacci, though not strictly required for simple single-branch linear growth).
- **Iterative Approach (Bottom-up)**: Refactoring the recursive algorithm into a loop (e.g. `calculateFutureValueIterative()`). This runs in $O(N)$ time but cuts the space complexity to $O(1)$ by removing call stack allocation.
- **Tail Recursion**: Some compilers optimize tail-recursive calls to run in $O(1)$ space, though standard Java Virtual Machines (JVM) do not currently guarantee tail-call optimization (TCO).
