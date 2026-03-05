USE biblioteka;

SELECT 
    Worker.Worker_ID,
    Worker.Name AS Worker_Name,
    Worker.Surname AS Worker_Surname,
    Worker.Designation AS Worker_Designation,
    COUNT(Visit.Visit_ID) AS Visits_Handled
FROM 
    Worker
LEFT JOIN
    Visit ON Worker.Worker_ID = Visit.Worker_ID
GROUP BY
    Worker.Worker_ID, Worker.Name, Worker.Surname, Worker.Designation
HAVING
    COUNT(Visit.Visit_ID) > 0
ORDER BY
    Visits_Handled DESC, Worker_Designation ASC;