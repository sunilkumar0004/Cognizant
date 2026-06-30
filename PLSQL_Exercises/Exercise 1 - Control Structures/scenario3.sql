DECLARE
    CURSOR c_due_loans IS
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR r IN c_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || r.LoanID || ' for customer ' || r.Name || ' is due on ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
