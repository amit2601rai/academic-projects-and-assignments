package elites.actions;
import elites.forms.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import javax.servlet.*;
/**
 * @version 	1.0
 * @author
 */
public class MgloginAction extends Action

{     public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	try{ MgloginForm appform = (MgloginForm) form;
	     DbModel dm= new DbModel();
	     
	     HttpSession session=request.getSession();
	     
	     String new_pwd="";String temp_courtno="";
	    String temp_mgid=appform.getmgid();
	    String temp_pwd=appform.getpwd();
	    String query="select pwd from ELITE.MAGISTRATE where mgid='"+temp_mgid+"'";
	    System.out.println(temp_mgid+temp_pwd+query);
	    ResultSet rs=dm.executeQuery(query);
	    if(rs.next())
	         {
	          new_pwd=rs.getString("pwd");
	          if(new_pwd.trim().equals(temp_pwd.trim()))
	             {
	               String query2="select courtno from ELITE.MAGISTRATE where mgid='"+temp_mgid+"'";
	               ResultSet rs2=dm.executeQuery(query2);
	               while(rs2.next())
	                {temp_courtno=rs2.getString(1);
	                 }  
	                 session.setAttribute("mgid",temp_mgid);
	                 session.setAttribute("courtno",temp_courtno);
	             return mapping.findForward("mgloginsuccess");
	             }
	          else
	           {
	        	 return mapping.findForward("mgloginfailure");
	            }
	          }
	    else
	        {System.out.println("Sorry Your Id Doesn't exist");
	            return mapping.findForward("mgloginnoid");
	         }
	
	}
	
	 catch (Exception e) {
		 System.out.println(e);
	    // Report the error using the appropriate name and ID.
	    //errors.add("name", new ActionMessage("id"));

	}
	
	
	
	
	
	
	
	ActionMessages errors = new ActionMessages();
	ActionForward forward = new ActionForward(); // return value

	

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);

	    // Forward control to the appropriate 'failure' URI (change name as desired)
	    //	forward = mapping.findForward("failure");

	} else {

	    // Forward control to the appropriate 'success' URI (change name as desired)
	    // forward = mapping.findForward("success");

	}

	// Finish with
	return (forward);

    }
}
