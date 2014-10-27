package elites.actions;
import java.sql.*;
import elites.model.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class VerificationAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	try{
    	String query="";
    	String temp_refno=request.getParameter("refno");
    	String temp_cat=request.getParameter("cat");
    	System.out.print(temp_refno+temp_cat);
    	if(temp_cat.equals("arms"))
        	 query="update ELITE.LICENSEARMS set verified='true' where refno="+temp_refno;
    	else if(temp_cat.equals("hbc"))
        	 query="update ELITE.LICENSEHBC set verified='true' where refno="+temp_refno;
    	else if(temp_cat.equals("lds"))
        	 query="update ELITE.LICENSELDS set verified='true' where refno="+temp_refno;
    	else if(temp_cat.equals("mm"))
    	     query="update ELITE.LICENSEMASSMEETING set verified='true' where refno="+temp_refno;
    	
    	
    	DbModel dm=new DbModel();
    	dm.executeDML(query);
    	
    	}
    	catch(Exception e)
    	{System.out.print(e);}
    	return mapping.findForward("successfullyverified");
    	
    	
    	
    	
    	
    	
    	
    	
    	
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
	return (forward);*/

    }
}
