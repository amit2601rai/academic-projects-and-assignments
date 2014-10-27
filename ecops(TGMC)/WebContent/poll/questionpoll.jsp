
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
	<link href="/elites/images/use.css" rel="stylesheet" type="text/css"/>
	
	<head>
    <title>Post a Poll</title>
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

	<body leftmargin="0" topmargin="0" background="/elites/images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
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
          <td height="240"><table width="708" border="0">
            <tr>
              <td height="214" width="619">
              <%
	String ctzid="";  //to be fetched from session
	String name="Anand";  //to be queried from citizen table using ctzid
	String email="anand.raj.jha@gmail.com";   //to be queried from citizen table using ctzid
	 XmlModel db=new XmlModel();
	ctzid=(String)session.getAttribute("cid");  //to be fetched from session
	System.out.println(ctzid);
	
	String str="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+ctzid+" ')/citizen return$y/name/text()";
	      String str1="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+ctzid+" ')/citizen return$y/email/text()";
	      System.out.println(str+"\n"+str1);
	      ResultSet rs1=db.executeQuery(str);
	      ResultSet rs2=db.executeQuery(str1);
	      if(rs1.next())
	      {
	    	  name=rs1.getString(1);
	      }
	      if(rs2.next())
	      {
	    	  email=rs2.getString(1);
	      }
	      
 %><br><br><br>
<html:form action="/questionpoll">
<td>
<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
<tr>
<td colspan="3" bgcolor="#E6E6E6" class="head"><strong>Create New Poll</strong> </td>
</tr>
<tr>
<td class="para3"><strong>Author</strong></td>
<td>:</td>
<td class="para1"><%=name %></td>
</tr>
<tr>
<td width="14%" class="para3"><strong>question</strong></td>
<td width="2%">:</td>
<td width="84%"><input name="question" type="text" id="question" size="50" />
<input type="hidden" name="email" value="<%=email %>"/>
<input type="hidden" name="name" value="<%=name %>"/></td>
</tr>
<tr>
<td valign="top" class="para3"><strong>Description</strong></td>
<td valign="top">:</td>
<td><textarea name="des" cols="50" rows="3" id="des"></textarea></td>
</tr>
<tr>
<td valign="top" class="para3"><strong>Add Choices</strong></td>
<td valign="top">:</td>
</tr>
<tr>
<td width="14%" class="para3"><strong>Option 1</strong></td>
<td width="2%">:</td>
<td width="84%"><input name="op1" type="text" id="option1" size="80"/>
</td>
</tr>
<tr>
<td width="14%" class="para3"><strong>Option 2</strong></td>
<td width="2%">:</td>
<td width="84%"><input name="op2" type="text" id="option2" size="80"/>
</td>
</tr>
<tr>
<td width="14%" class="para3"><strong>Option 3</strong></td>
<td width="2%">:</td>
<td width="84%"><input name="op3" type="text" id="option3" size="80"/>
</td>
</tr>
<td width="14%" class="para3"><strong>Option 4</strong></td>
<td width="2%">:</td>
<td width="84%"><input name="op4" type="text" id="option4" size="80"/>
</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td><input type="submit" name="Submit" value="Submit" /> <input type="reset" name="Submit2" value="Reset" /></td>
</tr>
</table>
</td>
</html:form>
              <td height="214" width="83"></td>
           
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="115">&nbsp;</td>
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
