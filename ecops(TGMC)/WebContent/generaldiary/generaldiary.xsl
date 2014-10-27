<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">
    <xsl:template match="/">
    <html>
	<head>
	<link href="../images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<link rel="shortcut icon" href="../images/GOA.ico"/>
	<title>case diary</title>
	<style type="text/css">
	body
	{
		}
	.head
	{
		font-weight:bold;
		font-family:Verdana;
		color:#ff0011;
	}	
	.style3 {font-family: "Times New Roman", Times, serif}
    .style5 {
	font-family: "Times New Roman", Times, serif;
	font-style: italic;
	font-weight: bold;
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
             <a href="/elites/citizen/citizenlogin.jsp"> <img src="images/Conact%2520us1.gif" width="127" height="39"/></a></td>
              <td width="126">
            <a href="magistrate/login.jsp"> <img src="images/faq1.gif" width="127" height="39"/></a></td>
            </tr>
          </tbody></table></td>
        </tr>
</tbody>
</table></td></tr>
<tr><td>
	<h2> <center>general diary </center> </h2>
	 <table width="984" border="1" align="center" id="one">
				   <tr>
				   <td width="111" align="center" bgcolor="#66FFFF"> <strong>COP ID</strong>  </td>
                   <td width="158" align="center" bgcolor="#66FFFF"><strong>SERIAL NO</strong> </td>
				   <td width="693" align="center" bgcolor="#66FFFF"> <strong>GENERAL DIARY DETAILS </strong></td>
				   </tr>
    </table></td></tr></tbody></table>
	   
	</body>
	</html>
	<xsl:apply-templates></xsl:apply-templates>
	</xsl:template>
	<xsl:template match="y/x">
	<table  id="one" align="center" border="1">
				   <tr>
				   <td width="112" height="32" align="center" bgcolor="#66FF99"> <strong><xsl:value-of select="copid"/></strong></td>
                   <td width="156" align="center" bgcolor="#66FF99" class="style5" ><xsl:value-of select="srno"/></td>
                   <th width="696" align="left" valign="middle" bordercolor="#000000" bgcolor="#66FF99"><span class="style3"><xsl:value-of select="gddetails"/></span></th>
     	 </tr>
	
	</table>
 
    
    </xsl:template>
</xsl:stylesheet>
