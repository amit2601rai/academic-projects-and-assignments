<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>criminal</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<html:form action="/criminalrec">
<center>
    CID:<input type="text" name="cid" ><br>
    Age:<input type="text" name="age"><br>
    Crime: <input type="text" name="crime" size="21"><br>
    Area:<input type="text" name="area"><br>
    Number of cases:<input type="text" name="num"><br>
   upload a photo:<input type="file"  name="photo" ><br>
   <input type="submit" name="submit" value="submit">
</center>
</html:form>
</body>
</html:html>


