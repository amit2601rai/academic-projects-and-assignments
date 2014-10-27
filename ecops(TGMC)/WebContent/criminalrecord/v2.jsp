<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="elites.model.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%!   String t2="",t3="",s4="",s5="",s6="",q1="",q2="",q3="",q4="",s7="",b="",c="",d="",e1="",f="";
      ResultSet rs4,rs5,rs6,r1,r2,r3,r4,rs7;
       int a=0;
%> 
<html>
<head>
<title>v2</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#3CB371">
               <center><h1>Criminal Record</h1></center><br>
 <%            //at city level
              t2=(String)request.getAttribute("city");
            %> 
            <center><h2>City:<%out.println(t2);%></h2></center><br/>   
            <%try{
                 DbModel m=new DbModel();
                XmlModel k=new XmlModel();
                 s4="select psno from elite.psdet where dname='"+t2+"'";
                 rs4=m.executeQuery(s4);
            while(rs4.next())
            {
                 //out.println( "PSNO:"+rs4.getInt(1));
                 s5="select CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+rs4.getInt(1) ;
                 rs5=m.executeQuery(s5);
            	while(rs5.next())
            		{%>
            		  <H2>CID:</H2><h3><%out.println(rs5.getInt(2));%></h3><br/>  
                      <H2>Name:</H2><h3><%out.println(rs5.getString(3));%></h3><br/>
           <% 
String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs5.getInt(2)+" ')/citizen return$c/address/city/text()"; 
     System.out.print(q1);
String q2="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs5.getInt(2)+" ')/citizen return$c/address/ps/text()"; 
     System.out.print(q2);
String q3="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs5.getInt(2)+" ')/citizen return$c/address/area/text()";      
     System.out.print(q3);
String q4="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs5.getInt(2)+" ')/citizen return$c/address/place/text()";      
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
           <h3><%out.println(rs5.getString(4));%></h3>
      <h2>Age:</h2> 
           <h3><% out.println(rs5.getString(5));%></h3> 		  
            		
     <%    s6="select psno,area,crime from elite.criminalrecord1 where cid="+rs5.getInt(2); 
           rs6=m.executeQuery(s6);%>
          <h2>Crime Record:</h2>
   <table border="1">
       <tr>  <th>City</th>
            <th>Police Station</th>
            <th>area</th>
            <th>crime</th>
      </tr>
       <%while(rs6.next())
              { s7="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PSNO="+rs6.getInt(1);    
                 rs7= m.executeQuery(s7);
                  if(rs7.next())
                   {
                   }
                   
           %>
           <tr> 
              <td><%=rs7.getString(2)%></td>
              <td><%=rs7.getString(1)%></td>
              <td><%=rs6.getString(2)%></td>
              <td><%=rs6.getString(3)%></td>
         </tr>        
                	
       <%}%>
                 </table>
                <hr color="blue"/>
   <%     }
    }             
     }catch(Exception e){ System.out.println("error is  "+e);}
%>
</body>
</html>