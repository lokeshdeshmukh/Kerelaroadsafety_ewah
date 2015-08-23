<html>
<head>
<script>
function getdistancedata() {

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp16=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp16=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp16.onreadystatechange=function()
  {
  if (xmlhttp16.readyState==4 && xmlhttp16.status==200)
    {


document.getElementById('distancedata').innerHTML=xmlhttp16.responseText;
		

    }
  }
xmlhttp16.open("POST","getdistancedata.php",true);
 xmlhttp16.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp16.send();

setTimeout(getdistancedata, 1000);
}
setTimeout(getdistancedata, 1000);
</script>
</head>
<body>

<div id="distancedata">

</div>
</body>
</html>