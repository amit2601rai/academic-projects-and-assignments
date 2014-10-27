<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>mailsend</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<html:form action="/mailsend">

                    sender            <input type=text name=text1><br>

                     Reciever        <input type=text name=text2><br>

                     Subject          <input type=text name=text3><br>

                    Message        <textarea name='area1' rows=5 cols=30>                  </textarea>

                                             <input     type=submit>

</html:form>
</body>
</html:html>