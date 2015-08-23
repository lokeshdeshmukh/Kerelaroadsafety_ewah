<?php 

include('connectioncode.php');

$sql="select * from carcount where id='".$_GET["id"]."'";
$result=mysql_query($sql,$con) or die(mysql_error());

//$data="[";
$data="";
$i=0;
$seen=0;
while($con1=mysql_fetch_array($result))
{
$seen=$con1["seen"];

if($con1["seen"]>0)
$data.=$con1["level"].",".$con1["lon"].",".$con1["lat"].",".$con1["id"].",".$con1["time"].","; 
/*
if($i==0)
{
$i++;

$data.='{
        "level": "'.$con1["temp"].'",
        "lon":   "'.$con1["lon"].'",
        "lat":   "'.$con1["lat"].'",
        "id":    "'.$con1["id"].'",
        "time":  "'.$con1["time"].'" 
    }';
}
else
{
$data.=',{
        "level": "'.$con1["temp"].'",
        "lon":   "'.$con1["lon"].'",
        "lat":   "'.$con1["lat"].'",
        "id":    "'.$con1["id"].'",
        "time":  "'.$con1["time"].'" 
    }';

}
  */
 
}
//$data.=']';
if($seen>0)
$sql1="update ultrasound set seen=".($seen-1)." where id='".$_GET["id"]."'";
$result1=mysql_query($sql1,$con);

echo $data;
?>