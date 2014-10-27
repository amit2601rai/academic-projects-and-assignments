<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="elites.model.*" %>
<%!   String t4="",s14="",s15="",s16="",s17="",s18="",s19="",b="",c="",d="",e1="",f="";
      ResultSet rs14,rs15,rs16,rs17,rs18,rs19,r1,r2,r3,r4;
%> 
<html>
<head>
<title>v5</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body bgcolor="#3CB371">
       <center><h1>Criminal Record</h1></center><br/>
       <%     DbModel lm=new DbModel();
              XmlModel k=new XmlModel(); 
             t4=(String)request.getAttribute("zone");
       %>  
      <center><h2>Zone:<%out.println(t4);%></h2></center><br/>  
       
    <%    
       try{ 	
        	
             s14="select range from elite.ztor where zone='"+t4+"'";
             rs14=lm.executeQuery(s14);
          while(rs14.next())
          {
             // out.print("RANGE:"+rs14.getString(1));
              s15="select dname from elite.rtod where rname='"+rs14.getString(1)+"'";
              rs15=lm.executeQuery(s15);
         while(rs15.next())
            { 
              //out.println("DISTRICT NAME:"+rs15.getString(1));
        	  s16="select psno from elite.psdet where dname='"+rs15.getString(1)+"'";
        	  rs16=lm.executeQuery(s16);
         while(rs16.next())
        	  {
        	   //out.print("PSNO"+rs16.getInt(1));
        	   s17="select CID,NAME,\"NUMBER OF CASES\",AGE from ELITE.CRIMINALRECORD where PSNO="+rs16.getInt(1) ;
          	   rs17=lm.executeQuery(s17);
         while(rs17.next())
          		{%>
          		   <H2>CID:</H2><h3><%out.println(rs17.getInt(2));%></h3><br/>  
                   <H2>Name:</H2><h3><%out.println(rs17.getString(3));%></h3><br/>     
          		  
          	     <%    
String q1="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs17.getInt(2)+" ')/citizen return$c/address/city/text()"; 
     System.out.print(q1);
String q2="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs17.getInt(2)+" ')/citizen return$c/address/ps/text()"; 
     System.out.print(q2);
String q3="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs17.getInt(2)+" ')/citizen return$c/address/area/text()";      
     System.out.print(q3);
String q4="xquery for $c in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+rs17.getInt(2)+" ')/citizen return$c/address/place/text()";      
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
           <h3><%out.println(rs17.getString(4));%></h3>
      <h2>Age:</h2> 
           <h3><% out.println(rs17.getString(5));%></h3>         
                 
        	<%s18="select psno,area,crime from elite.criminalrecord1 where cid="+rs17.getInt(2); 
                   rs18=lm.executeQuery(s18);%>
                 <h2>Crime Record:</h2>
   <table border="1">
       <tr> <th>City</th>
            <th>Police Station</th>
            <th>area</th>
            <th>crime</th>
      </tr>
              <%     	while(rs18.next())
                  	{    s19="SELECT PNAME,DNAME FROM ELITE.PSDET WHERE PSNO="+rs18.getInt(1);    
                         rs19= lm.executeQuery(s19);
                  		if(rs14.next()){}
                  		 %>
         <tr> 
              <td><%=rs19.getString(2)%></td>
              <td><%=rs19.getString(1)%></td>
              <td><%=rs18.getString(2)%></td>
              <td><%=rs18.getString(3)%></td>
         </tr>  
                  
                  	<%} %>
          		 	     </table>
                <hr color="blue"/>
          		 
          	<%	  }  
        	    }
           } 
          }        	 
                                  
}catch(Exception e){System.out.println("error is  "+e);}
%>
</body>
</html>