<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html>
<head>
<title>transfer</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<script language="JavaScript" type="text/javascript">
function check(rank)
{


if(rank=="ig")
{
document.getElementById("ig1").innerHTML="<center><h1>First Officer</h1>Enter Cop-Id :<input type='text' name='copid1'/><br>Enter a Zone :<input type='text' name='zone1'/></center>";
document.getElementById("ig2").innerHTML="<center><h1>Second Officer</h1>Enter Cop-Id :<input type='text' name='copid2'/><br>Enter a Zone :<input type='text' name='zone2'/><br><input type='submit' value='transfer'/></center>";
document.getElementById("dig1").innerHTML="";
document.getElementById("dig2").innerHTML="";
document.getElementById("sp1").innerHTML="";
document.getElementById("sp2").innerHTML="";
document.getElementById("co1").innerHTML="";
document.getElementById("co2").innerHTML="";
}
if(rank=="dig")
{

document.getElementById("dig1").innerHTML="<center><h1>First Officer</h1>Enter Cop-Id :<input type='text' name='copid1'/><br>Enter a Zone :<input type='text' name='zone1'/><br>Enter a Range :<input type='text' name='range1'/></center>";
document.getElementById("dig2").innerHTML="<center><h1>Second Officer</h1>Enter Cop-Id :<input type='text' name='copid2'/><br>Enter a Zone :<input type='text' name='zone2'/><br>Enter a Range :<input type='text' name='range2'/><br><input type='submit' value='transfer'/></center>";
document.getElementById("ig1").innerHTML="";
document.getElementById("ig2").innerHTML="";
document.getElementById("sp1").innerHTML="";
document.getElementById("sp2").innerHTML="";
document.getElementById("co1").innerHTML="";
document.getElementById("co2").innerHTML="";
}
if(rank=="sp"||rank=="asp")
{
document.getElementById("sp1").innerHTML="<center><h1>First Officer</h1>Enter Cop-Id :<input type='text' name='copid1'/><br>Enter a Zone :<input type='text' name='zone1'/><br>Enter a Range :<input type='text' name='range1'/><br>Enter a District :<input type='text' name='district1'/></center>";
document.getElementById("sp2").innerHTML="<center><h1>Second Officer</h1>Enter Cop-Id :<input type='text' name='copid2'/><br>Enter a Zone :<input type='text' name='zone2'/><br>Enter a Range :<input type='text' name='range2'/><br>Enter a District :<input type='text' name='district2'/><br><input type='submit' value='transfer'/></center>";
document.getElementById("dig1").innerHTML="";
document.getElementById("dig2").innerHTML="";
document.getElementById("ig1").innerHTML="";
document.getElementById("ig2").innerHTML="";
document.getElementById("co1").innerHTML="";
document.getElementById("co2").innerHTML="";
}
if(rank=="co")
{
document.getElementById("co1").innerHTML="<center><h1>First Officer</h1>Enter Cop-Id :<input type='text' name='copid1'/><br>Enter a Zone :<input type='text' name='zone1'/><br>Enter a Range :<input type='text' name='range1'/><br>Enter a District :<input type='text' name='district1'/><br>Enter a Circle :<input type='text' name='circle1'/></center>";
document.getElementById("co2").innerHTML="<center><h1>Second Officer</h1>Enter Cop-Id :<input type='text' name='copid2'/><br>Enter a Zone :<input type='text' name='zone2'/><br>Enter a Range :<input type='text' name='range2'/><br>Enter a District :<input type='text' name='district2'/><br>Enter a Circle :<input type='text' name='circle1'/><br><input type='submit' value='transfer'/></center>";
document.getElementById("dig1").innerHTML="";
document.getElementById("dig2").innerHTML="";
document.getElementById("sp1").innerHTML="";
document.getElementById("sp2").innerHTML="";
document.getElementById("ig1").innerHTML="";
document.getElementById("ig2").innerHTML="";
}
}
</script>
<body>
<form id="form1">
Select a Rank: <br><br>
<input type="radio" name="rank" value="ig" onclick='check(this.value)'/>IG
<input type="radio" name="rank" value="dig" onclick='check(this.value)'/>DIG
<input type="radio" name="rank" value="sp" onclick='check(this.value)'/>SP
<input type="radio" name="rank" value="asp" onclick='check(this.value)'/>ASP
<input type="radio" name="rank" value="co" onclick='check(this.value)'/>CO<br>
<span id="ig1"></span>
<span id="ig2"></span>
<span id="dig1"></span>
<span id="dig2"></span>
<span id="sp1"></span>
<span id="sp2"></span>
<span id="co1"></span>
<span id="co2"></span>

</form>
</body>
</html>