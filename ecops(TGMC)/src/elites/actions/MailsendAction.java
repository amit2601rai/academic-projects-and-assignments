package elites.actions;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import elites.model.*;
import elites.forms.Mailform;

/**
 * @version 	1.0
 * @author
 */
public class MailsendAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	Mailform myform=(Mailform)form;
    	PrintWriter out=response.getWriter();
    	String from=myform.getText1();
    	String to=myform.getText2();
    	String add=myform.getText3();
    	String content=myform.getText4();
    	try{
    	mailmodel mm=new mailmodel();
    	mm.send("localhost",25,"anand@EliteCleats","anand3491@gmail.com","done","reg successful");
    	 System.out.print("successful");		
    	}
    	catch(Exception e)
    	{
    		out.print(e);
    	}
    	
    	return null;
    }
}
