<div class="container">
    <a class="btn btn-primary" href="customer.php" style="margin-top:20px">Back to Dealers</a>
    <div class="text-center" style="padding:50px;">
        <h2 style="margin-bottom:15px;"><?php echo ucfirst($cars[0]['DEALERNAME']); ?>'s Inventory</h2>
        <div class="row" style="margin-top:15px;">     
            <div class="col">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Model Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach($cars as $car) : ?>
                            <tr>
                                <td><?php echo ucfirst($car['MODELNAME']); ?></td>
                                <td>$<?php echo $car['TAG_PRICE']; ?></td>
                                <td><a href="customer.php?action=view&item=product&dealer_id=<?php echo $car['DEALER_ID']; ?>&inventory_id=<?php echo $car['INVENTORY_ID']; ?>" class="btn btn-primary">View Product</a></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div> 