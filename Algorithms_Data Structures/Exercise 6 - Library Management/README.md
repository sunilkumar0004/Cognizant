# Exercise 6: Library Management System

## 1. Search Algorithms Overview
- **Linear Search**: Scans elements one by one sequentially from start to end until a match is found or the list terminates. It operates on both sorted and unsorted collections.
- **Binary Search**: Fast search algorithm that works on sorted collections by repeatedly dividing the search interval in half. It compares the target value to the middle element, discarding half the search space in each step.

## 2. Complexity Comparison

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
|---|---|---|---|---|
| **Linear Search** | $O(1)$ | $O(N)$ | $O(N)$ | $O(1)$ |
| **Binary Search** | $O(1)$ | $O(\log N)$ | $O(\log N)$ | $O(1)$ |

## 3. Usage Recommendations
- **Linear Search**:
  - Use when the library book list is small.
  - Use when the collection is unsorted and we do not perform enough searches to justify the overhead of sorting it first.
- **Binary Search**:
  - Use when the library collection is large.
  - Use when the data is already sorted (e.g. books indexed alphabetically by title) or when the list is search-heavy, amortizing the initial sorting cost.
