USE biblioteka;

Select 
Book.Title AS Title,
Category.Category_Name AS Category
FROM
Book
JOIN 
Category ON Category.Category_ID = Book.Category_ID 
ORDER BY
 Category ASC, Title ASC;
