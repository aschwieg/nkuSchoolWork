<?php
include( 'config.php' );

$template = new Template(TEMPLATE_ROOT . 'index.php');

$template->set('page_title', 'Dealer Page');

ob_start();

if ( isset($_GET['action']) && isset($_GET['item']) ) {
    $action = get('action');
    $item = get('item');

    // DYNAMIC VIEW INCLUSION //
    switch($item) {
        case 'sale':
            if ($action == 'new') {
                if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                    $sql = file_get_contents('sql/removeInventory.sql');              
                    $statement = $database->prepare($sql);   
                    $params = array(
                        'vin' => $_POST['inventory']
                    );
                    $statement->execute($params);

                    $sql = file_get_contents('sql/newSale.sql');              
                    $statement = $database->prepare($sql);   
                    $params = array(
                        'vin' => $_POST['inventory'],
                        'sale_price' => $_POST['sale_price'],
                        'date_sold' => date('d-M-y', strtotime($_POST['date_sold'])),
                        'dealer_id' => $_POST['dealer_id'],
                        'customer_id' => $_POST['customer']
                    );
                    $statement->execute($params);

                    header("location: dealer.php");
                    die();
                }

                $sql = file_get_contents('sql/getCustomers.sql');              
                $statement = $database->prepare($sql);   
                $params = array();
                $statement->execute($params);
                $customers = $statement->fetchAll(PDO::FETCH_ASSOC);  

                $sql = file_get_contents('sql/getDealerInventory.sql');              
                $statement = $database->prepare($sql);   
                $params = array(
                    'dealer_id' => $_GET['dealer_id']
                );
                $statement->execute($params);
                $inventory = $statement->fetchAll(PDO::FETCH_ASSOC);  
            }
            break;
        
    }  
    $myItem = ucfirst($item);
    include("views/dealer/{$action}{$item}.php"); 
}  
else {
    $sql = file_get_contents('sql/getDealers.sql');              
    $statement = $database->prepare($sql);   
    $params = array();
    $statement->execute($params);
    $dealers = $statement->fetchAll(PDO::FETCH_ASSOC);

    include('views/dealer/panel.php');
}

$content = ob_get_clean();
$template->set('content', $content);

echo $template->fetch();

?>