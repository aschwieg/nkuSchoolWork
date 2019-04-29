<?php
include( 'config.php' );

$template = new Template(TEMPLATE_ROOT . 'index.php');

$template->set('page_title', 'Production Page');

ob_start();

if ( isset($_GET['action']) && isset($_GET['item']) ) {
    $action = get('action');
    $item = get('item');

    // DYNAMIC VIEW INCLUSION //
    switch($item) {
        case 'vehicle':
            if ($action == 'new') {
                if ($_SERVER['REQUEST_METHOD'] == 'POST') {
                    $sql = file_get_contents('sql/newVehicle.sql');              
                    $statement = $database->prepare($sql);   
                    $params = array(
                        'vin' => $_POST['vin'],
                        'color' => $_POST['color'],
                        'engine' => $_POST['engine'],
                        'transmission' => $_POST['transmission'],
                        'productionDate' => date('d-M-y', strtotime($_POST['productionDate'])),
                        'model' => $_POST['model']
                    );
                    $statement->execute($params);

                    $sql = file_get_contents('sql/newInventory.sql');              
                    $statement = $database->prepare($sql);   
                    $params = array(
                        'vin' => $_POST['vin'],
                        'tag_price' => $_POST['tag_price'],
                        'purchase_date' => date('d-M-y', strtotime($_POST['purchase_date'])),
                        'dealer_id' => $_POST['dealer']
                    );
                    $statement->execute($params);

                    header("location: production.php");
                    die();
                }

                $sql = file_get_contents('sql/getDealers.sql');              
                $statement = $database->prepare($sql);   
                $params = array();
                $statement->execute($params);
                $dealers = $statement->fetchAll(PDO::FETCH_ASSOC);

                $sql = file_get_contents('sql/getModels.sql');              
                $statement = $database->prepare($sql);   
                $params = array();
                $statement->execute($params);
                $models = $statement->fetchAll(PDO::FETCH_ASSOC);                
            }
            break;        
    }  
    $myItem = ucfirst($item);
    include("views/production/{$action}{$item}.php"); 
}  
else {
    include('views/production/panel.php');
}

$content = ob_get_clean();
$template->set('content', $content);

echo $template->fetch();

?>