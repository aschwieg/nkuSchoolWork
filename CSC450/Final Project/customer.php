<?php
include( 'config.php' );

$template = new Template(TEMPLATE_ROOT . 'index.php');

$template->set('page_title', 'Customer Page');

ob_start();

if ( isset($_GET['action']) && isset($_GET['item']) ) {
    $action = get('action');
    $item = get('item');

    // DYNAMIC VIEW INCLUSION //
    switch($item) {
        case 'cars':
            if ($action == 'list') {
                $sql = file_get_contents('sql/getDealerInventory.sql');              
                $statement = $database->prepare($sql);   
                $params = array(
                    'dealer_id' => $_GET['dealer_id']
                );
                $statement->execute($params);
                $cars = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            break;
        case 'product':
            if ($action == 'view') {
                $sql = file_get_contents('sql/getProductInformation.sql');              
                $statement = $database->prepare($sql);   
                $params = array(
                    'inventory_id' => $_GET['inventory_id']
                );
                $statement->execute($params);
                $cars = $statement->fetchAll(PDO::FETCH_ASSOC);
                $car = $cars[0];
            }
            break;
    }  
    $myItem = ucfirst($item);
    include("views/customer/{$action}{$item}.php"); 
}  
else {
    $sql = file_get_contents('sql/getDealers.sql');              
    $statement = $database->prepare($sql);   
    $params = array();
    $statement->execute($params);
    $dealers = $statement->fetchAll(PDO::FETCH_ASSOC);

    include('views/customer/panel.php');
}

$content = ob_get_clean();
$template->set('content', $content);

echo $template->fetch();

?>