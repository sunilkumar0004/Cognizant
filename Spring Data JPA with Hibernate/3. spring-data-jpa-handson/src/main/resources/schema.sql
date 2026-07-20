-- Department table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

-- Skill table
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

-- Employee table
CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(50) NOT NULL,
    em_salary DECIMAL(10,2) NOT NULL,
    em_permanent BOOLEAN NOT NULL,
    em_date_of_birth DATE NOT NULL,
    em_dp_id INT,
    CONSTRAINT fk_employee_department FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Employee Skill Mapping table
CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    PRIMARY KEY (es_em_id, es_sk_id),
    CONSTRAINT fk_es_employee FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    CONSTRAINT fk_es_skill FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Quiz User table
CREATE TABLE IF NOT EXISTS `user` (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(50) NOT NULL
);

-- Quiz Question table
CREATE TABLE IF NOT EXISTS question (
    qt_id INT AUTO_INCREMENT PRIMARY KEY,
    qt_text VARCHAR(255) NOT NULL
);

-- Quiz Options table
CREATE TABLE IF NOT EXISTS options (
    op_id INT AUTO_INCREMENT PRIMARY KEY,
    op_qt_id INT NOT NULL,
    op_score DECIMAL(3,1) NOT NULL,
    op_text VARCHAR(255) NOT NULL,
    CONSTRAINT fk_options_question FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

-- Quiz Attempt table
CREATE TABLE IF NOT EXISTS attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_us_id INT NOT NULL,
    at_date DATE NOT NULL,
    CONSTRAINT fk_attempt_user FOREIGN KEY (at_us_id) REFERENCES `user`(us_id)
);

-- Quiz Attempt Question table
CREATE TABLE IF NOT EXISTS attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT NOT NULL,
    aq_qt_id INT NOT NULL,
    CONSTRAINT fk_aq_attempt FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    CONSTRAINT fk_aq_question FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

-- Quiz Attempt Option table
CREATE TABLE IF NOT EXISTS attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_aq_id INT NOT NULL,
    ao_op_id INT NOT NULL,
    ao_selected BOOLEAN NOT NULL,
    CONSTRAINT fk_ao_attempt_question FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    CONSTRAINT fk_ao_options FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);

-- Retail Product table (for Hands-on 6 Criteria Query)
CREATE TABLE IF NOT EXISTS product (
    pr_id INT AUTO_INCREMENT PRIMARY KEY,
    pr_name VARCHAR(100) NOT NULL,
    pr_brand VARCHAR(50) NOT NULL,
    pr_price DECIMAL(10,2) NOT NULL,
    pr_ram_size INT NOT NULL,
    pr_hd_size INT NOT NULL,
    pr_os VARCHAR(50) NOT NULL,
    pr_weight DECIMAL(4,2) NOT NULL,
    pr_cpu VARCHAR(50) NOT NULL,
    pr_rating DECIMAL(2,1) NOT NULL
);
