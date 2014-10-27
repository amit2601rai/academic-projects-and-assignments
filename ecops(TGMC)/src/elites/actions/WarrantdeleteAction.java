package elites.actions;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import elites.model.DbModel;

/**
 * @version 	1.0
 * @author
 */
public class WarrantdeleteAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
   try{
    		
	   String query="";String query2="";String temp_copid="";
   	   String temp_firno=request.getParameter("refno");
   	   System.out.print(temp_firno);
	   DbModel dm=new DbModel();
	    
	    	
	    //extracting copid of the cop who requested this arrest warrant
    	query2="select copid from ELITE.ARRESTWARRANT where firno='"+temp_firno+"'";
   	    ResultSet rs=dm.executeQuery(query2);
	  	     while(rs.next())
	  	    {temp_copid=rs.getString(1);
	  	     }
	  	
	  	//now deleting arrest warrant request from the record
	  	query="delete from ELITE.ARRESTWARRANT where firno='"+temp_firno+"'";     
	  	dm.executeDML(query);
	  	     
	  	////now extracting email id of the cop who requested this arrest warrant
	  	     /*code of email extraction*/
	  	     //MAIL MODULE(sending mail to the cop of copid=temp_copid about fir no=temp_firno that warrant rejected)
	  	 
   }	
	  	catch(Exception e)
		{System.out.print(e);}
		  	
	  	return mapping.findForward("warrantdeleted");
	  	     
	  	     
	  	     
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
