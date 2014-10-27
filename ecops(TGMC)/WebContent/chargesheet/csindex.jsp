<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<%@ page import="java.sql.*" %>
<%@ page import="elites.model.*" %>


	<meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="/elites/images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<head>
    <title>File Chargesheet</title>
    <script type="text/javascript">

function init()
{
document.getElementById("hid1").value="0";
document.getElementById("hid2").value="00";
}
function add()
{
		
         var i=0;
         var j=0;
         i=document.getElementById("hid1").value;
         j=i+1;
        
     document.getElementById(i).innerHTML="<br><br>CITIZEN ID:<input type='text' name='cid'><br>NAME:<input type='text' name='name'><br>ADDRESS:<br><textarea rows='5' cols='40' NAME='address'></textarea><br>ACTS:<br><textarea rows='4' cols='20' NAME='acts'></textarea><br><span id='"+j+"'></span>";
        document.getElementById("hid1").value=j;
}


function add1()
{
		
          var i=0;
          var j=0;
       i=document.getElementById("hid2").value;
       j=i+1;
         document.getElementById(i).innerHTML="<br><br>CITIZEN ID:<input type='text' name='cid1'><br>NAME:<input type='text' name='name1'><br>ADDRESS:<BR><textarea rows='5' cols='40' name='address1'></textarea><br><span id='"+j+"'></span>";
         document.getElementById("hid2").value=j;
}
</script>
    <link rel="stylesheet" type="text/css" href="/elites/images/use.css" />
	<style type="text/css">
	.head
	{
		font-weight:bolder;
		font-family:Verdana
		color:green;
	}	
   </style>
   <link rel="shortcut icon" href="/elites/images/GOA.ico">
	</head>

	<body onLoad="init()" leftmargin="0" topmargin="0"  background="/elites/images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
    <center><h1></h1></center>
   
   <table width="926" align="center" bgcolor=" #CFC996" border="0" cellpadding="0" cellspacing="0" height="257">
      <tbody><tr> 
    
  
   <td width="926" height="257">
   <p>
   <table width="932" border="0" bgcolor="#CFC996">
     <tr>
       <td width="172" height="209"><img src="/elites/images/national20emblem.jpg" width="153" height="175"></td>
       <td width="573" height="209"><img
						src="/elites/images/logofinal.jpg" height="100%" width="100%"></td>
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
              <img src="/elites/images/detctives1.gif" width="127" height="39"/></td>
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
                <td width="170"><a linkindex="8" href="#" class="leftlink">Mission and Vision</a></td>
              </tr>
              
        
              
              
              
              <tr>
                <td colspan="2" height="5"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="9" href="#" class="leftlink">Organization Structure</a></td>
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
    <td valign="top" width="729" bgcolor=" #CFC996">
      <table width="720" height="630" border="0">
        <tr>
          <td height="214"><table width="708" height="200" border="0">
            <tr>
              <td width="457" height="194">
<form action="chargesheet.jsp">
										
<br>
<table width="690" border="0" bordercolor="#131A9F" class="notify1">
<tr height="30" bgcolor="#131A9F"><td colspan="2">
CHARGE SHEET FORM</td></tr>
<tr height="50">
   <td width="323" class="para1">FIR NO:</td>
   <td width="357"><input type="text" name="firno"></td></tr>
   <tr height="35">
  <td colspan="2"  class="para1"> CRIMINAL DETAILS:</td></tr>
  <tr height="50">
   <td class="para1">CITIZEN ID:</td><td><input type="text" name="cid"/></td></tr>
    <tr height="50">
   <td class="para1">NAME:</td><td><input type="text" name="name"></td></tr>
    <tr height="50">
   <td class="para1">ADDRESS:</td>
   <td><textarea rows="5" cols="20" NAME="address"></textarea></td></tr>
  <tr height="50"><td class="para1">ACTS:</td>
   <td><textarea rows="4" cols="20" NAME="acts"></textarea>
   <input type="hidden" id="hid1" value="0">
   <span id="0"></span></td></tr>
   <tr height="20"><td colspan="2">
   <a href="javascript:onclick=add()">Click to add more</a></td></tr>
    
<tr height="35"><td colspan="2" class="para1">
WITNESS DETAILS:</td></tr>
        <tr height="50">
       <td class="para1"> CITIZEN ID:</td><td><input type="text" name="cid1"></td></tr>
        <tr height="50">
         <td class="para1">NAME:</td><td><input type="text" name="name1"></td></tr>
         <tr height="50">
         <td class="para1">ADDRESS:</td>
         <td><textarea rows="5" cols="20" NAME="address1"></textarea>
 <input type="hidden" id="hid2" value="00"/>
   <span id="00"></span></td></tr>
  <tr height="20"><td colspan="2">
   <a href="javascript:onclick=add1()">Click to add more</a></td></tr>
  <tr height="50">
   <td class="para1">Timestamp:</td>
      <td>  <select  name="date" ><option>not selected</option>
                         <option>01</option>
                         <option>02</option>
                          <option>03</option>
                         <option>04</option>
                          <option>05</option>
                         <option>06</option>
                          <option>07</option>
                         <option>08</option>
                          <option>09</option>
                         <option>10</option>
                          <option>11</option>
                         <option>12</option>
                          <option>13</option>
                         <option>14</option>
                          <option>15</option>
                         <option>16</option>                      
                         <option>17</option>
                         <option>18</option>
                          <option>19</option>
                         <option>20</option>
                          <option>21</option>
                         <option>22</option>
                          <option>23</option>
                         <option>24</option>
                          <option>25</option>
                         <option>26</option>
                          <option>27</option>
                         <option>28</option>
                          <option>29</option>
                         <option>30</option>
                          <option>31</option>
                  </select>/
      <select name="month" > <option>not selected</option>
                         <option>jan</option>
                         <option>feb</option>
                         <option>march</option>
                         <option>april</option>
                          <option>may</option>
                         <option>june</option>
                          <option>july</option>
                         <option>august</option>
                          <option>september</option>
                         <option>october</option>
                          <option>november</option>
                         <option>december</option>                    
                      
                      </select>/<select  name="year" >
                         <option>not selected</option>
                         <option>2010</option>
                         <option>2011</option>
                         <option>2012</option>
                         <option>2013</option>
                          <option>2014</option>
                         <option>2015</option>
                          <option>2016</option>
                         <option>2017</option>
                          <option>2018</option>
                         <option>2019</option>
                          <option>2020</option>
                     </select></td></tr> 

<tr height="50"><td class="para1">SUMMARY:</td>
 <td> <textarea rows="5" cols="20" NAME="investigation"></textarea></td></tr></table><br>
<input type="submit" value="submit">
<input type="reset"  value="reset"><br>
</form>
										

              
              </td>
            
            </tr>
          </table></td>
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
