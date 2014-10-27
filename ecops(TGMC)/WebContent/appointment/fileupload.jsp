<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>
	<html:html>
<head>
<title>Struts File Upload Example</title>
<html:base/>
</head>
<body bgcolor="white">
<html:form action="/FileUpload" method="post" enctype="multipart/form-data">
<table>
<tr>
<td align="center" colspan="2">
<font size="4">Please Enter the Following Details</font>
</tr>

<tr>
<td align="left" colspan="2">

</tr>



<tr>
<td align="right">
File Name
</td>
<td align="left">
<html:file property="theFile"/> 
</td>
</tr>


<tr>
<td align="center" colspan="2">
<html:submit>Upload File</html:submit>
</td>
</tr>
</table>


</html:form>
</body>
</html:html>