package elites.actions;

import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class AppLoadDistrictAction extends Action
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
				  String query="select dname from ELITE.RTOD";
				  rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='500' border='0'><tr height='35'><td>Select a District :</td><td><select name='district'>";
		  			if(rs.next()==false)
		  			{
		  			responseText=responseText+"<option value='N/A'>No district available</option>";
		  			}
		  		if(rs.previous()){}
		  		while(rs.next())
		  			{
		  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='checkcircle(this.value)'>"+rs.getString(1)+"</option>";
		  		
		  			}
		  	
		  		responseText=responseText+"</select></td></tr>";
		  		out.print(responseText);
			  }
			  
		  		  		
			  else if(status.equals("3")||status.equals("4"))
		  		{	
		  			String query="select dname from ELITE.RTOD where rname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='500' border='0'><tr height='35'><td>Select a District :</td><td><select name='district'>";
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
		  			String query="select dname from ELITE.RTOD where rname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='500' border='0'><tr height='35'><td>Select a District :</td><td><select name='district'>";
		  			if(rs.next()==false)
			  		{
			  			responseText=responseText+"<option value='N/A'>No District available</option>";
			  		}
			  		if(rs.previous()){}
			  		while(rs.next())
			  		{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='checkcircle(this.value)'>"+rs.getString(1)+"</option>";
			  		
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