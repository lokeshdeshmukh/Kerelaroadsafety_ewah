<?php 

include("connectioncode.php");

$sql="select * from accelerometer order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con) or die(mysql_error());

while($conn=mysql_fetch_array($result))
{

$sql1="update accelerometer set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);
echo $sql1;

}

$sql="select * from alcohol order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con);

while($conn=mysql_fetch_array($result))
{

$sql1="update alcohol set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);


}


$sql="select * from carcount order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con);

while($conn=mysql_fetch_array($result))
{

$sql1="update carcount set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);


}


$sql="select * from tempreature order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con);

while($conn=mysql_fetch_array($result))
{

$sql1="update tempreature set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);


}


$sql="select * from trafficsign order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con);

while($conn=mysql_fetch_array($result))
{

$sql1="update trafficsign set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);


}

$sql="select * from ultrasound order by sno desc limit 0,2 ";
$result=mysql_query($sql,$con);

while($conn=mysql_fetch_array($result))
{

$sql1="update ultrasound set lon='".$_GET["lon"]."' , lat='".$_GET["lat"]."' where sno='".$conn["sno"]."'";
$result1=mysql_query($sql1,$con);


}





?>