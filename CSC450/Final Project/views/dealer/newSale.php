<div class="container">
    <a class="btn btn-primary" href="dealer.php" style="margin-top:20px">Back to Dealer Select</a>
    <div style="padding:50px;">
        <h2 style="margin-bottom:15px;" class="text-center">Add New Sale</h2>
        <div class="row">     
            <div class="col">
                <form method="post">
                    <div class="form-group">
                        <label for="sale_price">Sale Price</label>
                        <input type="text" class="form-control" id="sale_price"  placeholder="Enter Sale Price" name="sale_price" required>
                    </div>
                    <div class="form-group">
                        <label for="date_sold">Date Sold</label>
                        <input type="date" class="form-control" id="date_sold" name="date_sold" required>
                    </div>
                    <div class="form-group">
                        <label for="inventory">Inventory</label>
                        <select id="inventory" class="form-control" name="inventory" required>
                            <option selected disabled>Choose...</option>
                            <?php foreach($inventory as $car) :?>
                                <option value="<?php echo $car['VIN'] ?>"><?php echo $car['VIN'] ?></option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="customer">Customer</label>
                        <select id="customer" class="form-control" name="customer" required>
                            <option selected disabled>Choose...</option>
                            <?php foreach($customers as $customer) :?>
                                <option value="<?php echo $customer['CUSTOMER_ID'] ?>"><?php echo $customer['CUSTOMERNAME'] ?></option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                    <input type="hidden" name="dealer_id" value="<?php echo $_GET['dealer_id']?>">
                    <button type="submit" name="submit" class="btn btn-success">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div> 