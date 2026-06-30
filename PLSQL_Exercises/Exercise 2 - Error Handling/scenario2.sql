CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id NUMBER,
    p_percentage  NUMBER
) IS
    v_emp_count NUMBER;
    employee_not_found EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_emp_count FROM Employees WHERE EmployeeID = p_employee_id;
    IF v_emp_count = 0 THEN
        RAISE employee_not_found;
    END IF;
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;
    COMMIT;
EXCEPTION
    WHEN employee_not_found THEN
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'UpdateSalary', 'Employee ID ' || p_employee_id || ' does not exist.');
        COMMIT;
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'UpdateSalary', SQLERRM);
        COMMIT;
END;
/
