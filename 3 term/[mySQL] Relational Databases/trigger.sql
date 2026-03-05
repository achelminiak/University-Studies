DELIMITER $$

USE biblioteka;

CREATE TRIGGER deactivate_card_on_slowacki
AFTER INSERT ON bb
FOR EACH ROW
BEGIN
    DECLARE author_id INT;
    
    -- Pobranie ID autora książki, którą klient wypożyczył
    SELECT Autor_ID INTO author_id 
    FROM Book 
    WHERE Book_ID = NEW.Book_ID;

    -- Jeśli książka należy do autora Słowackiego (Autor_ID = 10), dezaktywuj kartę
    IF author_id = 10 THEN
        UPDATE customer
        SET card_status = 0
        WHERE Customer_ID = (
            SELECT Customer_ID 
            FROM Wizyta 
            WHERE Visit_ID = (
                SELECT Visit_ID 
                FROM Borrow 
                WHERE Borrow_ID = NEW.Borrow_ID
            )
        );
    END IF;
END $$

DELIMITER ;
