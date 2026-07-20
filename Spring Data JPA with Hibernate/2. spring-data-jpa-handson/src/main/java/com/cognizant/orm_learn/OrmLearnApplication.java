package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    private static CountryService countryService;
    private static StockRepository stockRepository;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        stockRepository = context.getBean(StockRepository.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // --- PART 1: Country Query Methods ---
        LOGGER.info("=== RUNNING COUNTRY QUERY METHOD TESTS ===");
        testFindCountryByNameContaining();
        testFindCountryByNameStartingWith();

        // --- PART 2: Stock Query Methods ---
        LOGGER.info("=== RUNNING STOCK QUERY METHOD TESTS ===");
        testGetFacebookStockSeptember2019();
        testGetGoogleStockGreaterThan1250();
        testGetTop3VolumeStocks();
        testGetLowest3NetflixStocks();

        // --- PART 3: O/R Mapping Relationship Tests ---
        LOGGER.info("=== RUNNING O/R MAPPING RELATIONSHIP TESTS ===");
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();

        LOGGER.info("All tests completed successfully!");
    }

    // --- Country Test Methods ---
    private static void testFindCountryByNameContaining() {
        LOGGER.info("Start testFindCountryByNameContaining");
        List<Country> countries = countryService.findCountryByNameContaining("ou");
        LOGGER.debug("Countries matching 'ou': {}", countries);
        LOGGER.info("End testFindCountryByNameContaining. Found: {}", countries.size());
    }

    private static void testFindCountryByNameStartingWith() {
        LOGGER.info("Start testFindCountryByNameStartingWith");
        List<Country> countries = countryService.findCountryByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End testFindCountryByNameStartingWith. Found: {}", countries.size());
    }

    // --- Stock Test Methods ---
    private static void testGetFacebookStockSeptember2019() {
        LOGGER.info("Start testGetFacebookStockSeptember2019");
        Date start = parseDate("2019-09-01");
        Date end = parseDate("2019-09-30");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
        LOGGER.debug("FB stocks in September 2019: {}", stocks);
        LOGGER.info("End testGetFacebookStockSeptember2019. Count: {}", stocks.size());
    }

    private static void testGetGoogleStockGreaterThan1250() {
        LOGGER.info("Start testGetGoogleStockGreaterThan1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("Google stocks close > 1250: {}", stocks);
        LOGGER.info("End testGetGoogleStockGreaterThan1250. Count: {}", stocks.size());
    }

    private static void testGetTop3VolumeStocks() {
        LOGGER.info("Start testGetTop3VolumeStocks");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 volume stocks: {}", stocks);
        LOGGER.info("End testGetTop3VolumeStocks");
    }

    private static void testGetLowest3NetflixStocks() {
        LOGGER.info("Start testGetLowest3NetflixStocks");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest 3 Netflix stocks: {}", stocks);
        LOGGER.info("End testGetLowest3NetflixStocks");
    }

    // --- Relationship Test Methods ---
    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        if (employee != null) {
            LOGGER.debug("Department: {}", employee.getDepartment());
            LOGGER.debug("Skills: {}", employee.getSkillList());
        }
        LOGGER.info("End testGetEmployee");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");
        Employee employee = new Employee("Richard Hendricks", new BigDecimal("75000.00"), true, parseDate("1993-04-10"));
        
        Department dept = departmentService.get(1); // IT
        employee.setDepartment(dept);
        
        employeeService.save(employee);
        LOGGER.debug("Saved Employee details: {}", employee);
        LOGGER.info("End testAddEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");
        Employee employee = employeeService.get(1);
        if (employee != null) {
            Department dept2 = departmentService.get(2); // HR
            employee.setDepartment(dept2);
            employeeService.save(employee);
            LOGGER.debug("Updated Employee: {}", employee);
        }
        LOGGER.info("End testUpdateEmployee");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        if (department != null) {
            LOGGER.debug("Employees under department: {}", department.getEmployeeList());
        }
        LOGGER.info("End testGetDepartment");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(2); // Spring Boot
        
        if (employee != null && skill != null) {
            if (employee.getSkillList() == null) {
                employee.setSkillList(new HashSet<>());
            }
            employee.getSkillList().add(skill);
            employeeService.save(employee);
            
            // Re-fetch to verify
            Employee reFetched = employeeService.get(1);
            LOGGER.debug("Re-fetched Employee Skills: {}", reFetched.getSkillList());
        }
        LOGGER.info("End testAddSkillToEmployee");
    }

    // --- Helper Methods ---
    private static Date parseDate(String dateStr) {
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
