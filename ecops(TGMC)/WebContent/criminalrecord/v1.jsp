<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="elites.model.*" %>
<html>
       <meta http-equiv="Content-Language" content="en-us"/>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<head>
<title>v1</title>
</head>
<body bgcolor="#3CB371">
       <center><h1>Criminal Record</h1></center><br>
  <%     	      String t2="",t3="",s1="",s2="",s3="",b="",c="",d="",e1="",f="",s4="";
      			  ResultSet rs1,rs2,rs3,r1,r2,r3,r4,rs4; int a=0;
      			  //at police station level
                  t2=(String)request.getAttribute("city");
                  t3=(String)request.getAttribute("ps"); 
         %> <center><h2>Police Station:<%out.println(t3);%></h2></center><br/>   
            <center><h2>City:<%out.println(t2);%></h2></center><br/>   
     <% 
                DbModel m=new DbModel();
                XmlModel k=new XmlModel();
      try{     
            s1="select PSNO from ELITE.PSDET where PNAME='"+t3+"' and DNAME='"+t2+"'";
            rs1=m.executeQuery(s1);
           if(rs1.next()){}   
           a= rs1.getInt(1);//police station number
          s2="select PSNO,CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+a ;
        //information retrieve from crminalrecord with the use of police station no            
         // out.print(s2);
          rs2=m.executeQuery(s2);
          //System.out.println(a);
       while(rs2.next())  
              { 
                 //out.println( "PSNO:"+rs2.getInt(1));
                 %><H2>CID:</H2><h3><%out.println(rs2.getInt(2));%></h3><br/>  
                   <H2>Name:</H2><h3><%out.println("NAME:"+rs2.getString(3));%></h3><br/><% 
String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs2.getInt(2)+" ')/citizen return$c/address/city/text()"; 
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
     <H2>  Address:-</H2><br/>
          <h3>out.println(f);</h3><br/>
          Police Station:<h3>out.println(c);</h3><br/>
          City:<h3>out.println(b);</h3><br/>      
      <h2>Number of cases:</h2>        
           <h3><%out.println(rs2.getString(4));%></h3>
      <h2>Age:</h2> 
                <h3><% out.println(rs2.getString(5));%></h3>
     <%  s3="SELECT PSNO,AREA,CRIME FROM ELITE.CRIMINALRECORD1 WHERE CID="+rs2.getInt(2);
         rs3=m.executeQuery(s3);%>
   <h2>Crime Record:</h2>
   <table border="1">
       <tr> <th>City</th>
            <th>Police Station</th>
            <th>area</th>
            <th>crime</th>
      </tr>
     <%  
      while(rs3.next())
        {  
           s4="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PSNO="+rs3.getInt(1);    
           rs4 = m.executeQuery(s4);
                   if(rs4.next())
                   {
                   }
    %>
      <tr> 
           <td><%=rs4.getString(2)%></td>
           <td><%=rs4.getString(1)%></td>
           <td><%=rs3.getString(2)%></td>
           <td><%=rs3.getString(3)%></td>
      </tr>        
       <% }%></table>
              <hr color="blue"/>
     <%}
     }catch(Exception e){ 
      System.out.println("error is:"+e);
   }
 %>
</body>
</html>