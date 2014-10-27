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
public class FirprocessAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	ResultSet rs,rs1,rs2,rs3;
	Firprocessform myform=(Firprocessform)form;
	String cno=myform.getCno();
	String cr=myform.getcr();
	String deptt=myform.getdeptt();
	Date d=new Date();
	String tempdate=d.toString();

	DbModel db=new DbModel();
		int i=0,j;
	try{
		
		   String str6="update ELITE.COMPLAINT set attended='true' where c_no="+cno;
		   db.executeDML(str6);
		   System.out.print("hi");
		 
		    String query3="select * from ELITE.SUSPECTED where c_no="+cno;
	    	rs=db.executeQuery(query3);
	    	while(rs.next())
	    	{i++;}
	    String[] acts=new String[i];
	    rs1=db.executeQuery(query3);
	    i=0;
	    while(rs1.next())
	    {
	    	acts[i]=request.getParameter(rs1.getString(2));
	    	   i++;
	    }
	    String str="insert into ELITE.FIR(c_no,timestamp,deptt,typecr,copal) values("+cno+",'"+tempdate+"','"+deptt+"','"+cr+"','N/A')";
	    db.executeDML(str);
	    rs1=db.executeQuery(query3);
	     i=0;
	    while(rs1.next())
	    {System.out.print("hi1");
	    String str2="insert into ELITE.SUSFINAL values("+rs1.getInt(1)+",'"+rs1.getString(2)+"','"+rs1.getString(3)+"','"+acts[i]+"')";
	    db.executeDML(str2);
	    i++;
	    }
	    String str3="select fir_no from ELITE.FIR where c_no="+cno;
	    rs2=db.executeQuery(str3);
	    String firno="";
	    if(rs2.next())
	    {
	    	firno=rs2.getString(1);
	    }
	    String str5="select * from ELITE.VICTIM where c_no="+cno;
	   rs3=db.executeQuery(str5);
	   while(rs3.next())
	   {
	    String str4="insert into ELITE.VICTIMFINAL values("+firno+",'"+rs3.getString(2)+"','"+rs3.getString(3)+"')";
	    db.executeDML(str4);
	   }
	 
	    System.out.print("done");
	}
	catch(Exception e)
	{	e.printStackTrace();
		System.out.print(e);
	}
	return mapping.findForward("success");
    }
}