<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="elites.model.*" %>
<%!String t2="",t3="",s1="",s2="",s3="",b="",c="",d="",e1="",f="",s4="";
      			  ResultSet rs1,rs2,rs3,r1,r2,r3,r4,rs4; int a=0; %>
<html>
	<meta http-equiv="Content-Language" content="en-us"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link href="/elites/images/eoistyle.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="/elites/images/use.css" />
    <head>
    <title>ecops@elitecleats</title>
    
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
<body leftmargin="0" topmargin="0" background="/elites/images/bg.gif" bgcolor="#339933" marginheight="0" marginwidth="0">
    <center><h1></h1></center>
    <%     	      t2=(String)request.getAttribute("city");
                  t3=(String)request.getAttribute("ps"); 
                  System.out.println(t2+t3); 
             
                DbModel m=new DbModel();
                XmlModel k=new XmlModel();
      try{     
            s1="select PS_NO from ELITE.PSDET where PNAME='"+t3+"' and DNAME='"+t2+"'";
            System.out.println(s1);
            rs1=m.executeQuery(s1);
            System.out.println(s1);
           if(rs1.next()){
           System.out.println(s1);}
           System.out.println(s1);   
           a= rs1.getInt(1);
           System.out.println(s1);//police station number
          s2="select PSNO,CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+a ;
          System.out.println(s2);
        //information retrieve from crminalrecord with the use of police station no            
         // out.print(s2);
          rs2=m.executeQuery(s2);
          //System.out.println(a);
         
         
         
         %>
    
    
    <table align="center" bgcolor=" #CFC996" border="0" cellpadding="0" cellspacing="0" height="257">
      <tbody><tr> 
    
  
   <td height="257" width="932">
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
             <a href="#"><img src="/elites/images/home2.gif" width="127" height="39"/></a></td>
              <td width="127" height="39">
             <a href="#"><img src="/elites/images/admin1.gif" width="127" height="39"/></a></td>
              <td width="127">
              <img src="/elites/images/detctives1.gif" width="127" height="39"/></td>
              <td width="127">
             <a href="#"> <img src="/elites/images/hotel%2520employees1.gif" width="127" height="39"/></a></td>
              <td width="127">
             <a href="#"> <img src="/elites/images/cc%2520employee.gif" width="127" height="39"/></a></td>
              <td width="127">
              <a href="#"><img src="/elites/images/Conact%2520us1.gif" width="127" height="39"/></a></td>
              <td width="126">
            <a href="#"> <img src="/elites/images/faq1.gif" width="127" height="39"/></a></td>
         </tr>
        </tbody></table></td>
        </tr>
        </tbody>   
</table>
<table width="927" align="center" bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0">
  <tbody><tr> 
    <td valign="top" width="198" background="/elites/images/bgleft.jpg">
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
                <td width="17" height="52"><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="7" href="#" class="leftlink">Change photo</a></td>
              </tr>
              <tr>
                <td width="17" height="52"><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td width="170"><a linkindex="8" href="#" class="leftlink">View Case-Details</a></td>
              </tr>
              
        
              
              
              
              <tr>
                <td colspan="2" height="5"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="9" href="#" class="leftlink">View Criminal Record</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="10" href="#" class="leftlink">Police Ranks</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="11" href="#" class="leftlink">Responsibilities</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="12" href="#" class="leftlink">History</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src=".../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="13" href="#" class="leftlink">Districts</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="../images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="14" href="#" class="leftlink">Special Units</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Right to Information</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td><img src="/elites/images/arrow.gif" width="9" height="12"/></td>
                <td><a linkindex="19" href="#" class="leftlink">Contact Us</a></td>
              </tr>
              <tr>
                <td colspan="2"><img src="/elites/images/hrdotblue.gif" width="100%" height="1"/></td>
              </tr>
              <tr>
                <td>&#160;</td>
                <td>&#160;</td>
              </tr>
            </tbody>
          </table></td>
          </tr>
      </tbody></table></td>
    <td valign="top" width="729" bgcolor="#CFC996">
						<table width="729" height="628" border="0" bgcolor=" #CFC996">
							<tr>
								<td height="214">

								<table border="0" height="172">
									<tbody>
										<tr>
											<td width="720" height="53">
											<table border="0" height="142">
												<tbody>
													<tr>
														<td height="52" width="176"></td>
														<td height="52" width="538">CRIMINAL RECORD</td>
													</tr>
													<tr>
														<td height="53" width="176"></td>
														<td height="53" width="538">
														<table border="0">
															<tbody>
																<tr>
																	<td width="167"></td>
																	<td width="362">City:<%out.println(t2); %>
																	</td>
																</tr>
																<tr>
																	<td width="167"></td>
																	<td width="362">Police Station:<%out.println(t3); %>
																	</td>
																</tr>
															</tbody>
														</table>
														</td>
													</tr>
												</tbody>
											</table>
											</td>
										</tr>

									</tbody>
								</table>
								</td>
							</tr>

							<tr>
								<td height="529">&nbsp;
							<%  while(rs2.next())  
              { %>	  <table border="0" height="507">
									<tbody>
										<tr>
											<td width="272" height="42">CID:</td>
											<td width="445" height="42"><%out.println(rs2.getInt(2));%></td>
										</tr>
										<tr>
											<td width="272" height="39">NAME:</td>
											<td width="445" height="39"><%out.println(rs2.getString(3));%></td>
										</tr>
									<% String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs2.getInt(2)+" ')/citizen return$c/address/city/text()"; 
     System.out.print(q1);
String q2="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs2.getInt(2)+" ')/citizen return$c/address/ps/text()"; 
     System.out.print(q2);
String q3="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs2.getInt(2)+" ')/citizen return$c/address/area/text()";      
     System.out.print(q3);
String q4="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs2.getInt(2)+" ')/citizen return$c/address/place/text()";      
     System.out.print(q4);
        r1=k.executeQuery(q1);       
        r2=k.executeQuery(q2); 
        r3=k.executeQuery(q3); 
        r4=k.executeQuery(q4);         
        if(r1.next()){}   
           b= r1.getString(1);
        if(r2.next()){}   
           c= r2.getString(1);
        if(r3.next()){}   
           d= r3.getString(1);
        if(r4.next()){}   
           e1= r4.getString(1);               
        f=e1+","+d;  
       %>	
										<tr>
											<td width="272" height="84">ADDRESS:</td>
											<td width="445" height="84">
											<table border="2">
												<tbody>
													<tr>
														<td width="435" height="32"><% out.println(f);%></td>
													</tr>
													<tr>
														<td width="435" height="24">police station(home):<%out.println(c);%></td>
													</tr>
													<tr>
														<td width="435" height="20">city:<%out.println(b);%></td>
													</tr>
												</tbody>
											</table>
											</td>
										</tr>
										
										
										<tr>
											<td width="272" height="63">NUMBER OF CASES:</td>
											<td width="445" height="63"><%out.println(rs2.getString(4));%></td>
										</tr>
										<tr>
											<td width="272" height="70">AGE:</td>
											<td width="445" height="70"><%out.println(rs2.getString(5));%></td>
										</tr>
										<tr>
											<td width="272" height="246">
											<table border="0" height="212">
												<tbody>
													<tr>
														<td width="258" height="86">CRIME RECORD:-</td>
													</tr>
													<tr>
														<td width="258" height="161"></td>
													</tr>
												</tbody>
											</table>
											</td>
											<td width="445" height="246">
										<%s3="SELECT PSNO,AREA,CRIME FROM ELITE.CRIMINALRECORD1 WHERE CID="+rs2.getInt(2);
         rs3=m.executeQuery(s3); %>	<table border="2" height="77">
												<tbody>
													<tr>
														<td width="104" height="46">district</td>
														<td width="104" height="46">ps</td>
														<td width="98" height="46">area</td>
														<td width="127" height="46">crime</td>
													</tr>
											<%  
      while(rs3.next())
        {  
           s4="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PS_NO="+rs3.getInt(1);    
           rs4 = m.executeQuery(s4);
                   if(rs4.next())
                   {}
          %>		
													<tr>
														<td width="104" height="39"><%=rs4.getString(2)%></td>
														<td width="104" height="39"><%=rs4.getString(1)%></td>
														<td width="98" height="39"><%=rs4.getString(2)%></td>
														<td width="127" height="39"><%=rs4.getString(3)%></td>
												   </tr>
												</tbody>
										 <% }%>	</table>
											</td>
										</tr>
									</tbody>
							<%} %>	</table>
								

								
								</td>
							</tr>
						</table>
						</td>
  </tr>
</tbody></table>


			<table width="927" align="center" bgcolor="#ffffff" border="0"
				cellpadding="0" cellspacing="0" height="42">
				<tbody>
					<tr>
						<td width="927" height="5"><img src="/elites/images/whitespace.gif"
							width="100%" height="1" /></td>
					</tr>
					<tr>
						<td class="copy10white" bgcolor="#7395d1" height="55">
						<div align="center">
						<p align="justify">designed by elitecleats @knit</p>
						<p align="justify">&#160;</p>
						</div>
						</td>
					</tr>
				</tbody>
			</table>
			</td></tr></tbody></table>
	<%
     }catch(Exception e){System.out.println("error is:"+e);}
 %>		
			
			
			</body>
</html>
														