package com.cognizant.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

// Exercise 8: Interface-based open projection using SpEL @Value
public interface EmployeeOpenProjection {
    Long getId();
    String getName();
    String getEmail();

    @Value("#{target.name + ' (' + target.email + ')'}")
    String getFullNameAndEmail();
}
