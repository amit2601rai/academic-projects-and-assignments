<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="elites.model.*" %>
<%!   String t1="",t2="",s7="",s8="",s9="",b="",c="",d="",e1="",f="",s10="";
      ResultSet rs7,rs8,rs9,r1,r2,r3,r4,rs10;
%> 
<html>
<head>
<title>v3</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#3CB371">
        <center><h1>Criminal Record</h1></center><br/>
    <%       //at circle level
             t1=(String)request.getAttribute("circle");
             t2=(String)request.getAttribute("city");
    %>        
    <center><h2>Circle:<%out.println(t1);%></h2></center><br/>   
 <%try{        
                DbModel lm=new DbModel();
                XmlModel k=new XmlModel(); 
    s7="select psno from elite.psdet where cname='"+t1+"' and dname='"+t2+"'";
    rs7=lm.executeQuery(s7);
      while(rs7.next())
        {  //out.println( "PSNO:"+rs7.getInt(1));
           s8="select CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+rs7.getInt(1) ;
           rs8=lm.executeQuery(s8);
        		while(rs8.next())
        		{%>
            	<H2>CID:</H2><h3><%out.println(rs8.getInt(2));%></h3><br/>  
                <H2>Name:</H2><h3><%out.println(rs8.getString(3));%></h3><br/>       		
        		         <% 
String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs8.getInt(2)+" ')/citizen return$c/address/city/text()"; 
     System.out.print(q1);
String q2="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs8.getInt(2)+" ')/citizen return$c/address/ps/text()"; 
     System.out.print(q2);
String q3="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs8.getInt(2)+" ')/citizen return$c/address/area/text()";      
     System.out.print(q3);
String q4="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs8.getInt(2)+" ')/citizen return$c/address/place/text()";      
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
           <h3><%out.println(rs8.getString(4));%></h3>
      <h2>Age:</h2> 
           <h3><% out.println(rs8.getString(5));%></h3> 		  
 <% s9="select psno,area,crime from elite.criminalrecord1 where cid="+rs8.getInt(2); 
 rs9=lm.executeQuery(s9);%>
                 <h2>Crime Record:</h2>
   <table border="1">
       <tr> <th>City</th>
            <th>Police Station</th>
            <th>area</th>
            <th>crime</th>
      </tr>
      <% while(rs9.next())
                	{
                s10="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PSNO="+rs9.getInt(1);    
                rs10= lm.executeQuery(s10);
               if(rs10.next()){} 	
         %>
         <tr> 
              <td><%=rs10.getString(2)%></td>
              <td><%=rs10.getString(1)%></td>
              <td><%=rs9.getString(2)%></td>
              <td><%=rs9.getString(3)%></td>
         </tr>        
                  <%}%> 	
                	
                 </table>
                <hr color="blue"/>
  <%               
                		
                	}
        	    }
             }
            catch(Exception e){ System.out.println("error is  "+e);}

%>
</body>
</html>