# Exercise 2: E-commerce Platform Search Function

## 1. Asymptotic Notation (Big O)
- **Definition**: Big O notation measures the upper bound of an algorithm's execution runtime or memory workspace requirements relative to the size of the input data ($N$). It abstracts away CPU hardware differences to evaluate efficiency.
- **Scenarios**:
  - **Best Case**: The minimum execution steps required (e.g. finding the element on the first check, $O(1)$).
  - **Average Case**: The expected execution steps over arbitrary distributions of inputs.
  - **Worst Case**: The absolute maximum steps taken (e.g. checking every single element and not finding it, $O(N)$).

## 2. Comparison of Search Algorithms

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
|---|---|---|---|---|
| **Linear Search** | $O(1)$ | $O(N)$ | $O(N)$ | $O(1)$ |
| **Binary Search** | $O(1)$ | $O(\log N)$ | $O(\log N)$ | $O(1)$ |

## 3. Platform Choice & Suitability
- **Linear Search** is ideal when the product dataset is small or when catalog updates are frequent and sorting the array continually is too expensive.
- **Binary Search** is far superior for large-scale e-commerce catalogs because $O(\log N)$ scaling searches millions of products in fewer than 20 comparisons. However, it requires the array to be pre-sorted.
- **Recommendation**: For standard platforms, products are pre-sorted by database indexes or background tasks, making **Binary Search** (or equivalent tree-based indexed searches) the optimal choice for search queries.
