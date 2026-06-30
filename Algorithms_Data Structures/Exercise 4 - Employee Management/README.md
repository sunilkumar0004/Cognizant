# Exercise 4: Employee Management System

## 1. Array Representation in Memory
- **Contiguous Allocation**: Arrays are stored in contiguous memory blocks. Each index maps to a specific physical address calculated via a base address and index offset:
  $$\text{Address}(A[i]) = \text{BaseAddress} + (i \times \text{SizeOfElement})$$
- **Advantages**:
  - **Constant Time Access**: Fetching elements by index is $O(1)$.
  - **Cache Locality**: Sequential contiguous data storage maximizes CPU pre-fetching efficiency.

## 2. Complexity Analysis

| Operation | Time Complexity | Rationale |
|---|---|---|
| **Add** | $O(1)$ | Inserting at the end of the array (using a tracked counter) takes constant time. |
| **Search** | $O(N)$ | Finding an employee by ID requires traversing the array linearly in the worst case. |
| **Traverse** | $O(N)$ | Accessing every single cell in the array sequentially. |
| **Delete** | $O(N)$ | Locating the element takes $O(N)$, and shifting remaining elements left takes $O(N)$ time. |

## 3. Limitations & Best Use Cases
- **Limitations**:
  - **Fixed Size**: Once initialized, array size cannot be altered dynamically.
  - **Shift Overhead**: Inserting/deleting elements inside the array requires shifting elements, which is slow for large datasets.
- **When to Use**:
  - Use arrays when the number of elements is known beforehand and is relatively static, or when $O(1)$ index lookup speed is critical.
