<?php

include( 'config.php' );

$template = new Template(TEMPLATE_ROOT . 'index.php');

$template->set('page_title', 'Home Page');

ob_start();

?>
<div class="container">
    <div class="text-center" style="padding:200px;padding-bottom:500px;">
        <h2 style="margin-bottom:15px;">What type of user are you?</h2>
        <div class="row" style="margin-bottom:15px;">
            <div class="col">
                <a href="production.php" class="btn btn-lg btn-primary" style="min-width:150px;">Production</a>
            </div>
            <div class="col">
                <a href="dealer.php" class="btn btn-lg btn-primary" style="min-width:150px;">Dealer</a>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <a href="marketing.php" class="btn btn-lg btn-primary" style="min-width:150px;">Marketing</a>
            </div>
            <div class="col">
                <a href="customer.php" class="btn btn-lg btn-primary" style="min-width:150px;">Customer</a>
            </div>
        </div>
    </div>
</div> 
<?php 
$content = ob_get_clean();
$template->set('content', $content);

echo $template->fetch();
?>