USE biblioteka;

SELECT
Book.Title AS Title,
CASE
WHEN Book.Available= 1 THEN 'yes'
WHEN Book.Available= 0 Then 'No'
END AS Is_Available
FROM 
Book
ORDER BY 
Title ASC;