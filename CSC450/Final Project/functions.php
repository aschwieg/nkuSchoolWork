<?php 

function clean($string) {
    return strip_tags($string);
}

function get ($key) {
    if (isset($_GET[$key])) {
        return clean($_GET[$key]);
    }
    
    else {
        return '';
    }
}

function post ($key) {
    if (isset($_POST[$key])) {
        return clean($_POST[$key]);
    }
    
    else {
        return '';
    }
}

function data($var) {
    if(strpos($var, '->') !== true) {
        $strings = explode('->', $var);
        $string = $strings[0];
        $property = $strings[1];
    }
    
    global ${$var};
    $string = ${$var};
    
    return $string->name;
    if(!empty($string))
        return $string;
    else 
        return '';
}

function get_sql($sqlName) {
    return file_get_contents(ROOT . "sql/$sqlName.sql");
}

function snippet($string, $characters) {
    if(strlen($string) <= $characters) {
        return $string;
    }
    
    $string = substr($string, 0, $characters);
    $string .= '...';
    return $string;
}

function checkUserPermissions() {
    if(!isset($_SESSION['user']) && !($_SERVER['REQUEST_URI'] == '/HTBCwebsite/home.php')) {
        header("Location: home.php");
        die();
    }
}

function file_upload($file, $target_directory, $filename, $type) {
    $target_dir = $target_directory;
    $target_file = $target_dir . $filename;
    $uploadOk = 1;
    $fileType = pathinfo($target_file,PATHINFO_EXTENSION);
    echo "file type: " . $fileType;
    
    // Check if file already exists
    if (file_exists($target_file)) {
        echo "Sorry, file already exists.";
        $uploadOk = 0;
    }
    
    // Check file size
    if ($file["size"] > 5000000) {
        echo "Sorry, your file is too large.";
        $uploadOk = 0;
    }
    
    switch($type) {
        case 'image':
            $allowedExtensions = array('jpg', 'jpeg', 'png', 'gif');
            $error = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
            break; 
        default:
            $allowedExtensions = array('jpg', 'jpeg', 'png', 'gif');
            $error = "Sorry, type not supported";
    }
    
    // Allow certain file formats
    if(!in_array($fileType, $allowedExtensions)) {
        echo $error;
        $uploadOk = 0;
    }
    
    // Check if $uploadOk is set to 0 by an error
    if ($uploadOk == 0) {
        echo "Sorry, your file was not uploaded.";
    // if everything is ok, try to upload file
    } else {
        if (move_uploaded_file($file["tmp_name"], $target_file)) {
            echo "The file ". basename( $file["name"]). " has been uploaded.";
        } else {
            echo "Sorry, there was an error uploading your file.";
        }
    }
    
    return $uploadOk;
}