CREATE TRIGGER trg_update_ebook_on_customer_checkout
ON Customer
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- 只处理Indeedout不为null的情况
    IF EXISTS (SELECT 1 FROM inserted WHERE Indeedout IS NOT NULL)
    BEGIN
        -- 更新Entertainments表的Ebook数
        UPDATE Entertainments
        SET Ebook = Ebook - 1
        WHERE Eid IN (
            SELECT p.Eid
            FROM Preservation p
            INNER JOIN inserted i ON p.Cid = i.Cid
            WHERE i.Indeedout IS NOT NULL
        );
    END
END;
GO
