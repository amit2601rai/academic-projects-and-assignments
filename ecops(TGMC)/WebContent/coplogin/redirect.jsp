<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>
	<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>

	<html:html>
<head>
<title>redirect</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<% 
       String spr="";
       spr=(String)session.getAttribute("copid");
       out.print(spr);
       spr=spr.substring(0,2);
		if(spr.equals("01")){%><jsp:forward page="/coplogin/cop1.jsp"></jsp:forward><%}
        if(spr.equals("02")){%><jsp:forward page="/coplogin/cop2.jsp"></jsp:forward><%}
        if(spr.equals("03")){%><jsp:forward page="/coplogin/cop3.jsp"></jsp:forward><%}
        if(spr.equals("04")){%><jsp:forward page="/coplogin/cop4.jsp"></jsp:forward><%}
        if(spr.equals("05")){%><jsp:forward page="/coplogin/cop5.jsp"></jsp:forward><%}
        if(spr.equals("06")){%><jsp:forward page="/coplogin/cop6.jsp"></jsp:forward><%}
        if(spr.equals("07")){%><jsp:forward page="/coplogin/cop7.jsp"></jsp:forward><%}
        if(spr.equals("08")){%><jsp:forward page="/coplogin/cop8.jsp"></jsp:forward><%}
        if(spr.equals("09")){%><jsp:forward page="/coplogin/cop9.jsp"></jsp:forward><%}
        if(spr.equals("10")){%><jsp:forward page="/coplogin/cop10.jsp"></jsp:forward><%}
        if(spr.equals("11")) {%> <jsp:forward page="/coplogin/cop11.jsp"> </jsp:forward><%} %>
                         
                     
</body>
</html:html>