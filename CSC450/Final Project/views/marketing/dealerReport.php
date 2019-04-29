<div class="container">
    <a class="btn btn-primary" href="login.php" style="margin-top:20px">Back to Menu</a>
    <div class="text-center" style="padding:50px;">
        <h2 style="margin-bottom:15px;">Top Dealer Report</h2>
        <div class="row">     
            <div class="col">
                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Reports
                    </a>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="marketing.php?action=trend&item=report">Trends Report</a>
                        <a class="dropdown-item active" href="marketing.php?action=dealer&item=report">Top Dealer Report</a>
                        <a class="dropdown-item" href="marketing.php?action=brandUnit&item=report">Top Brand Unit Sales Report</a>
                        <a class="dropdown-item" href="marketing.php?action=brandDollar&item=report">Top Brand Dollar Sales Report</a>
                        <a class="dropdown-item" href="marketing.php?action=convertible&item=report">Convertible Sales Report</a>
                        <a class="dropdown-item" href="marketing.php?action=inventory&item=report">Inventory Report</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top:15px;">     
            <div class="col">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Total Amount Sold</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach($rows as $row) : ?>
                            <tr>
                                <td><?php echo $row['NAME']; ?></td>
                                <td>$<?php echo $row['TOTAL_AMOUNT_SOLD']; ?></td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div> 