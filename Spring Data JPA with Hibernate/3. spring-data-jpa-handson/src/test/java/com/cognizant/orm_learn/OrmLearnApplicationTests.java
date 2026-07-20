package com.cognizant.orm_learn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.orm_learn.model.Attempt;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchCriteria;
import com.cognizant.orm_learn.service.AttemptService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.ProductService;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttemptService attemptService;

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        assertThat(employeeService).isNotNull();
        assertThat(attemptService).isNotNull();
        assertThat(productService).isNotNull();
    }

    @Test
    void testGetAllPermanentEmployees() {
        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployees();
        assertThat(permanentEmployees).isNotEmpty();
    }

    @Test
    void testGetAttempt() {
        Attempt attempt = attemptService.getAttempt(1, 1);
        assertThat(attempt).isNotNull();
        assertThat(attempt.getAttemptQuestions()).hasSize(4);
    }

    @Test
    void testGetAverageSalary() {
        double avgSalary = employeeService.getAverageSalary();
        assertThat(avgSalary).isGreaterThan(0.0);
    }

    @Test
    void testGetAllEmployeesNative() {
        List<Employee> employees = employeeService.getAllEmployeesNative();
        assertThat(employees).hasSize(3);
    }

    @Test
    void testCriteriaQuery() {
        ProductSearchCriteria criteria = new ProductSearchCriteria();
        criteria.setBrand("Dell");
        List<Product> products = productService.searchProducts(criteria);
        assertThat(products).hasSize(1);
    }
}
