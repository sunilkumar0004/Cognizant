package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Attempt;
import com.cognizant.orm_learn.model.AttemptOption;
import com.cognizant.orm_learn.model.AttemptQuestion;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Options;
import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchCriteria;
import com.cognizant.orm_learn.model.Question;
import com.cognizant.orm_learn.service.AttemptService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.ProductService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static AttemptService attemptService;
    private static ProductService productService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("OrmLearnApplication Started");

        employeeService = context.getBean(EmployeeService.class);
        attemptService = context.getBean(AttemptService.class);
        productService = context.getBean(ProductService.class);

        // Hands-on 2: Get all permanent employees using HQL
        LOGGER.info("=========================================");
        LOGGER.info("=== HANDS-ON 2: GET PERMANENT EMPLOYEES ===");
        LOGGER.info("=========================================");
        testGetAllPermanentEmployees();

        // Hands-on 3: Fetch quiz attempt details using HQL
        LOGGER.info("=========================================");
        LOGGER.info("=== HANDS-ON 3: FETCH QUIZ ATTEMPT DETAILS ===");
        LOGGER.info("=========================================");
        testGetAttempt();

        // Hands-on 4: Get average salary using HQL
        LOGGER.info("=========================================");
        LOGGER.info("=== HANDS-ON 4: GET AVERAGE SALARY ===");
        LOGGER.info("=========================================");
        testGetAverageSalary();

        // Hands-on 5: Get all employees using Native Query
        LOGGER.info("=========================================");
        LOGGER.info("=== HANDS-ON 5: GET ALL EMPLOYEES NATIVE ===");
        LOGGER.info("=========================================");
        testGetAllEmployeesNative();

        // Hands-on 6: Criteria Query dynamic search
        LOGGER.info("=========================================");
        LOGGER.info("=== HANDS-ON 6: CRITERIA QUERY SEARCH ===");
        LOGGER.info("=========================================");
        testCriteriaQuery();

        LOGGER.info("All Hands-on exercises completed successfully!");
    }

    // Hands-on 2 Test Method
    public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End testGetAllPermanentEmployees. Total permanent employees: {}", employees.size());
    }

    // Hands-on 3 Test Method
    public static void testGetAttempt() {
        LOGGER.info("Start testGetAttempt");
        Attempt attempt = attemptService.getAttempt(1, 1);
        if (attempt != null) {
            LOGGER.info("Attempt User: {}, Date: {}", attempt.getUser().getName(), attempt.getDate());
            
            for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
                Question question = aq.getQuestion();
                System.out.println("\n" + question.getText());
                
                int optionIndex = 1;
                for (AttemptOption ao : aq.getAttemptOptions()) {
                    Options option = ao.getOptions();
                    System.out.printf(" %d) %-12s %-5.1f   %b%n", 
                            optionIndex++, option.getText(), option.getScore(), ao.isSelected());
                }
            }
        } else {
            LOGGER.warn("No attempt found for User ID 1 and Attempt ID 1");
        }
        LOGGER.info("End testGetAttempt");
    }

    // Hands-on 4 Test Method
    public static void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");
        double avgSalaryAll = employeeService.getAverageSalary();
        LOGGER.info("Average Salary of all employees: {}", avgSalaryAll);

        int deptId = 1; // Payroll department
        double avgSalaryDept = employeeService.getAverageSalary(deptId);
        LOGGER.info("Average Salary of department ID {}: {}", deptId, avgSalaryDept);
        LOGGER.info("End testGetAverageSalary");
    }

    // Hands-on 5 Test Method
    public static void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("Native Query Employees: {}", employees);
        LOGGER.info("End testGetAllEmployeesNative. Count: {}", employees.size());
    }

    // Hands-on 6 Test Method
    public static void testCriteriaQuery() {
        LOGGER.info("Start testCriteriaQuery");
        
        // Scenario 1: Filter Windows laptops with RAM >= 16GB and max price $1600
        ProductSearchCriteria criteria1 = new ProductSearchCriteria();
        criteria1.setOs("Windows");
        criteria1.setRamSize(16);
        criteria1.setMaxPrice(new BigDecimal("1600.00"));
        
        List<Product> result1 = productService.searchProducts(criteria1);
        LOGGER.info("Criteria 1 (Windows, RAM>=16GB, Price<=$1600) Results: {}", result1.size());
        result1.forEach(p -> LOGGER.info("Found product: {}", p));

        // Scenario 2: Filter Apple laptops
        ProductSearchCriteria criteria2 = new ProductSearchCriteria();
        criteria2.setBrand("Apple");
        
        List<Product> result2 = productService.searchProducts(criteria2);
        LOGGER.info("Criteria 2 (Brand=Apple) Results: {}", result2.size());
        result2.forEach(p -> LOGGER.info("Found product: {}", p));
        
        LOGGER.info("End testCriteriaQuery");
    }
}
