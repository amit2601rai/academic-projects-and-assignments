<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<%@ page import="java.sql.*" %>
<%@ page import="elites.model.*" %>


	<meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="../images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<head>
    <title>View a Topic</title>
    <link rel="stylesheet" type="text/css" href="/elites/images/use.css" />
	<style type="text/css">
	.head
	{
		font-weight:bolder;
		font-family:Verdana
		color:green;
	}	
   </style>
   <link rel="shortcut icon" href="../images/GOA.ico">
	</head>

	<body leftmargin="0" topmargin="0"  background="../images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
    <center><h1></h1></center>
   
   <table width="926" align="center" bgcolor=" #CFC996" border="0" cellpadding="0" cellspacing="0" height="257">
      <tbody><tr> 
    
  
   <td width="926" height="257">
   <p>
   
   <table width="932" border="0" bgcolor="#CFC996">
     <tr>
       <td width="172" height="209"><img src="/elites/images/national20emblem.jpg" width="153" height="175"></td>
       <td width="573" height="209"><img src="/elites/images/logofinal.jpg" height="100%" width="100%"/></td>
       <td width="165" height="209"><img src="/elites/images/indian-police-lo.jpg" width="153" height="175"></td>
     </tr>
     <tr>

					<td colspan="3" height="11"><img src="/elites/images/untitled.bmp" width="100%"><img src="/elites/images/khaki1.bmp" width="100%"><img src="/elites/images/blue.bmp" width="100%"></td>

				</tr>
   </table>       
  <table width="892" border="0" height="55">
        <tbody><tr>
          <td width="60" height="51"><table width="895" border="0" height="41">
            <tbody><tr>
              <td width="127">
             <a href="/elites/index1.html"><img src="../images/home2.gif" width="127" height="39"/></a></td>
              <td width="127" height="39">
             <a href="/elites/admin.jsp"><img src="../images/admin1.gif" width="127" height="39"/></a></td>
              <td width="127">
              <img src="../images/detctives1.gif" width="127" height="39"/></td>
              <td width="127">
             <a href="/elites/coplogin/login.jsp"> <img src="../images/hotel%2520employees1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="/elites/licenses/hotelncentres/hotelsncentresform.jsp"> <img src="../images/cc%2520employee.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="/elites/citizen/citizenlogin.jsp"> <img src="../images/Conact%2520us1.gif" width="127" height="39"/></a></td>
              <td width="126">
            <a href="/elites/magistrate/login.jsp"> <img src="../images/faq1.gif" width="127" height="39"/></a></td>
            </tr>
          </tbody></table></td>
        </tr>
</tbody>
</table>
<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr> 
    <td valign="top" width="198" background="../images/bgleft.jpg">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody><tr>
    <td><p>&#160;</p>
      <p>&#160;</p></td>
    </tr>
    <tr>
    <td valign="top">
          

          <table width="100%" border="0" cellpadding="2" cellspacing="1" height="588">
            <tbody>
            
            <tr>
                <td width="17" height="52"><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="7" href="/elites/coplogin/photoupload.jsp" class="leftlink">Change photo</a></td>
              </tr>
              <tr>
                <td width="17" height="52"><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="8" href="#" class="leftlink">Mission and Vision</a></td>
              </tr>
              
        
              
              
              
              <tr>
                <td colspan="2" height="5"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="9" href="#" class="leftlink">Organization Structure</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="10" href="#" class="leftlink">Police Ranks</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="11" href="#" class="leftlink">Responsibilities</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="12" href="#" class="leftlink">History</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="13" href="#" class="leftlink">Districts</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="14" href="#" class="leftlink">Special Units</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Right to Information</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Contact Us</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="../images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td>&#160;</td>
                <td>&#160;</td>
              </tr>
            </tbody>
          </table>            </td>
        </tr>
      </tbody></table></td>
    <td valign="top" width="729" bgcolor="#CFC996">
      <table width="720" height="908" border="0">
        <tr>
          <td height="635"><table width="708" height="633" border="0">
            <tr>
              <td width="457" height="629">
              <%
	String qid=request.getParameter("id");
    	try{
    		DbModel db=new DbModel();
    		int num=0;
    		String str="select * from ELITE.FORUM_QUESTION where qid="+qid;
    		ResultSet rs=db.executeQuery(str);
    		if(rs.next())
    		{
    		}
    		int view=rs.getInt(8);
    		view=view+1;
			%>
			<center>
										<table border="0" width="667">
											<tbody>
												<tr>
													<td height="265" width="178">
													<table width="181" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
														<tbody>
															<tr>
															  <td width="177" height="92"><span class="para3">Posted By :</span><span class="para1"><%=rs.getString(5) %></span></td>
															</tr>
															<tr>
															  <td width="177" height="59"><span class="para3">Email :</span><span class="para1"><%=rs.getString(6) %></span></td>
															</tr>
															<tr>
															  <td width="177" height="112"><span class="para3">Time :</span><span class="para1"><%=rs.getString(7) %></span></td>
															</tr>
														</tbody>
													</table>
												  </td>
													<td height="265" width="479">
													<table border="1" cellspacing="0" cellpadding="0" bordercolor="#000000">
														<tbody>
															<tr>
																<td width="480"><span class="para3">Topic :</span><span class="para1"><%=rs.getString(2) %></span></td>
															</tr>
															<tr>
															  <td height="27"><span class="para3">Detail :</span></td>
														  </tr>
															<tr>
																<td width="480" height="171"><span class="para5"><%=rs.getString(3) %></span></td>
															</tr>
															<tr>
																<td width="480" height="23">
																<table border="0">
																	<tbody>
																		<tr>
																		  <td width="236" height="35"><span class="para3">No. of Views :</span><span class="para1"><%=rs.getString(8) %></span></td>
																			<td width="229"><span class="para3">No. of Replies :</span><span class="para1"><%=rs.getString(9) %></span></td>
																		</tr>
																	</tbody>
																</table>																</td>
															</tr>
														</tbody>
													</table>
												  </td>
												</tr>
											</tbody>
										</table><br>

										<%
			
			String str1="update ELITE.FORUM_QUESTION set nview="+view+" where qid="+qid;
			db.executeDML(str1);
			
			String str2="select * from ELITE.FORUM_ANSWER where qid="+qid;
			ResultSet rs2=db.executeQuery(str2);
			while(rs2.next())
			{
			%>
			
							
										<table width="670" border="0">
                                          <tr>
                                            <td width="184"><table width="190" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
                                              <tr>
                                                <td width="180" height="75"><span class="para3">Posted By :</span><span class="para1"><%=rs2.getString(4) %></span></td>
                                              </tr>
                                              <tr>
                                                <td height="80"><span class="para3">Email :</span><span class="para1"><%=rs2.getString(5) %></span></td>
                                              </tr>
                                              <tr>
                                                <td height="72"><span class="para3">Time :</span><span class="para1"><%=rs2.getString(7) %></span></td>
                                              </tr>
                                            </table></td>
                                            <td width="470" height="195"><table width="475" height="229" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
                                              <tr>
                                                <td width="465" height="23"><span class="para1">Re[<%=rs.getString(2) %>]</span></td>
                                              </tr>
                                              <tr>
                                                <td height="27"><span class="para1">Detail :</span></td>
                                              </tr>
                                              <tr>
                                                <td height="169"><span class="para5"><%=rs2.getString(6) %></span></td>
                                              </tr>
                                            </table></td>
                                          </tr>
                                        </table>
										

										

										<%
			}
			}
			catch(Exception e)
			{out.print(e);}

 %>
 <br>
							<span class="notify">Want to reply??? </span> <a href="answerforum.jsp?qid=<%=qid %>">reply</a></center></td>
            
            </tr>
          </table></td>
        </tr>
       
        <tr>
          <td height="267">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</tbody></table>


<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" height="44">
  <tbody><tr> 
    <td width="927"><img src="../images/whitespace.gif" width="100%" height="1"/></td>
  </tr>
  <tr>
    <td class="copy10white" bgcolor="#7395d1" height="40"> 
      <div align="center">
        <p align="justify">designed by elitecleats @knit</p>
        <p align="justify">&#160;</p>
      </div>
      </td>
  </tr>
</tbody>
</table>
</td></tr></tbody></table></body>
</html:html>
