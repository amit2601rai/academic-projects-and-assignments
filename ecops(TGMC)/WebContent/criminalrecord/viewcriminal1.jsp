<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>viewcriminal1</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function displaymessage()
{

document.getElementById("0").innerHTML="<br><br>City:<input type='text' name='city'><br>";
document.getElementById("1").innerHTML="<br><br>Police station:<input type='text' name='ps'><br>";
document.getElementById("2").innerHTML=" ";
document.getElementById("3").innerHTML=" "
document.getElementById("4").innerHTML=" ";
document.getElementById("4").innerHTML=" ";
document.getElementById("5").innerHTML="<input type='hidden' name='hid' value='p'>";
}
function displaymessage1()
{
document.getElementById("0").innerHTML="<br><br>City:<input type='text' name='city'><br>";
document.getElementById("1").innerHTML=" ";
document.getElementById("2").innerHTML=" ";
document.getElementById("3").innerHTML=" ";
document.getElementById("4").innerHTML=" ";
document.getElementById("5").innerHTML="<input type='hidden' name='hid' value='d'>";
}

function displaymessage2()
{
document.getElementById("0").innerHTML="<br><br>City:<input type='text' name='city'><br>";
document.getElementById("1").innerHTML=" ";
document.getElementById("2").innerHTML="<br><br>Circle:<input type='text' name='circle'><br>";
document.getElementById("3").innerHTML=" ";
document.getElementById("4").innerHTML=" ";
document.getElementById("5").innerHTML="<input type='hidden' name='hid' value='c'>";}
function displaymessage3()
{
document.getElementById("0").innerHTML=" ";
document.getElementById("1").innerHTML=" ";
document.getElementById("2").innerHTML=" ";
document.getElementById("3").innerHTML="<br><br>zone:<input type='text' name='range'><br>";
document.getElementById("4").innerHTML=" ";
document.getElementById("5").innerHTML="<input type='hidden' name='hid' value='r'>";
}
function displaymessage4()
{document.getElementById("0").innerHTML=" ";
document.getElementById("1").innerHTML=" ";
document.getElementById("2").innerHTML=" ";
document.getElementById("3").innerHTML=" ";
document.getElementById("4").innerHTML="<br><br>zone:<input type='text' name='zone'><br>";
document.getElementById("5").innerHTML="<input type='hidden' name='hid' value='z'>";}
</script>
</head>
<body>
<html:form action="/viewcriminalaction">
<input type="radio"  name="p" value="policestation"  onclick="displaymessage()" />at police station level<br/>
<input type="radio"  name="p" value="city"  onclick="displaymessage1()" />at city level<br/>
<input type="radio"  name="p" value="circle"  onclick="displaymessage2()" />at circle level<br/>
<input type="radio"  name="p" value="zone"  onclick="displaymessage3()" />at zone level<br/>
<input type="radio"  name="p" value="range"  onclick="displaymessage4()" />at range level<br/>
<span id="0"></span>
<span id="1"></span>
<span id="2"></span>
<span id="3"></span>
<span id="4"></span>
<span id="5"></span>
<input type="submit" name="submit" value="submit"/>
</html:form>
</body>
</html:html>