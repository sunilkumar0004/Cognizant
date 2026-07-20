package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees");
        List<Employee> employees = employeeDao.getAllEmployees();
        LOGGER.info("END getAllEmployees");
        return employees;
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        LOGGER.info("START updateEmployee: {}", employee);
        employeeDao.updateEmployee(employee);
        LOGGER.info("END updateEmployee");
    }
}
