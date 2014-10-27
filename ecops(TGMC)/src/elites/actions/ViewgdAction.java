package elites.actions;
import elites.model.*;
import elites.forms.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import elites.model.XmlModel;

/**
 * @version 	1.0
 * @author
 */
public class ViewgdAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	String temp_psno="";
    	Viewgdform myform=(Viewgdform)form;
    	HttpSession hs=request.getSession();
    	String rcop=(String) hs.getAttribute("rcop");
    	try
    	{String temp_srno=null,temp_gddetails=null,to_print="";
    	if(rcop.equals("sp")){
    	temp_psno=myform.getps();
    	}
    	else
    	{
    	temp_psno=(String)hs.getAttribute("psno");
    	}
    	String temp_copid="420";
    	Date d=new Date();
      	System.out.print(d);
      	  String temp_date=d.toString();
      	System.out.print(temp_date);
      	String temp_sysdate=temp_date.substring(0,10);
      	System.out.print(temp_sysdate);
    	
      	
    		XmlModel xmlm=new XmlModel();
    		String query="select * from ELITE.GENERALDIARY where psno='"+temp_psno+"' and copid='"+temp_copid+"' and date='"+temp_sysdate+"'";
    		ResultSet rs = xmlm.executeQuery(query);
    		System.out.print("after rs");
    		while(rs.next())
    		{   temp_copid="<copid>"+rs.getString(2)+"</copid>";
    			temp_srno="<srno>"+rs.getString(4)+"</srno>";
    			System.out.print(temp_srno+temp_copid);
    			temp_gddetails=rs.getString(5);
    			System.out.print(temp_gddetails);
    			to_print=to_print+" "+"<x>"+" "+temp_copid+" "+temp_srno+" "+temp_gddetails+" "+"</x>";
    			System.out.print(to_print);
    			request.setAttribute("str",to_print);
              
    		}
    	}
    	catch(Exception e)
    	{System.out.print("in catch of action");
    		e.printStackTrace();
    	}
    	return mapping.findForward("success");
    	
    	
    }}
    
    
    /*
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

	ActionMessages errors = new ActionMessages();
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

    }
}
*/