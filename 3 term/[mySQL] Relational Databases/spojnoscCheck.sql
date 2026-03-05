USE biblioteka;

SELECT borrow.*
FROM borrow
LEFT JOIN bb 
ON borrow.Borrow_ID = bb.Borrow_ID
WHERE bb.Borrow_ID IS NULL;
