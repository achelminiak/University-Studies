USE biblioteka;
SELECT 
    CONCAT(
        ROUND(AVG(DATEDIFF(Borrow.Return_date, Visit.Visit_date)), 0), 
        ' days'
    ) AS average_borrow_duration
FROM 
    Borrow
JOIN 
    VB ON Borrow.Borrow_ID = VB.Borrow_ID
JOIN 
    Visit ON VB.Visit_ID = Visit.Visit_ID
WHERE 
    Borrow.Return_date IS NOT NULL
    AND Visit.Visit_date IS NOT NULL
    AND Borrow.Return_date > Visit.Visit_date;