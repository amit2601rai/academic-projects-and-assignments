package elites.actions;
import elites.model.*;
import elites.forms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.sql.*;
import java.io.*;

/**
 * @version 	1.0
 * @author
 */
public class Viewcriminalaction extends Action

{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception 
  {     
    	
	       
    	    	 viewform sform =(viewform) form;
                     String t1=sform.getcircle();
                     String t2=sform.getcity();
                     String t3=sform.getps();
                     String t4=sform.getzone();
                     String t5=sform.getrange();
                     String t6=sform.gethid();
                System.out.println(t2+t3);
                System.out.println(t1+t4+t5+t6);
                     request.setAttribute("circle",t1);
                     request.setAttribute("city",t2);
                     request.setAttribute("ps",t3);
                     request.setAttribute("zone",t4);
                     request.setAttribute("range",t5);                                                  
                    
                    
                  
                    if(t6.equals("p"))
                    return mapping.findForward("s1");
                    if(t6.equals("d"))
                    return mapping.findForward("s2");
                    if(t6.equals("c")) 
                    return mapping.findForward("s3");
                    if(t6.equals("r"))
                    return mapping.findForward("s4");
                    if(t6.equals("z"))
                    return mapping.findForward("s5");
                    
                     
                     
                     
                  
          return null;
 }

}
