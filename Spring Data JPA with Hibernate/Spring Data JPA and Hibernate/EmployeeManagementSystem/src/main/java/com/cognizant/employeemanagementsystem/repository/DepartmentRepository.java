package com.cognizant.employeemanagementsystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employeemanagementsystem.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Exercise 3: Derived query methods
    Optional<Department> findByName(String name);

    boolean existsByName(String name);
}
