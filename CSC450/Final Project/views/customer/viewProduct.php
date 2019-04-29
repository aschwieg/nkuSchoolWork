<div class="container">
    <a class="btn btn-primary" href="customer.php?action=list&item=cars&dealer_id=<?php echo $_GET['dealer_id']; ?>" style="margin-top:20px">Back to Dealer Inventory</a>
    <div class="text-center" style="padding:50px;">
        <div class="row" style="margin-top:15px;">     
            <div class="col">
                <img src="logos/<?php echo $car['BRANDNAME'] ?>.jpg" style="width:100px;height:100px;">
                <h6><?php echo $car['BRANDNAME'] ?></h6>
            </div>
            <div class="col">
                <h2 class="text-center"><?php echo ucfirst($car['MODELNAME']); ?></h2>
            </div>
        </div>
        <hr>
        <div class="row" style="margin-top:15px;">     
            <div class="col">
                <p><strong>Price</strong></p>
                <p>$<?php echo ucfirst($car['TAG_PRICE']); ?></p>
            </div>
            <div class="col">
                <p><strong>Style Info</strong></p>
                <p>Body Style: <?php echo ucfirst($car['BODY_STYLE']); ?></p>
                <p>Color: <?php echo ucfirst($car['COLOR']); ?></p>
            </div>
            <div class="col">
                <p><strong>Other Info</strong></p>
                <p>Production Date: <?php echo $car['PRODUCTION_DATE']; ?></p>
                <p>Engine: <?php echo $car['ENGINE']; ?></p>
                <p>Transmission: <?php echo $car['TRANSMISSION']; ?></p>
            </div>
        </div>
    </div>
</div> 