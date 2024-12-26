CREATE TRIGGER trg_update_Ebook
ON Preservation
AFTER INSERT
AS
BEGIN
    -- 更新Entertainments表中的Ebook数加一
    UPDATE Entertainments
    SET Ebook = Ebook + 1
    WHERE Eid IN (SELECT Eid FROM inserted);
END;
GO
