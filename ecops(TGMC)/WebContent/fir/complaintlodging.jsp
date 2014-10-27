
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
	<meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="/elites/images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<link href="/elites/images/use.css" rel="stylesheet" type="text/css"/>
	
	<head>
    <title>ecops@elitecleats</title>
    <link rel="stylesheet" type="text/css" href="/elites/images/use.css" />
    
	<style type="text/css">
	.head
	{
		font-weight:bolder;
		font-family:Verdana
		color:green;
	}	
   </style>
   <script type="text/javascript">
var xmlHttp=null;

function init()
{
document.getElementById("hid1").value="0";
document.getElementById("hid2").value="00";
document.getElementById("111").disabled=true;
document.getElementById("999").disabled=true;
}
function remove()
{
document.getElementById("111").disabled=false;
document.getElementById("999").disabled=false;
}

function add()
{

var i=0;
var j=0;
i=document.getElementById("hid1").value;
j=i+1;
document.getElementById(i).innerHTML="<br><br>Enter victim's citizen Id :<input type='text' name='victimid'/><br>Victim's name :<input type='text' name='victimname'/><span id='"+j+"'></span>";
document.getElementById("hid1").value=j;
}


function add1()
{
if(document.getElementById("111").disabled==true)
{
alert("Either you haven't selected criminal info or you don't know the criminals' names!!!");
}
else{
var i=0;
var j=0;
i=document.getElementById("hid2").value;
j=i+11;
document.getElementById(i).innerHTML="<br><br>Criminal's name :<input type='text' name='criminal'/><br>Enter crminal details<textarea rows='5' cols='20' name='crdetails'></textarea><span id='"+j+"'></span>";
document.getElementById("hid2").value=j;
}
}
function date()
{
var w="<select name='dd'>";
var i;
for(i=1;i<32;i++)
{
w=w+"<option value='"+i+"'>"+i+"</option>";
}
w=w+"</select>";
document.getElementById("dd").innerHTML=w;
var x="<select name='mm'>";
var j;
for(j=1;j<13;j++)
{
x=x+"<option value='"+j+"'>"+j+"</option>";
}
x=x+"</select>";
document.getElementById("mm").innerHTML=x;
var y="<select name='yyyy'>";
for(i=1940;i<2011;i++)
{
y=y+"<option value='"+i+"'>"+i+"</option>";
}
y=y+"</select>";
document.getElementById("yyyy").innerHTML=y;

var z="<select name='hh'>";
for(i=1;i<13;i++)
{
z=z+"<option value='"+i+"'>"+i+"</option>";
}
z=z+"</select>";
document.getElementById("hh").innerHTML=z;

var g="<select name='min'>";
for(i=1;i<61;i++)
{
g=g+"<option value='"+i+"'>"+i+"</option>";
}
g=g+"</select>";
document.getElementById("min").innerHTML=g;
}

function check()
{
document.getElementById("hid1").value="0";
date();
var url;
var strg;
xmlHttp=GetXmlHttpObject();
if (xmlHttp==null)
  {
  alert ("Your browser does not support AJAX!");
  return;
  } 
url="/ecops/apploaddistrictaction.do";
url=url+"?u=gyg&st=1";
xmlHttp.onreadystatechange=stateChanged; 
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader( "Content-type", "text/xml" );
xmlHttp.send(null);
}

function checkcircle(id)
{
xmlHttp=GetXmlHttpObject();
if (xmlHttp==null)
  {
  alert ("Your browser does not support AJAX!");
  return;
  } 
url="/ecops/apploadcircleaction.do";
url=url+"?u="+id+"&st=10";
xmlHttp.onreadystatechange=stateChanged2; 
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader( "Content-type", "text/xml" );
xmlHttp.send(null);
}

function stateChanged() 
{ 
if (xmlHttp.readyState==4)
{ 
if(xmlHttp.status==200)
{

   

document.getElementById("district1").innerHTML=xmlHttp.responseText;

}
}
if (xmlHttp.readyState==2)
{
document.getElementById("district1").innerHTML="Loading.....";
}

}

function stateChanged2() 
{ 
if (xmlHttp.readyState==4)
{ 
if(xmlHttp.status==200)
{

   

document.getElementById("circle1").innerHTML=xmlHttp.responseText;

}
}
if (xmlHttp.readyState==2)
{
document.getElementById("circle1").innerHTML="Loading.....";
}

}



function GetXmlHttpObject()
{
var xmlHttp=null;
try
  {
  // Firefox, Opera 8.0+, Safari
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  {
  // Internet Explorer
  try
    {
    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }
  catch (e)
    {
    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
return xmlHttp;
}
</script>
   <link rel="shortcut icon" href="images/GOA.ico">
	</head>

	<body onload="check()" leftmargin="0" topmargin="0" background="/elites/images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
    <center><h1></h1></center>
    <table width="926" align="center" bgcolor=" #CFC996" border="0" cellpadding="0" cellspacing="0" height="257">
      <tbody><tr> 
    
  
   <td width="926" height="257">
   <p>
   
   <table width="932" border="0" bgcolor="#CFC996">
     <tr>
       <td width="172" height="209"><img src="/elites/images/national20emblem.jpg" width="153" height="175"></td>
       <td width="573" height="209"><img src="/elites/images/logofinal.jpg" height="100%" width="100%"/></td>
       <td width="165" height="209"><img src="/elites/images/indian-police-lo.jpg" width="153" height="175"></td>
     </tr>
     <tr>

					<td colspan="3" height="11"><img src="/elites/images/untitled.bmp" width="100%"><img src="/elites/images/khaki1.bmp" width="100%"><img src="/elites/images/blue.bmp" width="100%"></td>

				</tr>
   </table>
  <table width="892" border="0" height="55">
        <tbody><tr>
          <td width="60" height="51"><table width="895" border="0" height="41">
            <tbody><tr>
              <td width="127">
             <a href="/elites/index1.html"><img src="/elites/images/home2.gif" width="127" height="39"/></a></td>
              <td width="127" height="39">
             <a href="/elites/admin.jsp"><img src="/elites/images/admin1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="#"> <img src="/elites/images/detctives1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="/elites/coplogin/login.jsp"> <img src="/elites/images/hotel%2520employees1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="/elites/licenses/hotelncentres/hotelsncentresform.jsp"> <img src="/elites/images/cc%2520employee.gif" width="127" height="39"/></a></td>
              <td width="127">
              <a href="/elites/citizen/citizenlogin.jsp"><img src="/elites/images/Conact%2520us1.gif" width="127" height="39"/></a></td>
              <td width="126">
            <a href="/elites/magistrate/login.jsp"> <img src="/elites/images/faq1.gif" width="127" height="39"/></a></td>
            </tr>
          </tbody></table></td>
        </tr>
</tbody>
</table>
<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr> 
    <td valign="top" width="198" background="/elites/images/bgleft.jpg">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody><tr>
    <td><p>&#160;</p>
      <p>&#160;</p></td>
    </tr>
    <tr>
    <td valign="top">
          

          <table width="100%" border="0" cellpadding="2" cellspacing="1" height="588">
            <tbody>
            
            <tr>
                <td width="17" height="52"><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="7" href="/elites/coplogin/photoupload.jsp" class="leftlink">Change photo</a></td>
              </tr>
              <tr>
                <td width="17" height="52"><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="8" href="#" class="leftlink">View Case-Details</a></td>
              </tr>
              
        
              
              
              
              <tr>
                <td colspan="2" height="5"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="9" href="#" class="leftlink">View Criminal Record</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="10" href="#" class="leftlink">Police Ranks</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="11" href="#" class="leftlink">Responsibilities</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="12" href="#" class="leftlink">History</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="13" href="#" class="leftlink">Districts</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="14" href="#" class="leftlink">Special Units</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Right to Information</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Contact Us</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td>&#160;</td>
                <td>&#160;</td>
              </tr>
            </tbody>
          </table>            </td>
        </tr>
      </tbody></table></td>
    <td valign="top" width="729" bgcolor="#CFC996">
      <table width="729" height="630" border="0" bgcolor=" #CFC996">
        <tr>
          <td height="214"><table width="708" height="200" border="0">
            <tr>
              <td width="457" height="194">
              
              <html:form action="/complaint">
              <table width="690" border="0">
              
              
<tr height="30"><td class="head"  colspan="2" >Lodge a Complaint</center></td></tr>
<tr height="50"><td class="para1">
Select type of Crime :</td>
<td><select name="crime">
<option value="murder" >murder</option>
<option value="attempttomurder" >Attempt to murder</option>
<option value="kidnap" >Kidnapping</option>
<option value="theft" >Theft</option>
<option value="dacoity">Dacoity</option>
<option value="others">Others....</option>
</select></td></tr>
<tr height="50"><td class="para1">Enter Date(dd/mm/yyyy) :</td><td><span id="dd"><select name="dd"><option value="select">select</option></select></span> /
<span id="mm"><select name="mm"><option value="select">select</option></select></span> /
<span id="yyyy"><select name="yyyy"><option value="select">select</option></select></span></td></tr>
<tr height="50"><td class="para1">
Enter Time of crime(hh/mm) :</td>
<td><span id="hh"><select name="hh"><option value="select">select</option></select></span> /
<span id="min"><select name="min"><option value="select">select</option></select></span></td></tr>
	<tr height="50"><td class="para1">
	Crime Details :</td><td><textarea rows="5" cols="20" name="details"></textarea></td></tr>
<tr height="50"><td colspan="2" class="para3">
Victim Details :</td></tr>
<tr height="50">
<td class="para1">Enter victim's citizen Id :</td><td><input type="text" name="victimid" /></td></tr>
<tr height="50"><td class="para1">
Victim's name :</td><td><input type="text" name="victimname"/>
<input type="hidden" id="hid1" value="0"/>
<span id="0"></span></td></tr>
<tr height="30"><td></td>
<td><a href="javascript:onclick=add()">Click to add more</a></td></tr>
<tr height="50"><td colspan="2" class="para3">
Criminal Info :</td></tr>
<tr height="50"><td class="para1">
Known :<input type="radio" name="cr" value="known" onclick='remove()'/></td>
<td class="para1">
Unknown :<input type="radio" name="cr" value="unknown"/></td></tr>
<tr height="50"><td class="para1">
Enter the criminal name(If known) :</td><td><input type="text" id="111" name="criminal" disabled="disabled"/></td></tr>
<tr height="50"><td class="para1">
Enter crminal details :</td><td><textarea rows="5" cols="20" name="crdetails" id="999" disabled="disabled"></textarea>
<input type="hidden" id="hid2" value="00"/>
<span id="00"></span></td></tr>
<tr height="30"><td></td>
<td><a href="javascript:onclick=add1()">Click to add more</a></td></tr>
<tr height="50"><td class="para1">
Select a District :</td><td><span id="district1"><select name="district">
<option>select</option></select></span></td></tr>
<tr height="50"><td class="para1">
Select a Circle :</td><td><span id="circle1"><select name="circle">
<option>select</option></select></span></td></tr>
<tr height="50"><td></td>
<td><input type="submit" value="lodge it"/><input type="reset"/></td></tr></table>
</html:form>
              
              </td>
           
            </tr>
          </table></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="267">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</tbody></table>


<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" height="44">
  <tbody><tr> 
    <td width="927"><img src="/elites/images/whitespace.gif" width="100%" height="1"/></td>
  </tr>
  <tr>
    <td class="copy10white" bgcolor="#7395d1" height="40"> 
      <div align="center">
        <p align="justify">designed by elitecleats @knit</p>
        <p align="justify">&#160;</p>
      </div>
      </td>
  </tr>
</tbody>
</table>
</td></tr></tbody></table></body>
</html:html>
