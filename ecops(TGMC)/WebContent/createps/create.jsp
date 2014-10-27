<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>
	<html>
<head>
<title>create</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Language" content="en-us"/>
<style type="text/css">
	.head
	{
		font-weight:bolder;
		font-family:Verdana
		color:green;
	}	
   </style>
   <link rel="shortcut icon" href="../images/GOA.ico">
<link href="../images/eoistyle.css" rel="stylesheet" type="text/css"/>
<link href="/elites/images/use.css" rel="stylesheet" type="text/css"/>

<script language="JavaScript" src="../javascript/OptionTransfer.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript">

<!--// ===================================================================
// Author: Matt Kruse <matt@mattkruse.com>
// WWW: http://www.mattkruse.com/
//
// NOTICE: You may use this code for any purpose, commercial or
// private, without any further permission from the author. You may
// remove this notice from your final code if you wish, however it is
// appreciated by the author if at least my web site address is kept.
//
// You may *NOT* re-distribute this code in any way except through its
// use. That means, you can include it in your product, or your web
// site, or any other form where the code is actually being used. You
// may not put the plain javascript up on your site for download or
// include it in your javascript libraries for download. 
// If you wish to share this code with others, please just point them
// to the URL instead.
// Please DO NOT link directly to my .js files from your site. Copy
// the files to your server and use them there. Thank you.
// ===================================================================

function hasOptions(obj){if(obj!=null && obj.options!=null){return true;}return false;}
function selectUnselectMatchingOptions(obj,regex,which,only){if(window.RegExp){if(which == "select"){var selected1=true;var selected2=false;}else if(which == "unselect"){var selected1=false;var selected2=true;}else{return;}var re = new RegExp(regex);if(!hasOptions(obj)){return;}for(var i=0;i<obj.options.length;i++){if(re.test(obj.options[i].text)){obj.options[i].selected = selected1;}else{if(only == true){obj.options[i].selected = selected2;}}}}}
function selectMatchingOptions(obj,regex){selectUnselectMatchingOptions(obj,regex,"select",false);}
function selectOnlyMatchingOptions(obj,regex){selectUnselectMatchingOptions(obj,regex,"select",true);}
function unSelectMatchingOptions(obj,regex){selectUnselectMatchingOptions(obj,regex,"unselect",false);}
function sortSelect(obj){var o = new Array();if(!hasOptions(obj)){return;}for(var i=0;i<obj.options.length;i++){o[o.length] = new Option( obj.options[i].text, obj.options[i].value, obj.options[i].defaultSelected, obj.options[i].selected) ;}if(o.length==0){return;}o = o.sort(
function(a,b){if((a.text+"") <(b.text+"")){return -1;}if((a.text+"") >(b.text+"")){return 1;}return 0;});for(var i=0;i<o.length;i++){obj.options[i] = new Option(o[i].text, o[i].value, o[i].defaultSelected, o[i].selected);}}
function selectAllOptions(obj){if(!hasOptions(obj)){return;}for(var i=0;i<obj.options.length;i++){obj.options[i].selected = true;}}
function moveSelectedOptions(from,to){if(arguments.length>3){var regex = arguments[3];if(regex != ""){unSelectMatchingOptions(from,regex);}}if(!hasOptions(from)){return;}for(var i=0;i<from.options.length;i++){var o = from.options[i];if(o.selected){if(!hasOptions(to)){var index = 0;}else{var index=to.options.length;}to.options[index] = new Option( o.text, o.value, false, false);}}for(var i=(from.options.length-1);i>=0;i--){var o = from.options[i];if(o.selected){from.options[i] = null;}}if((arguments.length<3) ||(arguments[2]==true)){sortSelect(from);sortSelect(to);}from.selectedIndex = -1;to.selectedIndex = -1;}
function copySelectedOptions(from,to){var options = new Object();if(hasOptions(to)){for(var i=0;i<to.options.length;i++){options[to.options[i].value] = to.options[i].text;}}if(!hasOptions(from)){return;}for(var i=0;i<from.options.length;i++){var o = from.options[i];if(o.selected){if(options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text){if(!hasOptions(to)){var index = 0;}else{var index=to.options.length;}to.options[index] = new Option( o.text, o.value, false, false);}}}if((arguments.length<3) ||(arguments[2]==true)){sortSelect(to);}from.selectedIndex = -1;to.selectedIndex = -1;}
function moveAllOptions(from,to){selectAllOptions(from);if(arguments.length==2){moveSelectedOptions(from,to);}else if(arguments.length==3){moveSelectedOptions(from,to,arguments[2]);}else if(arguments.length==4){moveSelectedOptions(from,to,arguments[2],arguments[3]);}}
function copyAllOptions(from,to){selectAllOptions(from);if(arguments.length==2){copySelectedOptions(from,to);}else if(arguments.length==3){copySelectedOptions(from,to,arguments[2]);}}
function swapOptions(obj,i,j){var o = obj.options;var i_selected = o[i].selected;var j_selected = o[j].selected;var temp = new Option(o[i].text, o[i].value, o[i].defaultSelected, o[i].selected);var temp2= new Option(o[j].text, o[j].value, o[j].defaultSelected, o[j].selected);o[i] = temp2;o[j] = temp;o[i].selected = j_selected;o[j].selected = i_selected;}
function moveOptionUp(obj){if(!hasOptions(obj)){return;}for(i=0;i<obj.options.length;i++){if(obj.options[i].selected){if(i != 0 && !obj.options[i-1].selected){swapOptions(obj,i,i-1);obj.options[i-1].selected = true;}}}}
function moveOptionDown(obj){if(!hasOptions(obj)){return;}for(i=obj.options.length-1;i>=0;i--){if(obj.options[i].selected){if(i !=(obj.options.length-1) && ! obj.options[i+1].selected){swapOptions(obj,i,i+1);obj.options[i+1].selected = true;}}}}
function removeSelectedOptions(from){if(!hasOptions(from)){return;}if(from.type=="select-one"){from.options[from.selectedIndex] = null;}else{for(var i=(from.options.length-1);i>=0;i--){var o=from.options[i];if(o.selected){from.options[i] = null;}}}from.selectedIndex = -1;}
function removeAllOptions(from){if(!hasOptions(from)){return;}for(var i=(from.options.length-1);i>=0;i--){from.options[i] = null;}from.selectedIndex = -1;}
function addOption(obj,text,value,selected){if(obj!=null && obj.options!=null){obj.options[obj.options.length] = new Option(text, value, false, selected);}}
//-->
</script>

<script language="JavaScript" type="text/javascript">
<!--

var NS4 = (navigator.appName == "Netscape" && parseInt(navigator.appVersion) < 5);

function addOption(theSel, theText, theValue)
{
  var newOpt = new Option(theText, theValue);
  var selLength = theSel.length;
  theSel.options[selLength] = newOpt;
}

function deleteOption(theSel, theIndex)
{ 
  var selLength = theSel.length;
  if(selLength>0)
  {
    theSel.options[theIndex] = null;
  }
}

function moveOptions(theSelFrom, theSelTo)
{
  
  var selLength = theSelFrom.length;
  var selectedText = new Array();
  var selectedValues = new Array();
  var selectedCount = 0;
  
  var i;
  
  // Find the selected Options in reverse order
  // and delete them from the 'from' Select.
  for(i=selLength-1; i>=0; i--)
  {
    if(theSelFrom.options[i].selected)
    {
      selectedText[selectedCount] = theSelFrom.options[i].text;
      selectedValues[selectedCount] = theSelFrom.options[i].value;
      deleteOption(theSelFrom, i);
      selectedCount++;
    }
  }
  
  // Add the selected text/values in reverse order.
  // This will add the Options to the 'to' Select
  // in the same order as they were in the 'from' Select.
  for(i=selectedCount-1; i>=0; i--)
  {
    addOption(theSelTo, selectedText[i], selectedValues[i]);
  }
  
  if(NS4) history.go(0);
}

//-->
</script>
</head>
<body leftmargin="0" topmargin="0" background="../images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
    <center><h1></h1></center>

<script language="javascript" >

var xmlHttp=null;

function check(id,num)
{ 
var url;
var strg;
xmlHttp=GetXmlHttpObject();
if (xmlHttp==null)
  {
  alert ("Your browser does not support AJAX!");
  return;
  } 
if(num==1)
{
url="/elites/loadaction.do";
url=url+"?u="+id;

 xmlHttp.onreadystatechange=stateChanged; 
 }
if(num==2)
{
url="/elites/loaddistrictaction.do";
url=url+"?r="+id;
 xmlHttp.onreadystatechange=stateChanged1; 

}
if(num==3)
{
url="/elites/loadcircleaction.do";
url=url+"?c="+id;
document.getElementById("h1").innerHTML="<input type='hidden' id='hid1' name='dname'/>";
document.getElementById("hid1").value=id;
 xmlHttp.onreadystatechange=stateChanged2; 
}
if(num==4)
{

url="/elites/loadareaaction.do";
url=url+"?d="+document.getElementById('hid1').value+"&c="+id+"&ps="+document.getElementById('ps').value;
document.getElementById("h2").innerHTML="<input type='hidden' id='hid2' name='cname'/>";
document.getElementById("hid2").value=id;
xmlHttp.onreadystatechange=stateChanged3;
}
if(num==5)
{

url="/elites/checkpsnameaction.do";
url=url+"?ps="+document.getElementById('ps').value;
xmlHttp.onreadystatechange=stateChanged4;
}
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

   

document.getElementById("a").innerHTML=xmlHttp.responseText;

}
}
if (xmlHttp.readyState==2)
{
document.getElementById("a").innerHTML="Loading.....";
}

}
function stateChanged1() 
{ 
if ((xmlHttp.readyState==4)&&(xmlHttp.status==200))
{ 


document.getElementById("b").innerHTML=xmlHttp.responseText;


}

if (xmlHttp.readyState==2)
{
document.getElementById("b").innerHTML="Loading.....";
}
}
function stateChanged2() 
{ 
if ((xmlHttp.readyState==4)&&(xmlHttp.status==200))
{ 
document.getElementById("c").innerHTML=xmlHttp.responseText;
}

if (xmlHttp.readyState==2)
{
document.getElementById("c").innerHTML="Loading.....";
}
}
function stateChanged3() 
{ 
if ((xmlHttp.readyState==4)&&(xmlHttp.status==200))
{ 


document.getElementById("ar").innerHTML=xmlHttp.responseText;


}

if (xmlHttp.readyState==2)
{
document.getElementById("ar").innerHTML="Loading.....";
}
}

function stateChanged4() 
{ 
if ((xmlHttp.readyState==4)&&(xmlHttp.status==200))
{ 
document.getElementById("con").innerHTML=xmlHttp.responseText;
}

if (xmlHttp.readyState==2)
{

document.getElementById("con").innerHTML="Loading.....";
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
function show(str)
{
alert(str);
return;
}
</script>


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
             <a href="../index1.html"><img src="../images/home2.gif" width="127" height="39"/></a></td>
              <td width="127" height="39">
             <a href="../admin.jsp"><img src="../images/admin1.gif" width="127" height="39"/></a></td>
              <td width="127">
              <img src="../images/detctives1.gif" width="127" height="39"/></td>
              <td width="127">
             <a href="../coplogin/login.jsp"> <img src="../images/hotel%2520employees1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="../licenses/hotelncentres/hotelsncentresform.jsp"> <img src="../images/cc%2520employee.gif" width="127" height="39"/></a></td>
              <td width="127">
              <a href="/elites/citizen/citizenlogin.jsp"><img src="../images/Conact%2520us1.gif" width="127" height="39"/></a></td>
              <td width="126">
            <a href="../magistrate/login.jsp"> <img src="../images/faq1.gif" width="127" height="39"/></a></td>
            </tr>
          </tbody></table></td>
        </tr>
</tbody>
</table>
<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr> 
    <td valign="top" width="198" background="../images/bgleft.jpg">
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
                <td width="17" height="52"><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="7" href="/elites/coplogin/photoupload.jsp" class="leftlink">Change photo</a></td>
              </tr>
              <tr>
                <td width="17" height="52"><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="8" href="#" class="leftlink">Mission and Vision</a></td>
              </tr>
              
        
              
              
              
              <tr>
                <td colspan="2" height="5"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="9" href="#" class="leftlink">Organization Structure</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="10" href="#" class="leftlink">Police Ranks</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="11" href="#" class="leftlink">Responsibilities</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="12" href="#" class="leftlink">History</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="13" href="#" class="leftlink">Districts</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="14" href="#" class="leftlink">Special Units</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Right to Information</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Contact Us</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td>&#160;</td>
                <td>&#160;</td>
              </tr>
            </tbody>
          </table>            </td>
        </tr>
      </tbody></table></td>
       <td valign="top" width="729" bgcolor="#CFC996"><form action="createpsact.jsp">
       <span class="head"><center>Create a Police Station</center></span><br><br>
						<table width="729" height="354" border="0" >	
							<tr>
							
								<td height="224">
								<table width="690" border="0">
									<tr height="50">
										<td class="para1">Enter a Police Station name(to be created)</td>
										<td><input type="text" id="ps" name="psname"
											onBlur="check(this.value,5)"><span id="con" class="para1"></span></td>
									</tr>
									<tr height="50">
										<td class="para1">Select a zone name :</td>
										<td><select name="zone">
											<option value="kanpur" onclick=check(this.value,1)>kanpur</option>
											<option value="lucknow" onclick=check(this.value,1)>lucknow</option>
											<option value="varanasi" onclick=check(this.value,1)>varanasi</option>
										</select></td>
									</tr>
									<tr height="50">
										<td width="300" class="para1">Select a Range :</td>
										<td><span id="a"><select name="1">
											<option value="n">select</option>
										</select></span></td>

									</tr>
									<tr height="50">
										<td class="para1">Select a District :</td>
										<td><span id="b"><select name="2">
											<option value="n">select</option>
										</select></span></td>

									</tr>
									<tr height="50">
										<td class="para1">Select a Circle :</td>
										<td><span id="c"><select name="3">
											<option value="n">select</option>
										</select> </span><span id="h1"></span> <span id="h2"></span></td>

									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td height="118">&nbsp;
								<center><table border="0" cellpadding="0" cellspacing="1">
									<tbody>
										<tr>
											<td width="243" height="107"><span id="ar">
   						 <select style="width: 150px"  name="list3" multiple size=10 ondblclick="opt.transferRight()"/>
  					
  						</select>
</span> </td>
											<td width="108" height="107"><input name="right" value="   &gt;&gt;   " onClick="moveOptions(this.form.list1,this.form.list2)" type="button"><br><br>
		<input name="right" value="All &gt;&gt;" onClick="moveAllOptions(this.form.list1,this.form.list2)" type="button"><br><br>
		<input name="left" value="   &lt;&lt;   " onClick="moveOptions(this.form.list2,this.form.list1)" type="button"><br><br>
		<input name="left" value="All &lt;&lt;" onClick="moveAllOptions(this.form.list2,this.form.list1)" type="button">					</td>
											<td width="195" height="107"><select style="width: 150px" id="sel" name="list2" multiple size=10 ondblclick="opt.transferLeft()">
</select></td>
										</tr>
									</tbody>
								</table></center>
								</td>
							</tr>
						</table><br><br>
						<center>
<input type="submit"/>
<input type="reset"/></center>
</td>
  </tr>
</tbody></table>
</form>


<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" height="44">
  <tbody><tr> 
    <td width="927"><img src="../images/whitespace.gif" width="100%" height="1"/></td>
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
</html>

