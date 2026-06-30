# Exercise 1: Inventory Management System

## 1. Concept: Essentiality of Data Structures & Algorithms
- **Performance**: In an inventory system containing thousands or millions of products, basic linear searches or array shifts for inserts/deletes become slow ($O(N)$), leading to high response latency.
- **Resource Management**: Efficient data structures optimize CPU utilization and memory footprints when querying, filtering, or updating records continuously.

## 2. Suitable Data Structures
- **ArrayList / Array**: Good for index-based sequential reads but slow for inserts, updates, and deletes ($O(N)$) because elements must be shifted.
- **LinkedList**: $O(1)$ insertions/deletions if we have pointers, but searching is $O(N)$.
- **HashMap (Chosen)**: Key-value mapping where the key is the `productId`. This provides near $O(1)$ search, insert, and delete times on average, which is ideal for constant product updates and lookups.

## 3. Complexity Analysis (HashMap)
- **Add Operation**: $O(1)$ average time complexity.
- **Update Operation**: $O(1)$ average time complexity to fetch the element by ID and mutate its fields.
- **Delete Operation**: $O(1)$ average time complexity.

## 4. Optimization
- **Initial Capacity**: Configure the initial capacity and load factor of the HashMap to avoid expensive bucket resizing operations when the inventory grows.
- **Caching**: Frequently accessed products can be cached using a Least Recently Used (LRU) cache.
