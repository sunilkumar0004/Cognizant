package com.cognizant.employeemanagementsystem.projection;

// Exercise 8: Class-based DTO projection used with JPQL constructor expressions
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", departmentName=" + departmentName + "]";
    }
}
