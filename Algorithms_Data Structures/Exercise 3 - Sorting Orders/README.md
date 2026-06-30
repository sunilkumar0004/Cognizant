# Exercise 3: Sorting Customer Orders

## 1. Sorting Algorithms Overview
- **Bubble Sort**: Simplest comparison sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. Very inefficient for large lists.
- **Insertion Sort**: Builds a sorted array one element at a time by extracting elements and placing them in their correct position relative to the already sorted portion. Good for small or nearly sorted datasets.
- **Quick Sort**: Divide-and-conquer algorithm. It selects a 'pivot' element, partitions the array around the pivot (smaller elements to the left, larger to the right), and recursively sorts the sub-arrays.
- **Merge Sort**: Divide-and-conquer algorithm. Recursively divides the array in half until individual elements are reached, then merges the sorted halves together. Extremely stable and guarantees $O(N \log N)$ worst-case.

## 2. Complexity Comparison

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
|---|---|---|---|---|
| **Bubble Sort** | $O(N)$ (optimized) | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N^2)$ | $O(\log N)$ |

## 3. Why Quick Sort is Preferred
- **Average Performance**: Quick Sort runs in $O(N \log N)$ average time, whereas Bubble Sort runs in $O(N^2)$ average time. For large datasets, the performance difference is massive.
- **Cache Friendliness**: Quick Sort has good locality of reference, meaning elements are checked sequentially in memory, optimizing CPU cache hits.
- **In-place Sorting**: Quick Sort does not require auxiliary array allocations like Merge Sort, saving memory space.
