# 3. spring-data-jpa-handson

This project covers advanced Hibernate Query Language (HQL), JPQL, Fetch optimization, Native Queries, and Criteria Queries using Spring Data JPA and Hibernate.

## Objectives Covered

1. **Hands-on 1**: Introduction to HQL and JPQL & feature comparisons.
2. **Hands-on 2**: Get all permanent employees using HQL with optimization (`JOIN FETCH` & `FetchType.LAZY`).
3. **Hands-on 3**: Fetch quiz attempt details across 6 joined entities using HQL `JOIN FETCH` and print formatted quiz output.
4. **Hands-on 4**: Aggregate functions in HQL (`AVG()` overall and parameterized by department ID).
5. **Hands-on 5**: Native Query execution (`SELECT * FROM employee`).
6. **Hands-on 6**: Criteria Query dynamic filter search implementation.

## How to Run

### Run Application Main:
```bash
mvn spring-boot:run
```

### Run Tests:
```bash
mvn clean test
```

Refer to `explanations.md` for complete concept breakdowns and architectural explanations.
