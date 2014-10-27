package elites.actions;

import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class AppLoadPsAction extends Action
{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		String name=request.getParameter("u");

		PrintWriter out=response.getWriter();
		ResultSet rs;
		String responseText=new String("");
		  try
		  	{
		  		
			  DbModel db= new DbModel();
		  		  		
			
		  			
		  			String query="select distinct pname from ELITE.DCPA where cname='"+name+"'";
		  			rs=db.executeQuery(query);
		  			responseText=responseText+"<table width='490' border='0'><tr height='35'><td>Select a Police Station :</td><td><select name='psname'>";
		  			if(rs.next()==false)
			  			{
			  			responseText=responseText+"<option value='N/A'>No police station available</option>";
			  			}
			  		if(rs.previous()){}
			  		while(rs.next())
			  			{
			  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='checkifdeptt()'>"+rs.getString(1)+"</option>";
			  		
			  			}
			  	
			  		responseText=responseText+"</select></td></tr>";
			  		out.print(responseText);
		  		}
	catch(Exception e)
	{e.printStackTrace();
		out.print("exc");
	}
	return null;
		  		}
}