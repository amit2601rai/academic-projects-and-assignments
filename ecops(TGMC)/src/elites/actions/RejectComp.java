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
import java.sql.*;

/**
 * @version 	1.0
 * @author
 */
public class RejectComp extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	try{
    	DbModel db=new DbModel();
    	String cno=request.getParameter("cno");
    	String str1="delete from ELITE.COMPLAINT where c_no="+cno;
    	String str2="delete from ELITE.SUSPECTED where c_no="+cno;
    	String str3="delete from ELITE.VICTIM where c_no="+cno;
    	db.executeDML(str1);
    	db.executeDML(str2);
    	db.executeDML(str3);
    	}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	return null;
    }
}