CREATE TRIGGER After_Customer_Insert
ON Customer
AFTER INSERT
AS
BEGIN
    -- ���·���״̬Ϊ��Ԥ��
    UPDATE Room
    SET Rstate = '��Ԥ��'
    WHERE Rid IN (SELECT inserted.Rid FROM inserted);
END;
GO