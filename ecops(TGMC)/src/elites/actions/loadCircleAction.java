package elites.actions;
import java.io.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class loadCircleAction extends Action
{
	public ActionForward execute(
		    ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws Exception{
		String name=request.getParameter("c");
		PrintWriter out=response.getWriter();
		ResultSet rs;
		
		String responseText=new String("");
		  try
		  	{
		  		DbModel db= new DbModel();
		  	
		  		String query="select cname from ELITE.DTOC where dname='"+name+"'";
		  		//String query="select cname from ELITE.DTOC";
		  		rs=db.executeQuery(query);
		  		
		  		responseText=responseText+"<select name='circle'>";
		  		if(rs.next()==false)
		  		{
		  			responseText=responseText+"<option value='N/A'>No circle available</option>";
		  		}
		  		if(rs.previous()){}
		  		while(rs.next())
		  		{
		  			responseText=responseText+"<option value='"+rs.getString(1)+"' onclick='check(this.value,4)'>"+rs.getString(1)+"</option>";
		  		
		  		}
		  		responseText=responseText+"</select>";
		  		
		  		out.print(responseText);
	}
		  catch(Exception e)
		  {out.print("here1");}
	return null;
}
}