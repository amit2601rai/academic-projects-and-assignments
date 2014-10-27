package elites.actions;
import java.util.Date;

import elites.model.*;
import elites.forms.*;

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
public class ReqarrestAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	try {
		HttpSession session = request.getSession();
		ReqarrestForm appform = (ReqarrestForm) form;
		 String temp_firno=appform.getfirno();
		 String temp_whom=appform.getwhom();
		 String temp_reason=appform.getreason();
		 String temp_courtno=appform.getcourtno();
		
		String temp_copid=(String)session.getAttribute("copid");
		String temp_psno=(String)session.getAttribute("psno");;
		DbModel dm= new DbModel();
		
		Date d=new Date();
	  	String temp_date=d.toString();
	  	System.out.print(temp_date);
	  	String temp_sysdate=temp_date.substring(0,10);
	  		  	
		String query="insert into ELITE.ARRESTWARRANT values('"+temp_copid+"','"+temp_psno+"','"+temp_firno+"','"+temp_sysdate+"','"+temp_whom+"','"+temp_reason+"','"+temp_courtno+"','false')";
		dm.executeDML(query);
	}
	catch (Exception e) {System.out.print(e);
	    // Report the error using the appropriate name and ID.
	    //errors.add("name", new ActionMessage("id"));
       }

	return mapping.findForward("requestwarrantsuccess");
	
	/*ActionMessages errors = new ActionMessages();
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
	return (forward);*/

    }
}
