package elites.actions;
import elites.forms.*;
import elites.model.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * @version 	1.0
 * @author
 */
public class CdAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    
    	HttpSession hs=request.getSession();
    	CdForm appform = (CdForm) form;
  	  String temp_siid=(String)hs.getAttribute("copid");
  	  String temp_psno=(String)hs.getAttribute("psno");
  	  String temp_firno=appform.getfirno();
  	  String temp_pageno=appform.getpageno();
  	  String temp_invdetails=appform.getinvdetails();
  	  Date d=new Date();
  	System.out.print(d);
  	  String temp_date=d.toString();
  	System.out.print(temp_date);
  	String temp_sysdate=temp_date.substring(0,10);
  	System.out.print(temp_sysdate);
  	String temp_systime=temp_date.substring(11,19);
  	System.out.print(temp_systime);
    boolean validated=false;
  	  System.out.print(validated);
  	  System.out.print(temp_siid+temp_psno+temp_firno+temp_pageno+temp_invdetails);
  	  String str="<invdetails>"+temp_invdetails+"</invdetails>";
  	  System.out.print(str);
  	try{
		XmlModel xmlm=new XmlModel();
		String query="insert into ELITE.CASEDIARY values('"+temp_siid+"','"+temp_psno+"','"+temp_firno+"','"+temp_pageno+"','"+str+"','"+temp_sysdate+"','"+temp_systime+"')";
		System.out.println("after query declaration"+query);
		xmlm.executeDML(query);
		System.out.print("executed");
		validated=true;
	         
        
		  /*  HttpSession hs =request.getSession();
                hs.setAttribute("copid",temp_copid);
                hs.setAttribute("ctzid",temp_ctzid);
                hs.setAttribute("name",temp_name);*/
        System.out.println(validated);
		}
	catch(Exception e){System.out.print("in catch");}
	 if (validated)
	  {   System.out.print(validated); 
	  		request.setAttribute("firno", temp_firno);
		  return mapping.findForward("success");
	  }

	else
	  {
	  return mapping.findForward("failure");
	  }
}  




   	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    	
    	

/*	ActionMessages errors = new ActionMessages();
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
