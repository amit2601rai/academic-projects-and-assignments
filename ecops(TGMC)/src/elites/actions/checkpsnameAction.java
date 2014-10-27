package elites.actions;
import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class checkpsnameAction extends Action
{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		String name=request.getParameter("ps");
		PrintWriter out=response.getWriter();
		ResultSet rs;
		String responseText=new String("");
		  try
		  	{
		  		DbModel db= new DbModel();
		  	
		  		String query="select pname from ELITE.DCPA where pname='"+name+"'";
		  		rs=db.executeQuery(query);
		  
		  		
		  		if(rs.next())
		  		{
		  			responseText=responseText+"Police Station name already exists";
		  		}
		  		else
		  		{
		  			responseText=responseText+"Police Station name available";
		  		}
		  		
		  		out.print(responseText);
	}
		  catch(Exception e)
		  {out.print("here1");}
	return null;
}
}