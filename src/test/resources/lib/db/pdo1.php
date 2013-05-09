<?php
$dbms='mysql';
$host='localhost:3306';
$dbname='test';
$user='tae';
$pass='tae';
$dsn="$dbms:host=$host;dbname=$dbname";
try{
    $dbh = new PDO($dsn, $user, $pass);
    foreach ($dbh->query('SELECT * from test') as $row) {
        print_r($row);
    }
    $dbh = null;
}catch(PDOException $e){
    die("Error!:".$e->getMessage()."<br/>");
}

?>