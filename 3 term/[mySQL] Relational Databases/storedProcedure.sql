DELIMITER $$

CREATE PROCEDURE GetMostBorrowedBook()
BEGIN
    SELECT b.Title, COUNT(bb.Book_ID) AS BorrowCount
    FROM BB bb
    JOIN Book b ON bb.Book_ID = b.Book_ID
    GROUP BY b.Title
    ORDER BY BorrowCount DESC
    LIMIT 1;
END$$

DELIMITER ;
