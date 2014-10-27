package elites.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import elites.forms.*;
import elites.model.*;

/**
 * @version 	1.0
 * @author
 */
public class AddgdAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
    	AddgdForm appform = (AddgdForm) form;
    	  String temp_srno=appform.getsrno();
    	  String temp_gddetails=appform.getgddetails();
    	  String temp_psno="1";
    	  String temp_copid="420";
    	  	Date d=new Date();
    	  	System.out.print(d);
    	  	String temp_date=d.toString();
    	  	System.out.print(temp_date);
    	  	String temp_sysdate=temp_date.substring(0,10);
    	  	System.out.print(temp_sysdate);
    	  	String temp_systime=temp_date.substring(11,19);
    	  	System.out.print(temp_systime);
        boolean validated=false;
    	  System.out.print(validated);
    	  System.out.print(temp_srno+temp_gddetails);
    	  String str="<gddetails>"+temp_gddetails+"</gddetails>";
    	  System.out.print(str);
    	try{
  		XmlModel xmlm=new XmlModel();
  		String query="insert into ELITE.GENERALDIARY values('"+temp_psno+"','"+temp_copid+"','"+temp_sysdate+"','"+temp_srno+"','"+str+"')";
  		System.out.println("after query declaration"+query);
  		xmlm.executeDML(query);
  		System.out.print("executed");
  		validated=true;
  	         
          
  		  /*  HttpSession hs =request.getSession();
                  hs.setAttribute("copid",temp_copid);
                  hs.setAttribute("ctzid",temp_ctzid);
                  hs.setAttribute("name",temp_name);*/
          System.out.println(validated);
  		}
  	catch(Exception e){System.out.print("in catch");}
  	 if (validated)
  	  {   System.out.print(validated); 
  		  return mapping.findForward("success");
  	  }

  	else
  	  {
  	  return mapping.findForward("failure");
  	  }
  }  




     	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      
      	
      	

  /*	ActionMessages errors = new ActionMessages();
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
  	return (forward);

      }*/
  }