<div class="container">
    <a class="btn btn-primary" href="login.php" style="margin-top:20px">Back to Menu</a>
    <div class="text-center" style="padding:50px;">
        <h2 style="margin-bottom:15px;">Add New Sale</h2>
        <h4>Select Dealer</h4>
        <?php foreach($dealers as $dealer) : ?>
            <div class="row" style="margin-top:15px;">     
                <div class="col">
                    <a href="dealer.php?action=new&item=sale&dealer_id=<?php echo $dealer['DEALER_ID']?>" class="btn btn-info btn-lg" style="min-width:150px;"><?php echo ucfirst($dealer['NAME']);?></a>
                </div>
            </div>
        <?php endforeach; ?>    
    </div>
</div> 