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
public class DeletionshoAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	try{
    		
    		   	String q=""; String r=""; ResultSet rs2; String temp_ctzid="";
    	    	String str=request.getParameter("refno");
    	    	String temp_cat=request.getParameter("cat");
    	    	System.out.print(str+temp_cat);
    	    	DbModel dm=new DbModel();
    	    	
    	    	if(temp_cat.equals("arms"))
    	    	 {   q="select ctzid from ELITE.LICENSEARMS where refno="+str+"";
    	    	     r="delete from ELITE.LICENSEARMS where refno="+str+"";
    	    	 }
    	    	else if(temp_cat.equals("hbc"))
    	    	 {  q="select ctzid from ELITE.LICENSEHBC where refno="+str+"";
    	    	    r="delete from ELITE.LICENSEHBC where refno="+str+"";
    	    	 
    	    	 }
    	    	else if(temp_cat.equals("lds"))
    	    	 {  q="select ctzid from ELITE.LICENSELDS where refno="+str+"";
    	    	    r="delete from ELITE.LICENSELDS where refno="+str+"";
    	    	 
    	    	 }
    	    	else if(temp_cat.equals("mm"))
    	    	{  q="select ctzid from ELITE.LICENSEMASSMEETING where refno="+str+"";
    	    	   r="delete from ELITE.LICENSEMASSMEETING where refno="+str+"";
    	    	}
    	
    	    	
    	    	
    	    	
    	//extracting citizen id corresponding to the approved license request sender
	  	rs2=dm.executeQuery(q);
	  	while(rs2.next())
	  	{temp_ctzid=rs2.getString(1);
	  	 } 
	  	System.out.println(temp_ctzid);
	  	//now sending mail(rejected) to the citizen who requested this license
	  	
	  	//MAIL MODULE
	  	
	  	
	  	//deleting his License request from the record
	  	dm.executeDML(r);
	  	}
    	
    	catch(Exception e)
    	{System.out.print(e);}
	  	return mapping.findForward("successfullydeletedsho");
	  	
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
