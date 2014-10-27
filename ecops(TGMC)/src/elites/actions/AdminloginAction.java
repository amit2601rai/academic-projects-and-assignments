package elites.actions;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import elites.model.*;
import elites.forms.*;
/**
 * @version 	1.0
 * @author
 */
public class AdminloginAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	  HttpSession session = request.getSession();
    	  String role="admin";
    	ResultSet rs;
    	Adminloginform myform=(Adminloginform)form;
    	String id=myform.getid();
    	String pwd=myform.getpwd();
    	String query="select pwd from ELITE.ADMINLOGIN where id='"+id+"'";
    	try{
    		DbModel db=new DbModel();
    		rs=db.executeQuery(query);
    		if(rs.next())
    		{
    			String temp_pwd=rs.getString(1);
    			if(temp_pwd.equals(pwd))
    			{
    				session.setAttribute("role", role);
    				return mapping.findForward("adminsuccess");
    			}
    			else
    			{
    				return mapping.findForward("adminfailure");
    			}
    		}
    		else
    		{
    			return mapping.findForward("invalidid");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.print("caught");
    		e.printStackTrace();
    	}
    	
    	return null;
    }
}