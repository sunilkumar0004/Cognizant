CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department VARCHAR2,
    p_bonus_percent NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percent / 100)
    WHERE Department = p_department;
    COMMIT;
END;
/
