package elites.actions;

import elites.model.*;
import elites.forms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.sql.*;
import java.util.Date;

/**
 * @version 	1.0
 * @author
 */
public class AnswerpollAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

    DbModel db=new DbModel();
	Pollanswerform myform=(Pollanswerform)form;
	String op=myform.getop();
	String id=myform.getid();
	String email="anand.raj.jha@gmail.com";  //from session
	String name="anand";  //from session
	String ctz="12345";  //from session
	Date d=new Date();
	String tempdate=d.toString();
	System.out.print(tempdate);
	String str="insert into ELITE.POLL_ANSWER values("+id+",'"+op+"',"+ctz+",'"+name+"','"+email+"','"+tempdate+"')";
	
	try {
		db.executeDML(str);
	    
	} catch (Exception e) {
		
		System.out.print("in catch");	  
		e.printStackTrace();
	}
	request.setAttribute("id",id);
	return mapping.findForward("success");
    }
}

	