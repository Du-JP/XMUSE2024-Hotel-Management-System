CREATE TRIGGER trg_update_Ebook
ON Preservation
AFTER INSERT
AS
BEGIN
    -- ����Entertainments���е�Ebook����һ
    UPDATE Entertainments
    SET Ebook = Ebook + 1
    WHERE Eid IN (SELECT Eid FROM inserted);
END;
GO
