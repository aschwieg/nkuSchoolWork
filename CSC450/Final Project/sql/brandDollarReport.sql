SELECT Brand.Name, SUM(Sales.SALE_PRICE) total_amount_sold
FROM Brand inner join Model on Model.BRAND_ID = Brand.BRAND_ID
      inner join Vehicle on Model.MODEL_ID = Vehicle.MODEL_ID
      inner join Sales on Vehicle.VIN = Sales.VIN
WHERE Date_Sold BETWEEN '03-APR-18' AND '03-APR-19'
GROUP BY Brand.NAME
ORDER BY SUM(Sales.Sale_Price) DESC
FETCH NEXT 1 ROWS ONLY