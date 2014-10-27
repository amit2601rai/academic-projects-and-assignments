<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">
    <xsl:template match="/">
    <html>
	<head>
	<title>case diary</title>
		<link href="../images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<link rel="shortcut icon" href="../images/GOA.ico"/>
	<style type="text/css">
	body
	{
		background-color:white;
	}
	.head
	{
		font-weight:bold;
		font-family:Verdana;
		color:#ff0011;
	}	
	</style>
	</head>
	<body leftmargin="0" topmargin="0" bgcolor="#FFFFFF" marginheight="0" marginwidth="0">
	
	<table width="926" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" height="257">
      <tbody><tr> 
    
  
   <td width="926" height="257">
   <p><img src="images/national20emblem.jpg" width="153" height="175"/></p>
&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
           
  <table width="892" border="0" height="55">
        <tbody><tr>
          <td width="60" height="51"><table width="895" border="0" height="41">
            <tbody><tr>
              <td width="127">
             <a href="index1.html"><img src="images/home2.gif" width="127" height="39"/></a></td>
              <td width="127" height="39">
             <a href="admin.jsp"><img src="images/admin1.gif" width="127" height="39"/></a></td>
              <td width="127">
              <img src="images/detctives1.gif" width="127" height="39"/></td>
              <td width="127">
             <a href="coplogin/login.jsp"> <img src="images/hotel%2520employees1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="licenses/hotelncentres/hotelsncentresform.jsp"> <img src="images/cc%2520employee.gif" width="127" height="39"/></a></td>
              <td width="127">
              <img src="images/Conact%2520us1.gif" width="127" height="39"/></td>
              <td width="126">
            <a href="magistrate/login.jsp"> <img src="images/faq1.gif" width="127" height="39"/></a></td>
            </tr>
          </tbody></table></td>
        </tr>
</tbody>
</table></td></tr>
</tbody></table>
	   
	<center><h2>Desired Case</h2></center>
	</body>
	</html>
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:template>
	<xsl:template match="y/x">
	<div style="border-bottom:dotted;">
    <table><strong>
    <tr>
    <td><span class="head">si-ID:  </span><xsl:value-of select="siid"/></td>
    </tr>
    <tr> 
    <td><span class="head">pageno:  </span><xsl:value-of select="pageno"/></td>
    <td><span class="head">investigation details </span><xsl:value-of select="invdetails"/></td>
    </tr>
    </strong>
    </table>
    </div>
    </xsl:template>
</xsl:stylesheet>
