CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id NUMBER,
    p_name        VARCHAR2,
    p_dob         DATE,
    p_balance     NUMBER
) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'AddNewCustomer', 'Customer ID ' || p_customer_id || ' already exists.');
        COMMIT;
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'AddNewCustomer', SQLERRM);
        COMMIT;
END;
/
