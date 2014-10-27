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
public class Regverify extends Action
         {
             public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	         {
            	 String temp_id="";
            	 DbModel db=new DbModel();
          try{
        	  
        	 temp_id=request.getParameter("id");
        	  String query="update ELITE.CLOGIN set status='1' where cid="+temp_id;
        	  System.out.print(query);
        	  db.executeDML(query);
          }
          catch(Exception e)
          {
        	  System.out.print(e);
          }
          		db.close();
          		request.setAttribute("cid", temp_id);
        	  return mapping.findForward("success");
	         }
         }