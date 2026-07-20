package com.cognizant.employeemanagementsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.cognizant.employeemanagementsystem.model.Department;
import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDto;
import com.cognizant.employeemanagementsystem.projection.EmployeeOpenProjection;
import com.cognizant.employeemanagementsystem.projection.EmployeeSummary;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;
import com.cognizant.employeemanagementsystem.service.BatchProcessingService;
import com.cognizant.employeemanagementsystem.service.DepartmentService;
import com.cognizant.employeemanagementsystem.service.EmployeeService;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BatchProcessingService batchProcessingService;

    private Department engineering;
    private Department hr;

    @BeforeEach
    void setUp() {
        employeeRepository.deleteAll();
        departmentRepository.deleteAll();

        engineering = departmentService.createDepartment(new Department("Engineering"));
        hr = departmentService.createDepartment(new Department("Human Resources"));
    }

    @Test
    void contextLoads() {
        assertThat(employeeService).isNotNull();
        assertThat(departmentService).isNotNull();
    }

    // Exercise 2 & 4: Entity Creation, Mappings, CRUD
    @Test
    void testCreateAndReadEmployee() {
        Employee emp = new Employee("Alice Smith", "alice@example.com", engineering);
        Employee created = employeeService.createEmployee(emp, engineering.getId());

        assertThat(created.getId()).isNotNull();
        assertThat(created.getName()).isEqualTo("Alice Smith");

        Employee fetched = employeeService.getEmployeeById(created.getId());
        assertThat(fetched.getEmail()).isEqualTo("alice@example.com");
    }

    // Exercise 5: Query Methods (Derived, JPQL, Native, Named)
    @Test
    void testQueryMethods() {
        employeeService.createEmployee(new Employee("Bob Jones", "bob@cognizant.com", engineering), engineering.getId());
        employeeService.createEmployee(new Employee("Charlie Brown", "charlie@cognizant.com", hr), hr.getId());

        List<Employee> byDept = employeeService.getEmployeesByDepartmentName("Engineering");
        assertThat(byDept).isNotEmpty();

        List<Employee> byJpql = employeeService.getEmployeesByJPQL("Engineering");
        assertThat(byJpql).isNotEmpty();

        List<Employee> byNative = employeeService.getEmployeesByNativeSQL("cognizant.com");
        assertThat(byNative).hasSize(2);

        List<Employee> byNamed = employeeService.getEmployeesByNamedQuery("Engineering");
        assertThat(byNamed).isNotEmpty();
    }

    // Exercise 6: Pagination and Sorting
    @Test
    void testPaginationAndSorting() {
        for (int i = 1; i <= 10; i++) {
            employeeService.createEmployee(new Employee("Employee " + i, "emp" + i + "@test.com", engineering), engineering.getId());
        }

        Page<Employee> pagedResult = employeeService.getEmployeesPagedAndSorted(0, 5, "name", "asc");
        assertThat(pagedResult.getContent()).hasSize(5);
        assertThat(pagedResult.getTotalElements()).isEqualTo(10);
    }

    // Exercise 7: Entity Auditing
    @Test
    void testAuditing() {
        Employee emp = employeeService.createEmployee(new Employee("Audited User", "audit@test.com", hr), hr.getId());
        assertThat(emp.getCreatedDate()).isNotNull();
        assertThat(emp.getCreatedBy()).isEqualTo("SystemAdmin");
    }

    // Exercise 8: Projections (Summary, Open, DTO)
    @Test
    void testProjections() {
        employeeService.createEmployee(new Employee("Projected User", "projected@test.com", engineering), engineering.getId());

        List<EmployeeSummary> summaries = employeeService.getEmployeeSummariesByDepartment(engineering.getId());
        assertThat(summaries).isNotEmpty();

        List<EmployeeOpenProjection> openProjections = employeeService.getEmployeeOpenProjectionsByDepartment(engineering.getId());
        assertThat(openProjections).isNotEmpty();
        assertThat(openProjections.get(0).getFullNameAndEmail()).contains("Projected User");

        List<EmployeeDto> dtos = employeeService.getEmployeeDtosByDepartment(engineering.getId());
        assertThat(dtos).isNotEmpty();
        assertThat(dtos.get(0).getDepartmentName()).isEqualTo("Engineering");
    }

    // Exercise 10: Batch Operations
    @Test
    void testBatchProcessing() {
        List<Employee> batchList = new ArrayList<>();
        for (int i = 100; i < 150; i++) {
            batchList.add(new Employee("Batch User " + i, "batch" + i + "@test.com", hr));
        }
        batchProcessingService.saveEmployeesInBatch(batchList);

        List<Employee> nativeCheck = employeeService.getEmployeesByNativeSQL("test.com");
        assertThat(nativeCheck.size()).isEqualTo(50);
    }
}
