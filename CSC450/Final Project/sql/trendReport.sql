with temp as
(select customer_id, case 
      when customer.income between 0 and 50000 then '0-50,000'
      when customer.income between 50001 and 100000 then '50,001-100,000'
      when customer.income > 100001 then '100,001 and UP'
      end as income_range
  from customer)
SELECT
    EXTRACT(year FROM Sales.DATE_SOLD) as yearSold,
    brand.NAME,
    customer.gender,
    temp.income_range,
    SUM(sales.SALE_PRICE) as total_sales
FROM
    sales JOIN
    customer ON sales.customer_id = customer.customer_id JOIN
    temp ON sales.customer_id = temp.customer_id JOIN
    vehicle ON sales.VIN = vehicle.VIN JOIN
    model ON vehicle.MODEL_ID = model.MODEL_ID JOIN
    brand ON model.BRAND_ID = brand.BRAND_ID
WHERE
    sales.date_sold > add_months(trunc(sysdate), -12*3)
GROUP BY EXTRACT(year FROM Sales.DATE_SOLD), customer.gender, brand.NAME, temp.income_range
ORDER BY EXTRACT(year FROM Sales.DATE_SOLD), brand.NAME, customer.GENDER