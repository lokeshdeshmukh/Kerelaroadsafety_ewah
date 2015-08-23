<?php 

include('connectioncode.php');

$sql="select * from accelerometer where id='".$_GET["id"]."'";
$result=mysql_query($sql,$con) or die(mysql_error());

$data="[";
$i=0;

while($con1=mysql_fetch_array($result))
{


if($i==0)
{
$i++;

$data.='{
        "level": "'.$con1["level"].'",
        "lon":   "'.$con1["lon"].'",
        "lat":   "'.$con1["lat"].'",
        "id":    "'.$con1["id"].'",
        "time":  "'.$con1["time"].'" 
    }';
}
else
{
$data.=',{
        "level": "'.$con1["level"].'",
        "lon":   "'.$con1["lon"].'",
        "lat":   "'.$con1["lat"].'",
        "id":    "'.$con1["id"].'",
        "time":  "'.$con1["time"].'" 
    }';

}
   
}
$data.=']';

echo $data;
?>