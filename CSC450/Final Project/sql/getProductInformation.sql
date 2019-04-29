SELECT 
    tag_price,
    color,
    engine,
    transmission,
    production_date,
    body_style,
    model.name MODELNAME,
    brand.name BRANDNAME,
    LOGO
FROM INVENTORY
    JOIN VEHICLE ON vehicle.vin = inventory.vin
    JOIN MODEL ON model.model_id = vehicle.model_id
    JOIN BRAND ON brand.brand_id = model.brand_id
WHERE inventory_id = :inventory_id