# 3. spring-rest-handson (spring-learn)

Layered REST Architecture (Controller -> Service -> DAO) retrieving static XML data (`employee.xml`).

## Objectives Covered

1. **Spring XML Configuration**: Configured `employee.xml` with Departments, Skills, and 4 Employees in `employeeList` and `departmentList`.
2. **DAO Layer**: `DepartmentDao` and `EmployeeDao` retrieving static lists from `employee.xml`.
3. **Service Layer**: `DepartmentService` and `EmployeeService` marked with `@Service` and `@Transactional`.
4. **Controller Layer**:
   - `DepartmentController`: `GET /departments`
   - `EmployeeController`: `GET /employees` and `PUT /employees`
5. **MockMVC Integration Tests**: Automated tests for GET `/employees`, GET `/departments`, and PUT `/employees`.

## How to Run

### Run Application:
```powershell
.\mvnw.cmd spring-boot:run
```

### Run Tests:
```powershell
.\mvnw.cmd clean test
```
