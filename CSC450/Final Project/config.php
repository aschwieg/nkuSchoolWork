<?php

// Report all errors
error_reporting(E_ALL);

// Document Root
define('ROOT',  ""); 

// Document Root
define('BASE', '');

// Template
define('TEMPLATE_NAME', 'basic');
define('ADMIN_TEMPLATE_NAME', 'basic');
define('TEMPLATE_BASE', BASE . 'templates/' . TEMPLATE_NAME . '/');
define('TEMPLATE_ROOT', ROOT . 'templates/' . TEMPLATE_NAME . '/');

function my_autoloader($class) {
    include(ROOT . 'classes/class.' . $class . '.php');
}

spl_autoload_register('my_autoloader');

require( ROOT . 'functions.php');

//Need to make own PDO connection
//oracle connections 

$params = array(
    'host' => '',
    'port' => '',
    'servicename' => '',
    'user' => '',
    'password' => ''
);

$database = new PDO("oci:dbname=(DESCRIPTION = (ADDRESS_LIST = (
    ADDRESS = (PROTOCOL = TCP)
    (HOST = {$params['host']} )
    (PORT = {$params['port']} )
   ))
 (CONNECT_DATA = (SID = {$params['servicename']})
 )); charset=AL32UTF8",
$params['user'],
$params['password']
);
$database->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

session_start();