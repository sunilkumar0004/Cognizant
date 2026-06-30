# Exercise 5: Task Management System

## 1. Linked List Concepts
- **Singly Linked List**: Each node contains data and a single reference (`next`) to the next node in the sequence. It can only be traversed forward.
- **Doubly Linked List**: Each node contains data and two references: one pointing to the next node (`next`) and another pointing to the previous node (`prev`). This supports bi-directional traversal, though it consumes slightly more memory per node.

## 2. Complexity Analysis (Singly Linked List)

| Operation | Time Complexity | Rationale |
|---|---|---|
| **Add** (at tail) | $O(N)$ | Without a tail pointer, we must traverse from `head` to locate the last element to link it. (Would be $O(1)$ with a tail pointer). |
| **Search** | $O(N)$ | Must scan nodes sequentially from the `head` until a match is found. |
| **Traverse** | $O(N)$ | Visits each node sequentially once. |
| **Delete** | $O(N)$ | Must locate the element and its predecessor sequentially to bypass the node. |

## 3. Advantages of Linked Lists over Arrays
- **Dynamic Allocation**: Linked lists dynamically grow and shrink in memory on-demand, whereas arrays have a rigid pre-allocated size.
- **No Shift Overhead**: Inserting or deleting a node requires only updating references ($O(1)$ pointer adjustments), while arrays require shifting subsequent elements in memory.
- **Memory Utilization**: Memory is allocated only when a new task is added, avoiding unused pre-allocated buffer overhead.
