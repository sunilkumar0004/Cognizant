CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account NUMBER,
    p_to_account   NUMBER,
    p_amount       NUMBER
) IS
    v_from_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account FOR UPDATE;
    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account;
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'SafeTransferFunds', 'Insufficient funds in account ' || p_from_account);
        COMMIT;
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorTime, ProcedureName, ErrorMessage)
        VALUES (SYSDATE, 'SafeTransferFunds', SQLERRM);
        COMMIT;
END;
/
