SELECT EXTRACT(month from Sales.DATE_SOLD) as Month, count(*) mostSold
FROM Model inner join Vehicle on model.MODEL_ID = Vehicle.MODEL_ID
    inner join Sales on Vehicle.VIN = Sales.VIN
WHERE (BODY_STYLE = 'convertible')
GROUP BY EXTRACT(month FROM Sales.DATE_SOLD)
ORDER BY mostSold DESC
FETCH NEXT 1 ROWS ONLY