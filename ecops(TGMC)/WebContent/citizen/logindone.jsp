<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>logindone</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
		String a=(String)request.getAttribute("status");
		System.out.print(a);
		if(a.equals("1"))
		{%>
		<jsp:forward page="/citizen/home.jsp"/>
		<%}
		else if(a.equals("2"))
		{%>
		<jsp:forward page="/citizen/verifyfirst.jsp"></jsp:forward>
		<%}
		else if(a.equals("4"))
		{
		%>
		<jsp:forward page="/citizen/invalid.jsp"></jsp:forward>
		<%
		}
		else
		{%>
		<jsp:forward page="/citizen/wrongpwd.jsp"></jsp:forward>
		<%
		}
		
		
		 %>
</body>
</html:html>