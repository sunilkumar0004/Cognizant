USE ormlearn;

-- Drop foreign key constraints and tables if they exist
DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS skill;

-- Create Department Table
CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

-- Create Employee Table
CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(50) NOT NULL,
    em_salary DECIMAL(10, 2) NOT NULL,
    em_permanent BOOLEAN NOT NULL,
    em_date_of_birth DATE NOT NULL,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id) ON DELETE SET NULL
);

-- Create Skill Table
CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

-- Create Join Table (employee_skill)
CREATE TABLE employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id) ON DELETE CASCADE,
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id) ON DELETE CASCADE
);

-- Populate Department Table
INSERT INTO department (dp_id, dp_name) VALUES (1, "IT");
INSERT INTO department (dp_id, dp_name) VALUES (2, "HR");

-- Populate Employee Table
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES (1, "John Doe", 50000.00, TRUE, "1990-01-01", 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) 
VALUES (2, "Jane Smith", 60000.00, TRUE, "1992-05-15", 1);

-- Populate Skill Table
INSERT INTO skill (sk_id, sk_name) VALUES (1, "Java");
INSERT INTO skill (sk_id, sk_name) VALUES (2, "Spring Boot");
INSERT INTO skill (sk_id, sk_name) VALUES (3, "SQL");

-- Populate Employee-Skill Relationships
-- John Doe (1) has Java (1) and SQL (3)
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 3);
-- Jane Smith (2) has Spring Boot (2)
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
