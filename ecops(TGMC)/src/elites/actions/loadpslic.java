package elites.actions;
import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class loadpslic extends Action
{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		String temp_circle=request.getParameter("c");
		String temp_district=request.getParameter("d");
		//String temp_ps=request.getParameter("ps");
		PrintWriter out=response.getWriter();
		ResultSet rs;
		ResultSet rs1;
		int i=0;
		
		
		String responseText=new String("");
		  try
		  	{
		  		DbModel db= new DbModel();
		  	
		  		String query="select distinct pname from ELITE.DCPA where dname='"+temp_district+"'and cname='"+temp_circle+"'";
		  		String query1="select count(aname) from ELITE.DCPA where dname='"+temp_district+"'and cname='"+temp_circle+"'";
		  		//String query="select cname from ELITE.DTOC";
		  		rs=db.executeQuery(query);
		  		//rs1=db.executeQuery(query1);
		  		
		  		responseText=responseText+"<select name='ps'>";
		  		if(rs.next()==false)
		  		{
		  			responseText=responseText+"<option value='N/A'>No police station available</option>";
		  		}
		  		if(rs.previous()){}
		  		while(rs.next())
		  		{
		  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='check(this.value,6)'>"+rs.getString(1)+"</option>";
		  		
		  		}
		  		responseText=responseText+"</select>";
		  	
		  		out.print(responseText);
	}
		  catch(Exception e)
		  {System.out.print("here1");}
	return null;
}
}