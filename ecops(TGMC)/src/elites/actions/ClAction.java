package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.sql.*;
import elites.model.*;
import elites.forms.*;

/**
 * @version 	1.0
 * @author
 */
public class ClAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	DbModel db=new DbModel();
	Cloginform myform=(Cloginform)form;
	String temp_cid=myform.getcid();
	String temp_pwd=myform.getpwd();
	String a="";
	String b="";
	String st="";
	String email="";
	String name="";
	System.out.print(temp_cid);
	System.out.print(temp_pwd);
    	
	try {

	    String query="select * from ELITE.CLOGIN where cid="+temp_cid;
	    ResultSet rs=db.executeQuery(query);
	    if(rs.next())
	    {
	    	a=rs.getString(2);
	    	b=rs.getString(3);
	    	if(temp_pwd.trim().equals(a.trim()))
	    	{
	    		if(b.equals("1"))
	    		{
	    			st="1";
	    		}
	    		else
	    		{
	    			st="2";
	    		}
	    		
	    	}
	    	else 
	    	{
	    		st="3";
	    	}
	    }
	    else
	    {
	    	st="4";
	    }
	    request.setAttribute("status",st);
	    HttpSession session = request.getSession();
	      session.setAttribute("cid", temp_cid);
	      
	      db.close();

	} catch (Exception e) {
		
		System.out.print(e);

	}

	return mapping.findForward("success");
    }
}
