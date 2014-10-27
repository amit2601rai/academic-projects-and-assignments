package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.ws.websvcs.transport.policyset.jaxb.All;

import java.util.*;
import elites.forms.*;
import java.io.*;
/**
 * @version 	1.0
 * @author
 */
public class CreatepsAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	
    	 PrintWriter out=response.getWriter();
    Createpsform iform=(Createpsform)form;
	try {
			int i;
			
			 out.print("hi");
		String temp_dis=iform.getdistrict();
		out.print(temp_dis);
		  String temp_cir=iform.getcircle();
		  String temp_ps=iform.getpsname();
		 // String options[]=iform.getarea();
		  /*
		  for(i=0;i<options.length;i++)
		  out.print(options[i]);
		  out.print("here");
		  */
		  ArrayList al = new ArrayList();
		  al = iform.getarea();
		  al.toString();
		  out.print(al);
	} 
	catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	e.printStackTrace();
		
		 out.print("hereexc");
	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	
	// Finish with
	return null;

    }
}
