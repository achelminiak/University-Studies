USE biblioteka;

SELECT
    Book.Title AS Title,
    CONCAT(
        ROUND((COUNT(BB.Borrow_ID) / (SELECT COUNT(*) FROM BB) * 100), 0), 
        '% of all books borrowed'
    ) AS Percentage_of_Borrows
FROM 
    Book
LEFT JOIN 
    BB ON Book.Book_ID = BB.Book_ID
GROUP BY 
    Book.Book_ID, Book.Title
ORDER BY 
    COUNT(BB.Borrow_ID) DESC;