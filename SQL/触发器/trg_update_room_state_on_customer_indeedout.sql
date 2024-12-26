CREATE TRIGGER trg_update_room_state_on_customer_indeedout
ON Customer
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- 更新Room表的Rstate为‘空闲’，当Customer表的Indeedout时间不为null时
    UPDATE Room
    SET Rstate = '空闲'
    WHERE Rid IN (
        SELECT Rid
        FROM inserted
        WHERE Indeedout IS NOT NULL
    );
END;
GO
