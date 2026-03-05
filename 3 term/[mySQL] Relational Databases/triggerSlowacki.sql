USE biblioteka;
SELECT 
    c.Customer_ID, 
    c.Name, 
    c.Surname, 
    c.Card_status
	
FROM Customer c
JOIN Visit v ON c.Customer_ID = v.Customer_ID
JOIN VB ON v.Visit_ID = VB.Visit_ID
JOIN BB ON VB.Borrow_ID = BB.Borrow_ID
JOIN Book b ON BB.Book_ID = b.Book_ID

WHERE b.Author_ID = 10;