CREATE TRIGGER trg_update_room_state_on_customer_indeedout
ON Customer
AFTER UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    -- ����Room���RstateΪ�����С�����Customer���Indeedoutʱ�䲻Ϊnullʱ
    UPDATE Room
    SET Rstate = '����'
    WHERE Rid IN (
        SELECT Rid
        FROM inserted
        WHERE Indeedout IS NOT NULL
    );
END;
GO
