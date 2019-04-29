<div class="container">
    <a class="btn btn-primary" href="login.php" style="margin-top:20px">Back to Menu</a>
    <div style="padding:50px;">
        <h2 style="margin-bottom:15px;" class="text-center">Add New Vehicle</h2>
        <div class="row">     
            <div class="col">
                <form method="post">
                    <div class="form-group">
                        <label for="vin">VIN</label>
                        <input type="text" class="form-control" id="vin"  placeholder="Enter VIN" name="vin" required>
                    </div>
                    <div class="form-group">
                        <label for="color">Color</label>
                        <input type="text" class="form-control" id="color"  placeholder="Enter Color" name="color" required>
                    </div>
                    <div class="form-group">
                        <label for="engine">Engine</label>
                        <input type="text" class="form-control" id="engine"  placeholder="Enter Engine" name="engine" required>
                    </div>
                    <div class="form-group">
                        <label for="transmission">Transmission</label>
                        <input type="text" class="form-control" id="transmission"  placeholder="Enter Transmission" name="transmission" required>
                    </div>
                    <div class="form-group">
                        <label for="tag_price">Tag Price</label>
                        <input type="text" class="form-control" id="tag_price"  placeholder="Enter Tag Price" name="tag_price" required>
                    </div>
                    <div class="form-group">
                        <label for="productionDate">Production Date</label>
                        <input type="date" class="form-control" id="productionDate" name="productionDate" max="<?php echo date('Y-m-d'); ?>" required>
                    </div>
                    <div class="form-group">
                        <label for="purchase_date">Purchase Date</label>
                        <input type="date" class="form-control" id="purchase_date" name="purchase_date" min="<?php echo date('Y-m-d'); ?>" required>
                    </div>
                    <div class="form-group">
                        <label for="model">Model</label>
                        <select id="model" class="form-control" name="model" required>
                            <option selected disabled>Choose...</option>
                            <?php foreach($models as $model) :?>
                                <option value="<?php echo $model['MODEL_ID'] ?>"><?php echo $model['NAME'] ?></option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="dealer">Dealer</label>
                        <select id="dealer" class="form-control" name="dealer" required>
                            <option selected disabled>Choose...</option>
                            <?php foreach($dealers as $dealer) :?>
                                <option value="<?php echo $dealer['DEALER_ID'] ?>"><?php echo $dealer['NAME'] ?></option>
                            <?php endforeach; ?>
                        </select>
                    </div>
                    <button type="submit" name="submit" class="btn btn-success">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div> 