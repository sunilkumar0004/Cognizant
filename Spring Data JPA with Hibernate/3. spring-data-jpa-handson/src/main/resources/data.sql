-- Insert Departments
INSERT INTO department (dp_id, dp_name) VALUES (1, 'Payroll');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'HR');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Admin');

-- Insert Skills
INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Boot');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'SQL');

-- Insert Employees
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (1, 'John', 12500.00, true, '1995-01-01', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (2, 'Jack', 15000.00, true, '1992-06-15', 2);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (3, 'Jill', 8000.00, false, '1998-12-20', 3);

-- Insert Employee Skills
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1);

-- Insert Quiz User
INSERT INTO `user` (us_id, us_name) VALUES (1, 'John');

-- Insert Quiz Questions
INSERT INTO question (qt_id, qt_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO question (qt_id, qt_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO question (qt_id, qt_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO question (qt_id, qt_text) VALUES (4, 'Choose the right option to store text value value in a variable');

-- Insert Quiz Options for Question 1
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (1, 1, 0.0, '.xhtm');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (2, 1, 0.0, '.ht');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (3, 1, 1.0, '.html');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (4, 1, 0.0, '.htmx');

-- Insert Quiz Options for Question 2
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (5, 2, 0.0, '5');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (6, 2, 0.0, '3');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (7, 2, 0.0, '4');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (8, 2, 1.0, '6');

-- Insert Quiz Options for Question 3
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (9, 3, 0.0, 'false');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (10, 3, 1.0, 'true');

-- Insert Quiz Options for Question 4
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (11, 4, 0.5, '''John''');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (12, 4, 0.0, 'John');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (13, 4, 0.5, '"John"');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (14, 4, 0.0, '/John/');

-- Insert Quiz Attempt
INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, '2024-03-15');

-- Insert Attempt Questions
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (4, 1, 4);

-- Insert Attempt Options (Matching exact expected sample output in prompt!)
-- Question 1 attempt options: option 3 selected (.html)
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, 1, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (2, 1, 2, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (3, 1, 3, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (4, 1, 4, false);

-- Question 2 attempt options: option 6 selected ('3')
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (5, 2, 5, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (6, 2, 6, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (7, 2, 7, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (8, 2, 8, false);

-- Question 3 attempt options: option 10 selected ('true')
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (9, 3, 9, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (10, 3, 10, true);

-- Question 4 attempt options: option 11 selected (''John'')
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (11, 4, 11, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (12, 4, 12, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (13, 4, 13, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (14, 4, 14, false);

-- Insert Retail Products for Criteria Query
INSERT INTO product (pr_id, pr_name, pr_brand, pr_price, pr_ram_size, pr_hd_size, pr_os, pr_weight, pr_cpu, pr_rating) VALUES 
(1, 'XPS 15', 'Dell', 1500.00, 16, 512, 'Windows 11', 1.80, 'Intel i7', 4.8),
(2, 'MacBook Pro 16', 'Apple', 2400.00, 32, 1024, 'macOS', 2.15, 'M2 Pro', 4.9),
(3, 'ThinkPad X1', 'Lenovo', 1300.00, 16, 512, 'Windows 11', 1.12, 'Intel i7', 4.6),
(4, 'ZenBook 14', 'Asus', 950.00, 8, 256, 'Windows 11', 1.39, 'AMD Ryzen 7', 4.5),
(5, 'Pavilion 15', 'HP', 750.00, 16, 512, 'Windows 11', 1.75, 'Intel i5', 4.2);
