package elites.actions;
import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

public class loadAreaAction extends Action
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
		  	
		  		String query="select aname from ELITE.DCPA where dname='"+temp_district+"'and cname='"+temp_circle+"'";
		  		String query1="select count(aname) from ELITE.DCPA where dname='"+temp_district+"'and cname='"+temp_circle+"'";
		  		//String query="select cname from ELITE.DTOC";
		  		rs=db.executeQuery(query);
		  		//rs1=db.executeQuery(query1);
		  		
		  		responseText=responseText+"<select style='width: 150px' name='list1' multiple size=10   ondblclick='opt.transferRight()'>";
		  		if(rs.next()==false)
		  		{
		  			responseText=responseText+"<option value='N/A'>No Area available</option>";
		  		}
		  		if(rs.previous()){}
		  		while(rs.next())
		  		{
		  			responseText=responseText+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
		  		
		  		}
		  		responseText=responseText+"</select>";
		  			out.print(responseText);
	}
		  catch(Exception e)
		  {out.print("here1");}
	return null;
}
}