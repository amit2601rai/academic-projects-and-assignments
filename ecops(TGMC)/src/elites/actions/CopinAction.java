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
public class CopinAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	try{
    	DbModel dm=new DbModel();
    	String firno=request.getParameter("firno");
    	System.out.print(firno);
    	String str="select * from ELITE.FIR where fir_no="+firno;
    	ResultSet rs=dm.executeQuery(str);
    	System.out.print("After resultset");
    	String detail="";
    	if(rs.next())
    	{
    		System.out.print("inside next");
    	}
    	int cno=rs.getInt(2);
    	System.out.print(cno);
    	String str1="select * from ELITE.COMPLAINT where c_no="+cno;
    	ResultSet rs1=dm.executeQuery(str1);
    	if(rs1.next())
    	{
    		System.out.print("inside rs1");
     	}
    	detail="Lodger Id :"+rs1.getString(3)+" .Date and Time of Crime : "+rs1.getString(9)+" and "+rs1.getString(4);
    	System.out.print("111");
    	detail=detail+"Crime :"+rs1.getString(8)+" Crime details are "+rs1.getString(5);
    	System.out.print("222");
    	detail=detail+" concerned department is "+rs.getString(4)+" timestamp of fir lodging was "+rs.getString(3)+" type of crime :"+rs.getString(5);
    	request.setAttribute("detail",detail);
    	request.setAttribute("firno",firno);
    	request.setAttribute("psno",rs1.getString(2));
    	}
    	catch(Exception e)
    	{
    		System.out.print(e);
    		e.printStackTrace();
    	}
    	return mapping.findForward("allotapo");
    	}
    }