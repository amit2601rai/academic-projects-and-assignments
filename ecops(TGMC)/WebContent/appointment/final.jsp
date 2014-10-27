<html>

<head>
<title>Success</title>
</head>

<body>
<% String file=(String)request.getAttribute("fileName"); %>
<p align="center"><font size="5" color="#000080">File Successfully Received</font></p>
<p align="center"><a href="upload/<%=file %>" >click to download</a></p>
</body>

</html>