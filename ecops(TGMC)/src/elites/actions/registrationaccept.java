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



/**
 * @version 	1.0
 * @author
 */
public class registrationaccept extends Action
         {
             public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	         {
          try{
        	  String temp_cid=request.getParameter("cid");
        	  String temp_email=request.getParameter("email");
        	  String temp_name=request.getParameter("name");
        	  System.out.println(temp_cid+"in action & email is"+temp_email);
        	  
        	 
        	  //accepted action of admin
      	      DbModel dm=new DbModel();/*make object of db2model and call executeQuery method*/
              String query="update ELITE.CITIZEN set status='1' where cid="+temp_cid ;
              System.out.println("in accept action  mkl "+query);
              dm.executeDML(query);     
      	      String query1="insert into ELITE.CLOGIN values("+temp_cid+",'2222','0')";
      	      System.out.print(query1);
      	      dm.executeDML(query1);
      	      mailmodel mm=new mailmodel();
      	      String link="http://172.20.7.184:9080/elites/regverify.do?id="+temp_cid;
      	      String sub="Registration Accepted";
      	      String content="Hi Mr."+temp_name+",\n your Request for registration has been accepted.\nClick on link given below to verify your e-mail id\n "+link;
      	      mm.send("localhost",25,"admin_e-cops@EliteCleats", temp_email, sub, content);
              
              dm.close();
      	           	      
          	 }
          catch(Exception e){
      	    	  System.out.print(e);
      	    	  }
      	      return mapping.findForward("regaccepted");
	         }
         }

