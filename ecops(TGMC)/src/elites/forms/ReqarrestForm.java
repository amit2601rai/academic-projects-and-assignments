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
public class ReqarrestForm extends ActionForm
{  
  
  private String firno=null;
   private String whom=null;
    private String reason=null;
  
    private String courtno=null;


   public void setfirno(String firno){
	  this.firno=firno;
 }

   public String getfirno(){
	  return this.firno;
 }
public void setcourtno(String courtno){
				this.courtno=courtno;
			 }

			 public String getcourtno(){
				return this.courtno;
			 }
	public void setwhom(String whom){
	  this.whom=whom;
 }

   public String getwhom(){
	  return this.whom;
 }

public void setreason(String reason){
				this.reason=reason;
			 }
public String getreason(){
				return this.reason;
			 }
   
	
	
	

    public void reset(ActionMapping mapping, HttpServletRequest request) {

	// Reset field values here.

    }

    public ActionErrors validate(ActionMapping mapping,
	    HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	// Validate the fields in your form, adding
	// adding each error to this.errors as found, e.g.

	// if ((field == null) || (field.length() == 0)) {
	//   errors.add("field", new org.apache.struts.action.ActionError("error.field.required"));
	// }
	return errors;

    }
}
