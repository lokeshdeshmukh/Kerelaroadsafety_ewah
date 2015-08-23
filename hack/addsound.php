<?php 
date_default_timezone_set('Asia/Kolkata');
include('connectioncode.php');

$sql="insert into sound values(null,'".$_GET['level']."','".$_GET["lon"]."','".$_GET["lat"]."','".$_GET["id"]."',now(),5)";
$result=mysql_query($sql,$con) or die(mysql_error());

?>