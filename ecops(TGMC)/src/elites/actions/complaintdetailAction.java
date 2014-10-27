package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
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
public class complaintdetailAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    try{
    	HttpSession hs=request.getSession();
    	DbModel db=new DbModel();
    	System.out.print("yahan tak sahi hai1");
    	String compno=request.getParameter("cno");
    	String detail="";
    	System.out.print("yahan tak sahi hai");
    	String copid="1112345";
    	ResultSet rs1,rs2,rs3,rs4;
    	String psname="";
    	String circle="";
    	String district="";
    	/*System.out.print("12345");
    	String query1="xquery for $y in db2-fn:sqlquery('select copinfo from ELITE.COP_DETAILS where copid=''"+copid+"''"+" ')/cop return $y/posting/psname/text()";
    	rs1=xm.executeQuery(query1);
    	while(rs1.next())
    	{
    		psname=rs1.getString(1);
    	}
    	String query2="xquery for $y in db2-fn:sqlquery('select copinfo from ELITE.COP_DETAILS where copid=''"+copid+"''"+" ')/cop return $y/posting/circle/text()";
    	rs2=xm.executeQuery(query2);
    	while(rs2.next())
    	{
    		circle=rs2.getString(1);
    	}
    	System.out.println(psname+circle);*/
    	String psno=(String)hs.getAttribute("psno");   //to be fetched from session
    	String query="select * from ELITE.COMPLAINT where c_no="+compno+" and ps_no="+psno;
    	rs1=db.executeQuery(query);
    	if(rs1.next())
    	{
    		
    	}
    	System.out.print("111");
    	String query1="select * from ELITE.PSDET where ps_no="+psno;
    	rs2=db.executeQuery(query1);
    	System.out.print("222");
    	if(rs2.next())
    	{
    		psname=rs2.getString(2);
    		circle=rs2.getString(3);
    		district=rs2.getString(4);
    	}
    	System.out.print("333");
    	String lodgerid=rs1.getString(3);
    	String time=rs1.getString(4);
    	String details=rs1.getString(5);
    	String filingtime=rs1.getString(6);
    	String typeocr=rs1.getString(8);
    	String date=rs1.getString(9);
    	String ip=rs1.getString(10);
    	System.out.print("444");
    	String victim="";
    	String query2="select * from ELITE.VICTIM where c_no="+compno;
    	rs3=db.executeQuery(query2);
    	while(rs3.next())
    	{
    		victim=victim+rs3.getString(3)+"having citzen id : "+rs3.getString(2)+",";
    	}
    	String criminal="";
    	String query3="select * from ELITE.SUSPECTED where c_no="+compno;
    	rs4=db.executeQuery(query3);
    	while(rs4.next())
    	{
    		criminal=criminal+rs4.getString(2)+"having particulars as: "+rs4.getString(3)+",";
    	}
    	System.out.print("555");
    	detail=detail+"A new complaint has been lodged by "+lodgerid+" from ip address "+ip+".\nA "+typeocr+" took place in district "+district;
    	detail=detail+",circle : "+circle+"under police station :"+psname+"on date "+date+" and time "+time+".\nThis complaint was";
    	detail=detail+"filed on"+filingtime+".\nVictims affected are"+victim+".The additional details are as follows :\n"+details;
    	detail=detail+"\nSuspected criminals are "+criminal;
    	System.out.print(detail);
    	request.setAttribute("detail",detail);
    	request.setAttribute("compno",compno);
    }
    catch(Exception e)
    {	e.printStackTrace();
    	System.out.print(e);
    }
    
    return mapping.findForward("showdetail");
    }
}