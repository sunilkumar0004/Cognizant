# Hands-on 1: Introduction to HQL and JPQL & Hands-on 6: Criteria Query

---

## Hands-on 1: HQL vs JPQL Overview

### What is HQL?
- **HQL** stands for **Hibernate Query Language**.
- It is an object-oriented query language, similar to SQL, but instead of operating on database tables and columns, HQL operates on Java entity classes and entity attributes (instance variables).

### What is JPQL?
- **JPQL** stands for **Java Persistence Query Language**.
- It is the standard query language defined by the JPA (Java Persistence API) specification.

### HQL vs JPQL Comparison
- **JPQL is a proper subset of HQL**: All JPQL queries are valid HQL queries, but not all HQL queries are valid JPQL queries.
- **Supported Operations**:
  - Both HQL and JPQL support `SELECT`, `UPDATE`, and `DELETE` statements.
  - HQL additionally supports `INSERT INTO ... SELECT ...` statements directly in the query language.
- **Portability**: JPQL is vendor-neutral (works across EclipseLink, OpenJPA, Hibernate), whereas HQL includes Hibernate-specific features (such as standard functions, additional join syntax, and HQL `INSERT`).

---

## HQL Key Features & Optimizations

### 1. `@Query` Annotation
Used in Spring Data JPA repository interfaces to define custom HQL/JPQL or native SQL queries.
```java
@Query(value = "SELECT e FROM Employee e WHERE e.permanent = true")
List<Employee> getAllPermanentEmployees();
```

### 2. HQL `fetch` Keyword (Resolving N+1 Query Problem)
- `JOIN` links entities in the query, but does **not** fetch/populate associated collections/beans into memory.
- `JOIN FETCH` forces Hibernate to fetch the related entities in a **single SQL JOIN query**, avoiding N+1 query overhead and avoiding `LazyInitializationException` when collections are configured with `FetchType.LAZY`.
```java
@Query(value = "SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
List<Employee> getAllPermanentEmployees();
```

### 3. Aggregate Functions in HQL
HQL supports standard SQL aggregate functions (`AVG()`, `COUNT()`, `MAX()`, `MIN()`, `SUM()`) operating on entity fields.
```java
@Query(value = "SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
double getAverageSalary(@Param("id") int id);
```

### 4. Native Queries
- Enabled using `nativeQuery = true` in `@Query`.
- Runs raw SQL directly against the database engine.
- Use sparingly to maintain database portability across dialects.
```java
@Query(value = "SELECT * FROM employee", nativeQuery = true)
List<Employee> getAllEmployeesNative();
```

---

## Hands-on 6: Need and Benefits of Criteria Query

### Scenario: Dynamic Search / Multi-Criteria Filter (e.g. Retail / E-Commerce Search)
Consider an e-commerce platform (like Amazon) where users search for products and apply multiple optional filters (e.g. Brand, Max Price, RAM size, OS, Rating, Weight, CPU).
- Since any combination of filters can be selected or omitted, static HQL queries with fixed `WHERE` clauses cannot handle all dynamic filter combinations cleanly without cluttering code with string concatenations.

### Why Criteria Query?
1. **Dynamic Query Generation**: Constructs queries programmatically at runtime based on conditional inputs without risky string concatenation.
2. **Type Safety**: Provides compile-time checking of query attributes, preventing runtime typos in table/column names.
3. **Refactoring Support**: Refactoring an entity class or field automatically cascades to Criteria queries via the Metamodel.

### Key Criteria API Components:
- **`CriteriaBuilder`**: Factory for creating criteria queries, expressions, and predicates (`cb.equal()`, `cb.lessThanOrEqualTo()`, `cb.like()`).
- **`CriteriaQuery<T>`**: Represents the main query structure.
- **`Root<T>`**: Represents the FROM clause entity root.
- **`Predicate`**: Represents conditional expressions (WHERE clause filters).
- **`TypedQuery<T>`**: Execution wrapper returning typed entity results.

```java
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> cq = cb.createQuery(Product.class);
Root<Product> product = cq.from(Product.class);

List<Predicate> predicates = new ArrayList<>();
if (criteria.getBrand() != null) {
    predicates.add(cb.equal(product.get("brand"), criteria.getBrand()));
}
if (criteria.getMaxPrice() != null) {
    predicates.add(cb.lessThanOrEqualTo(product.get("price"), criteria.getMaxPrice()));
}
cq.where(predicates.toArray(new Predicate[0]));

TypedQuery<Product> query = entityManager.createQuery(cq);
List<Product> results = query.getResultList();
```
