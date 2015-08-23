<?php 

include("connectioncode.php");

$sql="select count(*) from ultrasound where level=1 and lon like '%".substr($_GET["lon"],0,4)."%' and lat like '%".substr($_GET["lat"],0,4)."%'";
$result=mysql_query($sql,$con) or die(mysql_error());



$data.=mysql_result($result,0,0).",";

$sql="select count(*) from tempreature where temp>50 and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";


$sql="select count(*) from accelerometer where level=1 and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from pedcount where level='high' and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from carcount where level='high' and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from alcohol where level=1 and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from trafficsign where level='Stop' and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from trafficsign where level='Bump' and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

$sql="select count(*) from trafficsign where level='Not Recognized' and lon like '%".$_GET["lon"]."%' and lat like '%".$_GET["lat"]."%'";
$result=mysql_query($sql,$con);

$data.=mysql_result($result,0,0).",";

echo $data;

?>