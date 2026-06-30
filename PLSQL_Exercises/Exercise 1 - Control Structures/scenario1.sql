DECLARE
    CURSOR c_senior_loans IS
        SELECT l.LoanID, c.DOB
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
BEGIN
    FOR r IN c_senior_loans LOOP
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, r.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
