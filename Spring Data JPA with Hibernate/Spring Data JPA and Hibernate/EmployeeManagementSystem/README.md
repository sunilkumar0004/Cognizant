# Employee Management System

Spring Boot application covering Spring Data JPA and Hibernate Exercises 1 to 10.

## Exercises Implemented

1. **Exercise 1**: Project Initialization & H2 Database Configuration.
2. **Exercise 2**: Entity Definition & Mappings (`Employee`, `Department`).
3. **Exercise 3**: Repositories & Derived Queries.
4. **Exercise 4**: RESTful CRUD Operations.
5. **Exercise 5**: Custom JPQL, Native SQL, and Named Queries.
6. **Exercise 6**: Pagination and Sorting (`Pageable`, `Sort`).
7. **Exercise 7**: Entity Auditing (`@EnableJpaAuditing`, `@CreatedBy`, `@CreatedDate`).
8. **Exercise 8**: Projections (Closed Interface, Open Interface, Class DTO).
9. **Exercise 9**: Externalized Data Source Configuration.
10. **Exercise 10**: Hibernate Features (`@DynamicUpdate`, `@DynamicInsert`, `@BatchSize`) and Batch Processing.

## Running the Application

### Build & Run Tests:
```powershell
.\mvnw.cmd clean test
```

### Run Application:
```powershell
.\mvnw.cmd spring-boot:run
```

H2 Console available at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: `password`
