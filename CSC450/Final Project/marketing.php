<?php
include( 'config.php' );

$template = new Template(TEMPLATE_ROOT . 'index.php');

$template->set('page_title', 'Marketing Page');

ob_start();

if ( isset($_GET['action']) && isset($_GET['item']) ) {
    $action = get('action');
    $item = get('item');

    // DYNAMIC VIEW INCLUSION //
    switch($item) {
        case 'report':
            if ($action == 'trend') {
                $sql = file_get_contents('sql/trendReport.sql');              
                $statement = $database->prepare($sql);   
                $params = array();
                $statement->execute($params);
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            if ($action == 'brandDollar') {
                $sql = file_get_contents('sql/brandDollarReport.sql');
                $statement = $database->prepare($sql);
                $params = array();
                $statement->execute($params);
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            if ($action == 'dealer') {
                $sql = file_get_contents('sql/dealerReport.sql');
                $statement = $database->prepare($sql);
                $statement->execute();
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            if ($action == 'brandUnit') {
                $sql = file_get_contents('sql/brandUnitReport.sql');
                $statement = $database->prepare($sql);
                $statement->execute();
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            if ($action == 'convertible') {
                $sql = file_get_contents('sql/convertibleReport.sql');
                $statement = $database->prepare($sql);
                $statement->execute();
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            if ($action == 'inventory') {
                $sql = file_get_contents('sql/inventoryReport.sql');
                $statement = $database->prepare($sql);
                $statement->execute();
                $rows = $statement->fetchAll(PDO::FETCH_ASSOC);
            }
            break;        
    }  
    $myItem = ucfirst($item);
    include("views/marketing/{$action}{$item}.php"); 
}  
else {
    include('views/marketing/panel.php');
}

$content = ob_get_clean();
$template->set('content', $content);

echo $template->fetch();

?>