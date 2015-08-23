<?php 
include("connectioncode.php");

$sql="select  * from ultrasound where id='00000000bb573a9a' order by sno desc limit 0,10";
$result=mysql_query($sql,$con);

echo '<table width="80%" style="border:solid 1px;" align="center">';
echo '<tr><td>Sno</td><td>Vehical Unique Id</td><td>Status</td><td>longitude</td><td>Latitude</td><td>Time</td></tr>';
while($conn=mysql_fetch_array($result))
{
if($conn["level"]<7)
echo '<tr><td>'.$conn["sno"].'</td><td>'.$conn["id"].'</td><td style="color:red;">collision Detected</td><td>'.$conn["lon"].'</td><td>'.$conn["lat"].'</td><td>'.$conn["time"].'</td></tr>';
else if($conn["level"]<100)
echo '<tr><td>'.$conn["sno"].'</td><td>'.$conn["id"].'</td><td>Vehical Too close</td><td>'.$conn["lon"].'</td><td>'.$conn["lat"].'</td><td>'.$conn["time"].'</td></tr>';
}


$sql="select  * from accelerometer where level=1 and id='00000000bb573a9a' order by sno desc limit 0,10";
$result=mysql_query($sql,$con);


while($conn=mysql_fetch_array($result))
{
echo '<tr><td>'.$conn["sno"].'</td><td>'.$conn["id"].'</td><td style="color:red;">Vehicle is Over Turned Contact For Help </td></tr>';

}



echo '</table>';



?>