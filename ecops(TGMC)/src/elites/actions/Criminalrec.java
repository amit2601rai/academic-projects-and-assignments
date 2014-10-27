package elites.actions;
import java.sql.*;

import elites.model.*;
import elites.forms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.*;
public class Criminalrec extends Action
          {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	           {   String str1="",str2="",t="",t1="",str3="",t2="",str4="",p="",q="",str5="",str6="",x1="",x2="",x3="",x4="",a1="",a2="",a3="",a4="";
	         Criminalform trans = (Criminalform) form;
	   	           String citd=trans.getcid();
            	   String age=trans.getage();
            	   String crime=trans.getcrime();
            	   String area=trans.getarea();
            	   String num=trans.getnum();
            	   HttpSession session = request.getSession();
            	   String spr="";
                   spr=(String)session.getAttribute("copid");
                 
                   
                   try{ System.out.println("try");
                   System.out.println(spr);  
                   Class.forName("com.ibm.db2.jcc.DB2Driver");
                      Connection con= DriverManager.getConnection("jdbc:db2:ECOPS","amit rai","rai"); 
                      Statement st6=con.createStatement();
                      Statement st=con.createStatement();
                      System.out.println("1"); 
                      Statement st1=con.createStatement();
                      Statement st2=con.createStatement();
                      Statement st3=con.createStatement();
                      Statement st4=con.createStatement();
                      Statement s1=con.createStatement();
                      Statement s2=con.createStatement();
                      Statement s3=con.createStatement();
                      Statement s4=con.createStatement();
                      System.out.println("2");
                      Statement st5=con.createStatement();
                      System.out.println("3");
 str1="xquery for $y in db2-fn:sqlquery('select COP_INFO from ELITE.COPS where COP_ID=''"+spr+"'' ' )/cop return$y/posting/ps/text()"; 
 str2="xquery for $y in db2-fn:sqlquery('select COP_INFO from ELITE.COPS where COP_ID=''"+spr+"'' ' )/cop return$y/posting/city/text()"; 
                   ResultSet rs=st.executeQuery(str1);
                   System.out.println("4");
                   ResultSet rs1=st1.executeQuery(str2);
                 while(rs.next())
                   { System.out.println("while1");
                        t=rs.getString(1);
                   }
                 while(rs1.next())
                 { System.out.println("while2");
                      t1=rs1.getString(1);
                 }
                 System.out.println(t1);   
str3="select psno from ELITE.PSDET where pname='"+t+"' and dname='"+t1+"'";             
             ResultSet rs2=st2.executeQuery(str3);      
             while(rs2.next())
             { System.out.println("while3");
                  t2=rs2.getString(1);
             }
x1="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+citd+" ' )/info return$y/address/city/text()"; 
x2="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+citd+" ' )/info return$y/address/policestation/text()";   
x3="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+citd+" ' )/info return$y/address/area/text()";
x4="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+citd+" ' )/info return$y/address/place/text()"; 
ResultSet r1=s1.executeQuery(x1);   
ResultSet r2=s2.executeQuery(x2);
ResultSet r3=s3.executeQuery(x3);   
ResultSet r4=s4.executeQuery(x4);

while(r1.next())
{ System.out.println("while3");
     a1=r1.getString(1);
}
while(r2.next())
{ System.out.println("while3");
     a2=r2.getString(1);
}
while(r3.next())
{ System.out.println("while3");

     a3=r3.getString(1);
}
while(r4.next())
{ System.out.println("while3");
     a4=r4.getString(1);
}
    

p="<address><city>"+a1+"</city><policestation>"+a2+"</policestation><area>"+a3+"</area><place>"+a4+"</place></address>";
str6="xquery for $y in db2-fn:sqlquery('select INFO from ELITE.CITIZEN where CID="+citd+" ' )/info return$y/name/text()";     
         ResultSet rs4=st4.executeQuery(str6);
         while(rs4.next())
         {System.out.println("while5");
        	q=rs4.getString(1); 
          }
str5="insert into ELITE.CRIMINALRECORD VALUES("+t2+","+citd+",'"+q+"','"+p+"','"+num+"','"+age+"')" ;                 
                st5.executeUpdate(str5);  
                System.out.println("while6");
str6="insert into ELITE.CRIMINALRECORD1 VALUES("+t2+","+citd+",'"+area+"','"+crime+"')" ;                             
                st6.executeUpdate(str6);  
                System.out.println("while7");
                }
              catch(Exception e){}
              return mapping.findForward("success");      
	           
	        }
          }
  	      