CREATE TRIGGER trg_check_checkout_time
ON Customer
AFTER UPDATE
AS
BEGIN
    IF UPDATE(Outtime)
    BEGIN
        IF EXISTS (SELECT 1 FROM inserted WHERE Outtime <= Intime)
        BEGIN
            RAISERROR ('Outtime must be later than Intime.', 16, 1);
            ROLLBACK TRANSACTION;
        END;
    END;
END;
GO
