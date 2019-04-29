SELECT 
    dealer.name dealerName,
    dealer.dealer_id,
    model.name modelName,
    tag_price,
    inventory_id,
    inventory.VIN VIN
FROM inventory 
    JOIN dealer ON inventory.dealer_id = dealer.dealer_id
    JOIN vehicle ON inventory.VIN = vehicle.VIN
    JOIN model ON vehicle.model_id = model.model_id
WHERE inventory.dealer_id = :dealer_id