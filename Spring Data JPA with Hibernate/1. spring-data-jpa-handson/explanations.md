# Explanations for Spring Data JPA and Hibernate Concepts

This document summarizes the core conceptual walk-throughs for Hands-on 2, 3, and 4.

---

## Hands-on 2: Hibernate XML Configuration Walkthrough

### 1. Object-to-Relational Mapping (ORM) in Hibernate XML
In traditional Hibernate XML configuration, classes are mapped to tables using an `.hbm.xml` mapping file:
- `<class>` defines the class-to-table mapping (e.g. mapping `Employee` class to `EMPLOYEE` table).
- `<id>` defines the primary key mapping and generator.
- `<property>` defines mapping for standard fields to columns.

Example XML mapping snippet:
```xml
<hibernate-mapping>
   <class name="Employee" table="EMPLOYEE">
      <meta attribute="class-description">
         This class contains the employee detail. 
      </meta>
      <id name="id" type="int" column="id">
         <generator class="native"/>
      </id>
      <property name="firstName" column="first_name" type="string"/>
      <property name="lastName" column="last_name" type="string"/>
      <property name="salary" column="salary" type="int"/>
   </class>
</hibernate-mapping>
```

### 2. Core Hibernate Interfaces
- **SessionFactory:** A thread-safe, immutable cache of compiled mappings for a single database. It acts as a factory for `Session` instances.
- **Session:** Represents a single, short-lived unit of work with the database. It wraps a JDBC connection and acts as a transactional context for persistent objects.
- **Transaction:** A single-threaded, short-lived object used to demarcate physical transactions.

### 3. Session Operations and Transaction Management
- **beginTransaction():** Begins a new physical database transaction associated with the current session.
- **commit():** Flushes pending changes in the session to the database and commits the current transaction.
- **rollback():** Rolls back the database transaction in case of exceptions, reverting pending changes.
- **session.save(entity):** Persists the transient entity instance in the database and returns the generated identifier.
- **session.get(Class, id):** Retrieves a persistent instance from the database using its primary key (or returns `null` if not found).
- **session.createQuery(hql).list():** Executes a Hibernate Query Language (HQL) query and returns the results as a Java List.
- **session.delete(entity):** Removes the persistent entity instance from the database.

---

## Hands-on 3: Hibernate Annotation Configuration Walkthrough

### 1. Core JPA & Hibernate Annotations
Annotation-based mapping replaces XML files by defining metadata directly on the Java classes:
- **`@Entity`:** Identifies that the class is a JPA entity representing a database table.
- **`@Table`:** Customizes the database table mapping details (e.g., custom name, schema).
- **`@Id`:** Marks the property that serves as the unique primary key identifier.
- **`@GeneratedValue`:** Configures the primary key generation strategy (e.g., `AUTO`, `IDENTITY`, `SEQUENCE`, `TABLE`).
- **`@Column`:** Configures column mapping details (e.g., name, length, nullable, unique).

### 2. Hibernate Configuration XML (`hibernate.cfg.xml`)
The configuration XML defines how Hibernate connects to the database:
- **Dialect (`hibernate.dialect`):** Tells Hibernate how to generate SQL dialect specific to the target database engine (e.g. `org.hibernate.dialect.MySQL8Dialect`).
- **Driver (`connection.driver_class`):** The fully qualified class name of the JDBC driver (e.g. `com.mysql.cj.jdbc.Driver`).
- **Connection URL (`connection.url`):** The JDBC database url (e.g. `jdbc:mysql://localhost:3306/ormlearn`).
- **Username / Password:** Credentials to connect to the database.

---

## Hands-on 4: Difference Between JPA, Hibernate, and Spring Data JPA

| Aspect | Java Persistence API (JPA) | Hibernate | Spring Data JPA |
|---|---|---|---|
| **Role** | Specification / Standard | ORM Tool / Implementation | High-level Abstraction Layer |
| **Concept** | JSR 338. Defines interface API annotations and behaviors. | Concrete implementation of the JSR 338 JPA specifications. | Provides a repository abstraction above the JPA provider (Hibernate). |
| **Boilerplate** | Medium. Requires using `EntityManager` and managing transactions manually. | High. Requires manually opening sessions, starting transactions, committing, and closing. | Extremely Low. Autowired repository interfaces implement CRUD operations out-of-the-box. |
| **Transaction Management** | Requires manual coding or container-managed transactions. | Handled via physical `Transaction` objects in session code. | Managed declaratively using the `@Transactional` annotation. |

### Code Comparison: Create Operation

#### Hibernate (Manual Session & Transaction Handling)
```java
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

#### Spring Data JPA (Declarative Service & Repository)
```java
// Repository Interface
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

// Service Layer
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
```
