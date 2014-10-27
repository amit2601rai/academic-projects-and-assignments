package elites.actions;

import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class AppLoadCircleAction extends Action
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
		  		  		
			  if(status.equals("5"))
		  		{	
		  			String query="select cname from ELITE.DTOC where dname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='540' border='0'><tr height='35'><td>Select a Circle :</td><td><select name='circle'>";
		  			if(rs.next()==false)
			  			{
			  			responseText=responseText+"<option value='N/A'>No circle available</option>";
			  			}
			  		if(rs.previous()){}
			  		while(rs.next())
			  			{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</option>";
			  		
			  			}
			  	
			  		responseText=responseText+"</select></td></tr>";
			  		out.print(responseText);
			  		
		  		}
			  
			  else if(status.equals("10"))
		  		{	
		  			String query="select distinct cname from ELITE.DTOC where dname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='470' border='0'><tr height='35'><td>Select a Circle :</td><td><select name='circle'>";
		  			if(rs.next()==false)
			  			{
			  			responseText=responseText+"<option value='N/A'>No circle available</option>";
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
		  			String query="select cname from ELITE.DTOC where dname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='470' border='0'><tr height='35'><td>Select a Circle :</td><td><select name='circle'>";
		  			if(rs.next()==false)
			  		{
			  			responseText=responseText+"<option value='N/A'>No Circle available</option>";
			  		}
			  		if(rs.previous()){}
			  		while(rs.next())
			  		{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='checkps(this.value)'>"+rs.getString(1)+"</option>";
			  		
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