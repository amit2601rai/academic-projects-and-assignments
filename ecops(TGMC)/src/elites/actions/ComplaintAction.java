package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import java.io.*;
import elites.model.*;
import java.io.*;
import java.sql.*;
import java.util.Date;

import elites.forms.*
;/**
 * @version 	1.0
 * @author
 */
public class ComplaintAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int i;
    	Connection con;
    	Statement st;
    	String comp_name="";
     	PrintWriter out=response.getWriter();
    	Complaintform newform=(Complaintform)form; 
    	String crime=newform.getcrime();
    	String dd=newform.getdd();
    	String mm=newform.getmm();
    	String yyyy=newform.getyyyy();
    	String hh=newform.gethh();
    	String min=newform.getmin();
    	String details=newform.getdetails();
    	String district=newform.getdistrict();
    	String circle=newform.getcircle();
    	String cr=request.getParameter("cr");
    	String[] vicid=request.getParameterValues("victimid");
    	String[] vicname=request.getParameterValues("victimname");
    	String[] criminalname=request.getParameterValues("criminal");
    	String[] crdetails=request.getParameterValues("crdetails");
    	String time="";
    	String date="";
    	String ip=request.getRemoteAddr();
    	out.print(ip);
    	date=dd+"/"+mm+"/"+yyyy;
    	time=hh+"/"+min;
    	ResultSet rs2;
    	ResultSet rs3;
    	Date d=new Date();
    	String tempdate=d.toString();
    	System.out.print(tempdate);
   	try{

    		DbModel db= new DbModel();
    		String str3="select ps_no from ELITE.PSDET where dname='"+district+"' and cname='"+circle+"'";
    		rs2=db.executeQuery(str3);
    		if(rs2.next()){
    		System.out.print(rs2.getInt(1));}
    		int a=rs2.getInt(1);
    		con=db.getConnection1();
    		st=con.createStatement();
    		System.out.print(time);
    		System.out.print(a);
    		System.out.print(details);
    		System.out.print(crime);
    		System.out.print(date);
    		String str="insert into ELITE.COMPLAINT(ps_no,l_id,timeofcrime,crimedet,filingtime,attended,typeocr,dateocr,ip) values("+a+",23445,'"+time+"','"+details+"','"+tempdate+"','false','"+crime+"','"+date+"','"+ip+"')";
    		if(!st.execute(str))
    		{
    			System.out.print("inside done");
    		}
    		String str5="select c_no from ELITE.COMPLAINT where ps_no="+a+" and l_id=23445 and timeofcrime='"+time+"' and typeocr='"+crime+"'";
    		rs3=db.executeQuery(str5);
    		if(rs3.next());
    		for(i=0;i<vicname.length;i++)
    		{
    			String str4="insert into ELITE.VICTIM values("+rs3.getInt(1)+",'"+vicid[i]+"','"+vicname[i]+"')";
    			db.executeDML(str4);
    		}
    		comp_name=""+rs3.getInt(1);
    		if(cr.equals("unknown"))
    		{
    			String str6="insert into ELITE.SUSPECTED values("+rs3.getInt(1)+",'unknown','unknown')";
        		db.executeDML(str6);
    		}
    		else{
    		for(i=0;i<criminalname.length;i++)
    		{
    		String str6="insert into ELITE.SUSPECTED values("+rs3.getInt(1)+",'"+criminalname[i]+"','"+crdetails[i]+"')";
    		db.executeDML(str6);
    		}
    		}
   	}
   	catch(Exception e)
   	{
   		out.print(e+"in exception");
   	}
   out.print(comp_name);	
   	request.setAttribute("comp_name",comp_name);
	request.setAttribute("ip",ip);
    return mapping.findForward("successful");
  //return null;
    }
}
