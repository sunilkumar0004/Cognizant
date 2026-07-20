package com.cognizant.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDto;
import com.cognizant.employeemanagementsystem.projection.EmployeeOpenProjection;
import com.cognizant.employeemanagementsystem.projection.EmployeeSummary;
import com.cognizant.employeemanagementsystem.service.BatchProcessingService;
import com.cognizant.employeemanagementsystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BatchProcessingService batchProcessingService;

    // Exercise 4: Basic CRUD operations
    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee,
            @RequestParam(required = false) Long departmentId) {
        Employee created = employeeService.createEmployee(employee, departmentId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee,
            @RequestParam(required = false) Long departmentId) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee, departmentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Exercise 5: Query methods (Derived, JPQL, Native, Named)
    @GetMapping("/search/department")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentName(name));
    }

    @GetMapping("/search/jpql")
    public ResponseEntity<List<Employee>> getEmployeesByJPQL(@RequestParam String departmentName) {
        return ResponseEntity.ok(employeeService.getEmployeesByJPQL(departmentName));
    }

    @GetMapping("/search/native")
    public ResponseEntity<List<Employee>> getEmployeesByNativeSQL(@RequestParam String domain) {
        return ResponseEntity.ok(employeeService.getEmployeesByNativeSQL(domain));
    }

    @GetMapping("/search/named")
    public ResponseEntity<List<Employee>> getEmployeesByNamedQuery(@RequestParam String departmentName) {
        return ResponseEntity.ok(employeeService.getEmployeesByNamedQuery(departmentName));
    }

    // Exercise 6: Pagination and Sorting
    @GetMapping("/paged")
    public ResponseEntity<Page<Employee>> getEmployeesPagedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return ResponseEntity.ok(employeeService.getEmployeesPagedAndSorted(page, size, sortBy, sortDir));
    }

    // Exercise 8: Projections
    @GetMapping("/projections/summary")
    public ResponseEntity<List<EmployeeSummary>> getEmployeeSummaries(@RequestParam Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeeSummariesByDepartment(departmentId));
    }

    @GetMapping("/projections/open")
    public ResponseEntity<List<EmployeeOpenProjection>> getEmployeeOpenProjections(@RequestParam Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeeOpenProjectionsByDepartment(departmentId));
    }

    @GetMapping("/projections/dto")
    public ResponseEntity<List<EmployeeDto>> getEmployeeDtos(@RequestParam Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeeDtosByDepartment(departmentId));
    }

    // Exercise 10: Batch Operations
    @PostMapping("/batch")
    public ResponseEntity<String> batchSaveEmployees(@RequestBody List<Employee> employees) {
        batchProcessingService.saveEmployeesInBatch(employees);
        return ResponseEntity.ok("Batch processing completed successfully for " + employees.size() + " employees.");
    }
}
