package elites.actions;

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
import elites.forms.*;
import elites.model.*;

/**
 * @version 	1.0
 * @author
 */
public class QuestionpollAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

    	
    	Pollform myform=(Pollform)form;
    	String name=myform.getname();
    	String email=myform.getemail();
    	String op1=myform.getop1();
    	String op2=myform.getop2();
    	String op3=myform.getop3();
    	String op4=myform.getop4();
    	String question=myform.getquestion();
    	String des=myform.getdes();
        HttpSession session = request.getSession();
    	String ctzid=(String)session.getAttribute("cid");
    	System.out.print(name+email+op1+op2+op3+op4+question+des);
    	
 try{
    		
    	DbModel db=new DbModel();
    	Date d=new Date();
    	String tempdate=d.toString();
    	System.out.print(tempdate);
    	String str="insert into ELITE.POLL_QUESTION (QUESTION,DES,OP1,OP2,OP3,OP4,CTZID,NAME,EMAIL,TIME) values ('"+question+"','"+des+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"',"+ctzid+",'"+name+"','"+email+"','"+tempdate+"')";
    	db.executeDML(str);  	
    	System.out.print("111");
    		  	
    	
    	}
    	catch(Exception e)
    	{
    		System.out.print(e);
    		e.printStackTrace();
    	}
    	
	

	
	return mapping.findForward("pollposted");

    }
}
