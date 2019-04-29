SELECT Dealer.Name, Sum(Sales.SALE_PRICE) total_amount_sold
FROM Sales inner join Dealer on Sales.DEALER_ID = Dealer.DEALER_ID
WHERE Date_Sold BETWEEN '03-APR-18' AND '03-APR-19'
GROUP BY Dealer.Name
ORDER BY Sum(Sales.SALE_PRICE) DESC
FETCH NEXT 1 ROWS ONLY