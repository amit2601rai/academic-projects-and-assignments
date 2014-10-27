package elites.actions;
import java.sql.*;

import elites.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * @version 	1.0
 * @author
 */
public class ApprovalAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	
    	try{
    		String query="";String query2="";String query3="";String query4="";String temp_licno="";String temp_ctzid="";
        	String temp_refno=request.getParameter("refno");
        	String temp_cat=request.getParameter("cat");
        	System.out.print(temp_refno+temp_cat);
        	DbModel dm=new DbModel();
        	ResultSet rs,rs2;
        	
        	if(temp_cat.equals("arms"))
        	 { query="update ELITE.LICENSEARMS set approved='true' where refno="+temp_refno;
        	   query2="insert into ELITE.ARMSLICENSE (refno) values ("+temp_refno+")";
        	   query3="select licenseno from ELITE.ARMSLICENSE where refno="+temp_refno+"";
         	   query4="select ctzid from ELITE.LICENSEARMS where refno="+temp_refno+"";
         	
        	 }
        	else if(temp_cat.equals("hbc"))
        	{ query="update ELITE.LICENSEHBC set approved='true' where refno="+temp_refno;
        	  query2="insert into ELITE.HBCLICENSE (refno) values ("+temp_refno+")";
        	  query3="select licenseno from ELITE.HBCLICENSE where refno="+temp_refno+"";
        	  query4="select ctzid from ELITE.LICENSEHBC where refno="+temp_refno+"";
        	
        	}
        	else if(temp_cat.equals("lds"))
        	{	 query="update ELITE.LICENSELDS set approved='true' where refno="+temp_refno;
        	     query2="insert into ELITE.LDSLICENSE (refno) values ("+temp_refno+")";
        	     query3="select licenseno from ELITE.LDSLICENSE where refno="+temp_refno+"";
           	     query4="select ctzid from ELITE.LICENSELDS where refno="+temp_refno+"";
           	
        	}
        	else if(temp_cat.equals("mm"))
        	{ query="update ELITE.LICENSEMASSMEETING set approved='true' where refno="+temp_refno;
        	  query2="insert into ELITE.MASSMEETINGLICENSE (refno) values ("+temp_refno+")";
        	  query3="select licenseno from ELITE.MASSMEETINGLICENSE where refno="+temp_refno+"";
        	  query4="select ctzid from ELITE.LICENSEMASSMEETING where refno="+temp_refno+"";
        	}
        	
        	
       	//approval action of the verified license
    	  dm.executeDML(query);
    	
    	
    	//now license no generation
    	 dm.executeDML(query2);//insertion into main license table
	  	 rs=dm.executeQuery(query3);//retrieval of license no
	  	 while(rs.next())
	  	  {temp_licno=rs.getString(1);
	  	  }
	  	
	  	//extracting citizen id corresponding to the approved license request sender
	  	  rs2=dm.executeQuery(query4);
	  	  while(rs2.next())
	  	  {temp_ctzid=rs2.getString(1);
	  	  } 
	  	
	  	//now sending mail(accepted)to the citizen who requested this license
	  	System.out.println(temp_ctzid);
	  	System.out.println(temp_licno);
	  	
    	}
    	catch(Exception e)
    	{System.out.print(e);}
    	//now sending mail(approved) to the citizen who requested this license
	  	//MAIL SENDING MODULE
    	return mapping.findForward("successfullyapproved");
    	
    	   /*	
    	ActionMessages errors = new ActionMessages();
	ActionForward forward = new ActionForward(); // return value

	try {

	    // do something here

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("name", new ActionMessage("id"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);

	    // Forward control to the appropriate 'failure' URI (change name as desired)
	    //	forward = mapping.findForward("failure");

	} else {

	    // Forward control to the appropriate 'success' URI (change name as desired)
	    // forward = mapping.findForward("success");

	}

	// Finish with
	return (forward);*/

    }
}
