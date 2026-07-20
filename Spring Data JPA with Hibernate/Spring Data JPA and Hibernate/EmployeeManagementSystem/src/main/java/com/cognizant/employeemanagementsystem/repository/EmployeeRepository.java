package com.cognizant.employeemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDto;
import com.cognizant.employeemanagementsystem.projection.EmployeeOpenProjection;
import com.cognizant.employeemanagementsystem.projection.EmployeeSummary;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exercise 3: Derived query methods
    List<Employee> findByName(String name);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    List<Employee> findByDepartmentId(Long departmentId);

    // Exercise 5: Custom @Query method using JPQL
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> fetchEmployeesByDepartmentJPQL(@Param("departmentName") String departmentName);

    // Exercise 5: Custom @Query method using Native SQL
    @Query(value = "SELECT * FROM employees WHERE email LIKE %:domain%", nativeQuery = true)
    List<Employee> fetchEmployeesByEmailDomainNative(@Param("domain") String domain);

    // Exercise 5: Executing Named Queries defined in Employee entity
    List<Employee> findByDepartmentNameNamed(@Param("departmentName") String departmentName);

    List<Employee> findByEmailDomainNamed(@Param("domain") String domain);

    // Exercise 6: Pagination and Sorting methods
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    Page<Employee> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

    // Exercise 8: Interface-based closed projection
    List<EmployeeSummary> findSummaryByDepartmentId(Long departmentId);

    // Exercise 8: Interface-based open projection
    List<EmployeeOpenProjection> findProjectedByDepartmentId(Long departmentId);

    // Exercise 8: Class-based DTO projection using constructor expression
    @Query("SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeDto(e.id, e.name, e.email, e.department.name) " +
           "FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeDto> findEmployeeDtosByDepartmentId(@Param("deptId") Long deptId);
}
