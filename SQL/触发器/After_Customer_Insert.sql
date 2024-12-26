CREATE TRIGGER After_Customer_Insert
ON Customer
AFTER INSERT
AS
BEGIN
    -- 更新房间状态为已预定
    UPDATE Room
    SET Rstate = '已预订'
    WHERE Rid IN (SELECT inserted.Rid FROM inserted);
END;
GO