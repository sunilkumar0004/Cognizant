# Employee Management System - Exercises 1 to 10 Explanations

---

## Exercise 1: Overview and Setup
- Spring Boot project initialized with `Spring Data JPA`, `H2 Database`, `Spring Web`, and `Lombok`.
- Configured H2 in-memory connection properties in `application.properties`:
  ```properties
  spring.datasource.url=jdbc:h2:mem:testdb
  spring.datasource.driverClassName=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=password
  spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
  ```

---

## Exercise 2: Creating Entities
- **`Employee`** and **`Department`** mapped with standard JPA annotations:
  - `@Entity`, `@Table`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
  - Defined bidirectional One-To-Many relationship (`@OneToMany(mappedBy = "department")` and `@ManyToOne`).

---

## Exercise 3: Creating Repositories
- Defined `EmployeeRepository` and `DepartmentRepository` extending `JpaRepository`.
- Derived query methods (`findByName`, `findByEmail`, `findByDepartmentName`, `findByNameContainingIgnoreCase`).

---

## Exercise 4: Implementing CRUD Operations
- Implemented `EmployeeService`, `DepartmentService`, `EmployeeController`, and `DepartmentController`.
- RESTful HTTP Endpoints (`POST`, `GET`, `PUT`, `DELETE`) exposed for both entities.

---

## Exercise 5: Defining Custom & Named Query Methods
- Custom JPQL queries via `@Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")`.
- Native SQL queries via `@Query(value = "SELECT * FROM employees WHERE email LIKE %:domain%", nativeQuery = true)`.
- Defined JPA Named Queries using `@NamedQueries` and `@NamedQuery` on `Employee` entity and executed through Spring Data JPA repository method declarations.

---

## Exercise 6: Implementing Pagination and Sorting
- Leveraged `Pageable`, `PageRequest`, `Sort`, and `Page<T>` return types.
- REST endpoint `GET /api/employees/paged?page=0&size=5&sortBy=name&sortDir=asc` supports dynamic sorting and page size controls.

---

## Exercise 7: Enabling Entity Auditing
- Enabled auditing using `@EnableJpaAuditing(auditorAwareRef = "auditorProvider")`.
- Abstract mapped superclass `Auditable` equipped with `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `@LastModifiedBy`, and `@EntityListeners(AuditingEntityListener.class)`.

---

## Exercise 8: Creating Projections
- **Interface Closed Projection**: `EmployeeSummary` returning only required fields (`getId()`, `getName()`, `getEmail()`).
- **Interface Open Projection**: `EmployeeOpenProjection` with SpEL `@Value("#{target.name + ' (' + target.email + ')'}")`.
- **Class-based DTO Projection**: `EmployeeDto` instantiated via JPQL constructor expressions: `SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeDto(e.id, e.name, e.email, e.department.name)`.

---

## Exercise 9: Customizing Data Source Configuration
- Externalized database connection configuration in `application.properties`.
- Supports custom DataSource beans and multi-datasource routing.

---

## Exercise 10: Hibernate-Specific Features & Batching
- **Hibernate Annotations**: `@DynamicUpdate`, `@DynamicInsert`, and `@BatchSize(size = 10)` on collection relationships to prevent N+1 query overhead.
- **Batch Processing**: Configured `hibernate.jdbc.batch_size=20` and implemented bulk entity saving in `BatchProcessingService` using `EntityManager.persist()`, `flush()`, and `clear()`.
