SELECT
    DEALER.dealer_id,
    DEALER.name,
    ROUND(AVG(inventoryTime.TimeInLot),2) Average_Lot_Time
FROM
    DEALER 
JOIN
    (SELECT 
        INVENTORY.dealer_id,
        SYSDATE - INVENTORY.purchase_date TimeInLot
    FROM
        INVENTORY LEFT OUTER JOIN 
        SALES ON SALES.vin = INVENTORY.vin
    ) inventoryTime on DEALER.dealer_id = inventoryTime.dealer_id
GROUP BY DEALER.dealer_id, DEALER.name
FETCH NEXT 1 ROWS ONLY