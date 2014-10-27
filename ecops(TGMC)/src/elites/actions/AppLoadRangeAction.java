package elites.actions;

import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class AppLoadRangeAction extends Action
{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		String name=request.getParameter("u");
		String status=request.getParameter("st");
		PrintWriter out=response.getWriter();
		ResultSet rs;
		String responseText=new String("");
		  try
		  	{
		  		
			  DbModel db= new DbModel();
		  		if(status.equals("1"))
		  		{	
		  			out.print(responseText);
		  		}
		  		
		  
		  		else if(status.equals("2"))
		  		{	
		  			String query="select rname from ELITE.ZTOR where zname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='560' border='0'><tr height='35'><td>Select a Range :</td><td><select name='range'>";
		  			if(rs.next()==false)
			  			{
			  			responseText=responseText+"<option value='N/A'>No range available</option>";
			  			}
			  		if(rs.previous()){}
			  		while(rs.next())
			  			{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
			  		
			  			}
			  	
			  		responseText=responseText+"</select></td></tr>";
			  		out.print(responseText);
			  		
		  		}
		  		
		  		
		  		else
		  		{	
		  			String query="select rname from ELITE.ZTOR where zname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='560' border='0'><tr height='35'><td>Select a Range :</td><td><select name='range'>";
		  			if(rs.next()==false)
			  		{
			  			responseText=responseText+"<option value='N/A'>No range available</option>";
			  		}
			  		if(rs.previous()){}
			  		while(rs.next())
			  		{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='checkdistrict(this.value)'>"+rs.getString(1)+"</option>";
			  		
			  		}
			  	
			  		responseText=responseText+"</select></td></tr>";
			  		
			  		out.print(responseText);
		  		}
		  		
		  	
		  		}
	catch(Exception e)
	{e.printStackTrace();
		out.print("exc");
	}
	return null;
		  		}
}