package elites.actions;
import elites.model.*;
import elites.forms.*;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import javax.servlet.http.HttpSession;
/**
 * @version 	1.0
 * @author
 */
public class VcdAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	//String hid="";
    	String temp_firno="";
    	HttpSession session=request.getSession();
    	String temp_siid=null,temp_pageno=null,temp_invdetails=null,to_print="";
    	//String temp_psno="423512";//to be taken from session
    	//String temp_firno="3434";//temporaririly taken static
    	try
    	{
    	CdForm appform = (CdForm) form;
    //	hid=appform.gethid();
    	
   		temp_firno=appform.getfirno();
    	
    	
    	System.out.print(temp_firno);
    String temp_psno=(String)session.getAttribute("psno");	
    	
    		XmlModel xmlm=new XmlModel();
    		String query="select * from ELITE.CASEDIARY where psno='"+temp_psno+"' and firno='"+temp_firno+"'";
    		ResultSet rs = xmlm.executeQuery(query);
    		System.out.print("after rs");
    		while(rs.next())
    		{   temp_siid="<siid>"+rs.getString(1)+"</siid>";
    		System.out.print(temp_siid);
    			temp_pageno="<pageno>"+rs.getString(4)+"</pageno>";
    			System.out.print(temp_pageno);
    			temp_invdetails=rs.getString(5);
    			System.out.print(temp_invdetails);
    			to_print=to_print+" "+"<x>"+" "+temp_siid+" "+temp_pageno+" "+temp_invdetails+" "+"</x>";
    			System.out.print(to_print);
    			request.setAttribute("str",to_print);
              
    		}
    	}
    	catch(Exception e)
    	{System.out.print("in catch of action");
    		e.printStackTrace();
    	}
    	return mapping.findForward("success");
    	
    	//out.print("<y>"+" "+to_print+" "+"</y>");
    }
   	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

	/*ActionMessages errors = new ActionMessages();
	ActionForward forward = new ActionForward(); // return value

	try {

	    // do something here

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("name", new ActionMessage("id"));

	}

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

    }*/
}
