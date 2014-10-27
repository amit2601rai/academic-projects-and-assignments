<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>acceptlicense</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@page import="java.sql.*" %>
<%@page import="elites.model.*" %>
<%try
  {String temp_dname=(String)session.getAttribute("district");
   DbModel dm=new DbModel(); %>
   verified license requests are as follows:-<br />
<br>
<br>ARMS LICENSE REQUESTS<br>
<%//arms license list
String str2="select refno,ctzid,pname,aname,owner,wno,wname,wmodel from ELITE.LICENSEARMS where dname='"+temp_dname+"' and verified='true' and approved='false'" ;
ResultSet rs2=dm.executeQuery(str2);
while(rs2.next())
{
%> refno= <%=rs2.getString(1)%>
   ctzid= <%=rs2.getString(2)%>
   pname= <%=rs2.getString(3)%>
   aname= <%=rs2.getString(4)%>
   owner= <%=rs2.getString(5)%>
   weapon no= <%=rs2.getString(6)%>
   weapon name= <%=rs2.getString(7)%>
   weapon model= = <%=rs2.getString(8)%>
   <a href="/elites/approval.do?refno=<%=rs2.getString(1)%>&cat=arms">approve</a>
   <a href="/elites/deletion.do?refno=<%=rs2.getString(1)%>&cat=arms">delete</a><br />
<%}%>
<br>
<br>HOTEL LICENSE REQUESTS<br>
<%//hotels and browsing centres license list
String str3="select refno,ctzid,pname,aname,owner,location,floors,noemp from ELITE.LICENSEHBC where dname='"+temp_dname+"' and verified='true' and approved='false'" ;
ResultSet rs3=dm.executeQuery(str3);
while(rs3.next())
{
%> refno= <%=rs3.getString(1)%>
   ctzid= <%=rs3.getString(2)%>
   pname= <%=rs3.getString(3)%>
   aname= <%=rs3.getString(4)%>
   owner= <%=rs3.getString(5)%>
   location= <%=rs3.getString(6)%>
   floors= <%=rs3.getString(7)%>
   noemp= = <%=rs3.getString(8)%>
   <a href="/elites/approval.do?refno=<%=rs3.getString(1)%>&cat=hbc">approve</a>
   <a href="/elites/deletion.do?refno=<%=rs3.getString(1)%>&cat=hbc">delete</a><br />
<%}%>
<br>
<br>LOUDSPEAKER LICENSE REQUESTS<br>
<%//loudspeaker license list
String str="select refno,ctzid,pname,aname,owner,location,stime,etime,reason from ELITE.LICENSELDS where dname='"+temp_dname+"' and verified='true' and approved='false'" ;

ResultSet rs=dm.executeQuery(str);
while(rs.next())
{
%> refno= <%=rs.getString(1)%>
   ctzid= <%=rs.getString(2)%>
   pname= <%=rs.getString(3)%>
   aname= <%=rs.getString(4)%>
   owner= <%=rs.getString(5)%>
   location= <%=rs.getString(6)%>
   start time= = <%=rs.getString(7)%>
   endtime== <%=rs.getString(8)%>
   reason= <%=rs.getString(9)%>
   
   <a href="/elites/approval.do?refno=<%=rs.getString(1)%>&cat=lds">approve</a>
   <a href="/elites/deletion.do?refno=<%=rs.getString(1)%>&cat=lds">delete</a><br />
<%}%>
<br>
<br>MASS MEETING VERIFIED LICENSE REQUESTS<br>
<%//mass meeting license list
//String temp_pname="e";String temp_refno="";String temp_ctzid="";String temp_aname="";String temp_reason="";String temp_poo="";String temp_mmtype="";String temp_stime="";String temp_etime="";String temp_tnop="";
String str4="select refno,ctzid,pname,aname,reason,poo,mmtype,stime,etime,tnop from ELITE.LICENSEMASSMEETING where dname='"+temp_dname+"' and verified='true' and approved='false'" ;
ResultSet rs4=dm.executeQuery(str4);
while(rs4.next())
{
%> refno= <%=rs4.getString(1)%>
   ctzid= <%=rs4.getString(2)%>
   pname= <%=rs4.getString(3)%>
   aname= <%=rs4.getString(4)%>
   reason= <%=rs4.getString(5)%>
   place of occurence= <%=rs4.getString(6)%>
   meeting type= <%=rs4.getString(7)%>
   start time= = <%=rs4.getString(8)%>
   endtime== <%=rs4.getString(9)%>
   no of participants= <%=rs4.getString(10)%>
   
   <a href="/elites/approval.do?refno=<%=rs4.getString(1)%>&cat=mm">approve</a>
   <a href="/elites/deletion.do?refno=<%=rs4.getString(1)%>&cat=mm">delete</a><br />
<%}
}

catch(Exception e)
{e.printStackTrace();
out.print(e);}%>
 
 </body>
</html:html>