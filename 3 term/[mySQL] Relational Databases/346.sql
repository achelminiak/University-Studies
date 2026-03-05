USE biblioteka;

SELECT
Visit.Visit_ID,
Visit.Visit_date,
Borrow.Borrow_ID,
Borrow.Return_date
FROM
VB
JOIN Visit ON Visit.Visit_ID= VB.Visit_ID
JOIN Borrow on Borrow.Borrow_ID = VB.Borrow_ID;