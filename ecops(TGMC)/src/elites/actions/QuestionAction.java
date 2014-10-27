package elites.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import elites.forms.*;
import elites.model.*;

/**
 * @version 	1.0
 * @author
 */
public class QuestionAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	ActionMessages errors = new ActionMessages();
	ActionForward forward = new ActionForward(); // return value
	Qforumform myform=(Qforumform)form;
	String topic=myform.getTopic();
	String detail=myform.getDetail();
	String name=myform.getName();
	String email=myform.getEmail();
	String ctzid="23678";  //to be fetched from session
	DbModel db=new DbModel();
	Date d=new Date();
	String tempdate=d.toString();

	try {
		String str="insert into ELITE.FORUM_QUESTION(topic,detail,ctzid,name,email,timestamp,nview,reply) values ('"+topic+"','"+detail+"',"+ctzid+",'"+name+"','"+email+"','"+tempdate+"',0,0)";
	    db.executeDML(str);

	} catch (Exception e) {
		e.printStackTrace();
		System.out.print(e);
	    // Report the error using the appropriate name and ID.
	   // errors.add("name", new ActionMessage("id"));

	}


	db.close();
	// Finish with
	return mapping.findForward("questionposted");

    }
}
