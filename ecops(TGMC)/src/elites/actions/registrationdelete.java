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
public class registrationdelete extends Action
         {
             public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	         {
          try{String temp_email=request.getParameter("email");
        	  String temp_cid=request.getParameter("cid");
        	  String temp_name=request.getParameter("name");
        	  System.out.print(temp_cid);
        	  
        	     	  //delete action of admin
      	      DbModel dm=new DbModel();/*make object of db2model and call executeQuery method*/
              String query="delete from ELITE.CITIZEN where cid="+temp_cid ;
              System.out.println(query);
              dm.executeDML(query);
              mailmodel mm=new mailmodel();
              String sub="Registration Denied";
      	      String content="Hi Mr."+temp_name+",\n your Request for registration has been denied on account of some discrepancy in the information you provided";
      	      mm.send("localhost",25,"admin_e-cops@EliteCleats", temp_email, sub, content);
              
              dm.close();
      	      
          }
          catch(Exception e){
  	    	  System.out.print(e);
  	    	  }
  	      return mapping.findForward("regdeleted");
         }
     }