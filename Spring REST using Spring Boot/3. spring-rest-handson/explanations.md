# Spring REST Hands-on 3 - Explanations

---

## 1. REST Web Service Architecture (Controller -> Service -> DAO)

### Architecture Layers:
1. **Controller Layer (`@RestController`)**:
   - Handles incoming HTTP GET/PUT requests (`/employees`, `/departments`).
   - Delegates business logic to the Service layer.
   - Automatically serializes returned domain models (`Employee`, `Department`) to JSON HTTP payloads.

2. **Service Layer (`@Service`)**:
   - Encapsulates transactional business operations using `@Transactional`.
   - Coordinates operations between controller handlers and DAO data sources.

3. **DAO Layer (`@Repository`)**:
   - `DepartmentDao` and `EmployeeDao` initialize static `DEPARTMENT_LIST` and `EMPLOYEE_LIST` from Spring XML configuration (`employee.xml`).
   - Encapsulates data fetching and list updates.

---

## 2. Spring XML Bean Configuration (`employee.xml`)
- Defines static `Department` and `Skill` beans.
- Defines `Employee` beans with nested date parsing (`SimpleDateFormat.parse()`) and bean references (`ref`).
- Defines `ArrayList` container beans (`departmentList`, `employeeList`) loaded into DAOs via `ClassPathXmlApplicationContext`.

---

## 3. Endpoints Implemented
- `GET /employees`: Returns complete array of employee objects with nested department and skills metadata.
- `PUT /employees`: Updates specified employee instance in memory.
- `GET /departments`: Returns complete array of department options.
