package com.cognizant.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.employeemanagementsystem.model.Department;
import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDto;
import com.cognizant.employeemanagementsystem.projection.EmployeeOpenProjection;
import com.cognizant.employeemanagementsystem.projection.EmployeeSummary;
import com.cognizant.employeemanagementsystem.repository.DepartmentRepository;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Exercise 4: Basic CRUD operations
    @Transactional
    public Employee createEmployee(Employee employee, Long departmentId) {
        if (departmentId != null) {
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
            employee.setDepartment(department);
        }
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee details, Long departmentId) {
        Employee employee = getEmployeeById(id);
        employee.setName(details.getName());
        employee.setEmail(details.getEmail());
        if (departmentId != null) {
            Department department = departmentRepository.findById(departmentId)
                    .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
            employee.setDepartment(department);
        }
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    // Exercise 5: Query methods
    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByJPQL(String departmentName) {
        return employeeRepository.fetchEmployeesByDepartmentJPQL(departmentName);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByNativeSQL(String domain) {
        return employeeRepository.fetchEmployeesByEmailDomainNative(domain);
    }

    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByNamedQuery(String departmentName) {
        return employeeRepository.findByDepartmentNameNamed(departmentName);
    }

    // Exercise 6: Pagination and Sorting
    @Transactional(readOnly = true)
    public Page<Employee> getEmployeesPagedAndSorted(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    // Exercise 8: Projections
    @Transactional(readOnly = true)
    public List<EmployeeSummary> getEmployeeSummariesByDepartment(Long departmentId) {
        return employeeRepository.findSummaryByDepartmentId(departmentId);
    }

    @Transactional(readOnly = true)
    public List<EmployeeOpenProjection> getEmployeeOpenProjectionsByDepartment(Long departmentId) {
        return employeeRepository.findProjectedByDepartmentId(departmentId);
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getEmployeeDtosByDepartment(Long departmentId) {
        return employeeRepository.findEmployeeDtosByDepartmentId(departmentId);
    }
}
