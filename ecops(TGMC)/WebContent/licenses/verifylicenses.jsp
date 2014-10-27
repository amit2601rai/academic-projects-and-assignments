<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html>
<head>
<title>verifylicenses</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<p align="justify">
  <%@page import="java.sql.*" %>
  <%@page import="elites.model.*" %>
  <%try
{String temp_pname=(String)session.getAttribute("ps");
	String temp_dname=(String)session.getAttribute("district");
 String temp_refno="";
 DbModel dm=new DbModel();%>

request for all types of licenses are:-<br />
<br>
<strong><br>
ARMS LICENSE REQUESTS</strong></p>
<table width="694" border="1">
  <tr>
    <td width="79">reference no</td>
    <td width="59">citizen id</td>
    <td width="76">area name</td>
    <td width="45">owner</td>
    <td width="73">weapon no</td>
    <td width="90">weapon name </td>
    <td width="90">weapon model</td>
    <td width="60">&nbsp;</td>
    <td width="64">&nbsp;</td>
  </tr>
  <%//arms license list
System.out.print("jsp");
String str2="select refno,ctzid,aname,owner,wno,wname,wmodel from ELITE.LICENSEARMS where pname='"+temp_pname+"' and dname='"+temp_dname+"' and verified='false'" ;
ResultSet rs2=dm.executeQuery(str2);
while(rs2.next())
{temp_refno=rs2.getString(1);
%>
  <tr>
    <td><%=rs2.getString(1)%></td>
    <td><%=rs2.getString(2)%></td>
    <td><%=rs2.getString(3)%></td>
    <td><%=rs2.getString(4)%></td>
    <td><%=rs2.getString(5)%></td>
    <td><%=rs2.getString(6)%></td>
    <td><%=rs2.getString(7)%></td>
    <td><a href="/elites/verification.do?refno=<%=rs2.getString(1)%>&cat=arms">verified</a></td>
    <td><a href="/elites/deletionsho.do?refno=<%=rs2.getString(1)%>&cat=arms">delete</a></td>
  </tr><% }%>
</table>
<p align="justify"><strong><br>
HOTEL LICENSE REQUESTS</strong></p>
<table width="690" border="1">
  <tr>
    <td width="88">reference no</td>
    <td width="74">citizen id</td>
    <td width="73">area name</td>
    <td width="46">owner</td>
    <td width="70"> location </td>
    <td width="56">floors</td>
    <td width="119">no of emp</td>
    <td width="46">&nbsp;</td>
    <td width="60">&nbsp;</td>
  </tr>
  <%//hotels and browsing centres license list
String str3="select refno,ctzid,aname,owner,location,floors,noemp from ELITE.LICENSEHBC where pname='"+temp_pname+"' and dname='"+temp_dname+"' and verified='false'";
ResultSet rs3=dm.executeQuery(str3);
while(rs3.next())
{temp_refno=rs3.getString(1);
%>
  <tr>
    <td><%=rs3.getString(1)%></td>
    <td><%=rs3.getString(2)%></td>
    <td><%=rs3.getString(3)%></td>
    <td><%=rs3.getString(4)%></td>
    <td><%=rs3.getString(5)%></td>
    <td><%=rs3.getString(6)%></td>
    <td><%=rs3.getString(7)%></td>
    <td><a href="/elites/verification.do?refno=<%=rs3.getString(1)%>&cat=hbc">verified</a></td>
    <td><a href="/elites/deletionsho.do?refno=<%=rs3.getString(1)%>&cat=hbc">delete</a></td>
  </tr> <%}%>
</table>
<p><br>
  <strong>LOUDSPEAKER LICENSE REQUESTS</strong></p>
<table width="774" border="1">
  <tr>
    <td width="88">reference no</td>
    <td width="74">citizen id</td>
    <td width="73">area name</td>
    <td width="46">owner</td>
    <td width="70"> location </td>
    <td width="56">start time </td>
    <td width="66">end time </td>
    <td width="99">reason</td>
    <td width="70">&nbsp;</td>
    <td width="68">&nbsp;</td>
  </tr>
<%//loudspeaker license list
String str="select refno,ctzid,aname,owner,location,stime,etime,reason from ELITE.LICENSELDS where pname='"+temp_pname+"' and dname='"+temp_dname+"' and verified='false'" ;

ResultSet rs=dm.executeQuery(str);
while(rs.next())
{temp_refno=rs.getString(1);
%>
  <tr>
    <td><%=rs.getString(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
    <td><%=rs.getString(4)%></td>
    <td><%=rs.getString(5)%></td>
    <td><%=rs.getString(6)%></td>
    <td><%=rs.getString(7)%></td>
    <td><%=rs.getString(8)%></td>
    <td><a href="/elites/verification.do?refno=<%=rs.getString(1)%>&cat=lds"> verified</a></td>
    <td><a href="/elites/deletionsho.do?refno=<%=rs.getString(1)%>&cat=lds">delete</a></td>
  </tr>
  <%}%>
</table>
<p><strong>
MASS MEETING LICENSE REQUESTS</strong></p>
<table width="814" border="1">
  <tr>
    <td width="76">reference no</td>
    <td width="72">citizen id</td>
    <td width="71">area name</td>
    <td width="47">reason</td>
    <td width="84">occur at </td>
    <td width="93">meeting type  </td>
    <td width="59">start time </td>
    <td width="60">end time </td>
    <td width="78">no.of p'pants </td>
    <td width="56">&nbsp;</td>
    <td width="48">&nbsp;</td>
  </tr>
<%//mass meeting license list
//String temp_pname="e";String temp_refno="";String temp_ctzid="";String temp_aname="";String temp_reason="";String temp_poo="";String temp_mmtype="";String temp_stime="";String temp_etime="";String temp_tnop="";
String str4="select refno,ctzid,aname,reason,poo,mmtype,stime,etime,tnop from ELITE.LICENSEMASSMEETING where pname='"+temp_pname+"' and dname='"+temp_dname+"' and verified='false'" ;
ResultSet rs4=dm.executeQuery(str4);
while(rs4.next())
{temp_refno=rs4.getString(1);
%>
  <tr>
    <td><%=rs4.getString(1)%></td>
    <td><%=rs4.getString(2)%></td>
    <td><%=rs4.getString(3)%></td>
    <td><%=rs4.getString(4)%></td>
    <td><%=rs4.getString(5)%></td>
    <td><%=rs4.getString(6)%></td>
    <td><%=rs4.getString(7)%></td>
    <td><%=rs4.getString(8)%></td>
    <td><%=rs4.getString(9)%></td>
    <td><a href="/elites/verification.do?refno=<%=rs4.getString(1)%>&cat=mm">verified</a></td>
    <td><a href="/elites/deletionsho.do?refno=<%=rs4.getString(1)%>&cat=mm">delete</a></td>
  </tr>
  <%}%>
</table>
<p><br>
  
  <br />
  <%}
catch(Exception e)
{e.printStackTrace();
out.print(e);}%>
</p>
</body>
</html>