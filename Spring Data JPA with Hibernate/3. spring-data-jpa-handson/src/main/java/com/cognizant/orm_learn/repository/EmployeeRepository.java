package com.cognizant.orm_learn.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands-on 2: Optimized HQL query with 'fetch' keyword to retrieve Employee, Department, and Skill list in a single query
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Hands-on 4: Aggregate function query for average salary across all employees
    @Query(value="SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    // Hands-on 4: Aggregate function query for average salary filtered by department id using parameter binding
    @Query(value="SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Hands-on 5: Native SQL query execution
    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
