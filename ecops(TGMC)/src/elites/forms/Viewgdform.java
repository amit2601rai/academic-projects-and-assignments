package elites.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class Viewgdform extends ActionForm

{

   private String ps=null;
   public void setps(String ps)
   {
	   this.ps=ps;
   }
   public String getps()
   {
	   return this.ps;
   }
}