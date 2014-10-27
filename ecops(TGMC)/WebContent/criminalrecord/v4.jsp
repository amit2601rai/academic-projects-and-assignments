<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="elites.model.*" %>
<%!   String t5="",s10="",s11="",s12="",s13="",q1="",q2="",q3="",q4="",s14="",b="",c="",d="",e1="",f="";
      ResultSet rs10,rs11,rs12,rs13,r1,r2,r3,r4,rs14;
%> 
<html>
<head>
<title>v4</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#3CB371">
          <center><h1>Criminal Record</h1></center><br/>
    <%        DbModel lm=new DbModel();
             XmlModel k=new XmlModel(); 
             t5=(String)request.getAttribute("range");
    %>  
      <center><h2>Range:<%out.println(t5);%></h2></center><br/>   
    <%   try{
        	 s10="select dname from elite.rtod where rname='"+t5+"'";
             rs10=lm.executeQuery(s10);
      while(rs10.next())
           { 
              out.println("DISTRICT NAME:"+rs10.getString(1));
        	  s11="select psno from elite.psdet where dname='"+rs10.getString(1)+"'";
        	  rs11=lm.executeQuery(s11);
      while(rs11.next())
        	     {
        	        //out.print("PSNO"+rs11.getInt(1));
        	        s12="select CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+rs11.getInt(1) ;
          	        rs12=lm.executeQuery(s12);
          		while(rs12.next())
          		 {
                        %>
            		  <H2>CID:</H2><h3><%out.println(rs12.getInt(2));%></h3><br/>  
                      <H2>Name:</H2><h3><%out.println(rs12.getString(3));%></h3><br/>         		   
      <%    
String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs12.getInt(2)+" ')/citizen return$c/address/city/text()"; 
     System.out.print(q1);
String q2="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs12.getInt(2)+" ')/citizen return$c/address/ps/text()"; 
     System.out.print(q2);
String q3="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs12.getInt(2)+" ')/citizen return$c/address/area/text()";      
     System.out.print(q3);
String q4="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs12.getInt(2)+" ')/citizen return$c/address/place/text()";      
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
      <H2>  Address:-</H2><br/>
          <h3>out.println(f);</h3><br/>
          Police Station:<h3>out.println(c);</h3><br/>
          City:<h3>out.println(b);</h3><br/>      
        		 
  		   
             <h2>Number of cases:</h2>        
           <h3><%out.println(rs12.getString(4));%></h3>
      <h2>Age:</h2> 
           <h3><% out.println(rs12.getString(5));%></h3>         
                 
                 <%s13="select psno,area,crime from elite.criminalrecord1 where cid="+rs12.getInt(2); 
                   rs13=lm.executeQuery(s13);%>
                 <h2>Crime Record:</h2>
   <table border="1">
       <tr> <th>City</th>
            <th>Police Station</th>
            <th>area</th>
            <th>crime</th>
      </tr>
      <%
                 while(rs13.next())
                  	  {
                  		 s14="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PSNO="+rs13.getInt(1);    
                         rs14= lm.executeQuery(s10);
                  		if(rs14.next()){}
     %>
         <tr> 
              <td><%=rs14.getString(2)%></td>
              <td><%=rs14.getString(1)%></td>
              <td><%=rs13.getString(2)%></td>
              <td><%=rs13.getString(3)%></td>
         </tr>        		
                  		
                  		
                  		<%  }%>
          		     </table>
                <hr color="blue"/>
          		  
          	<%	  }  
        	    }
            }	 
         }catch(Exception e){System.out.println("error is  "+e);}
%>
</body>
</html>