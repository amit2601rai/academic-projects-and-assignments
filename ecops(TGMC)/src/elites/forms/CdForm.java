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
public class CdForm extends ActionForm

{   private String siid=null;
    private String psno=null;
    private String firno=null;
    private String pageno=null;
private String invdetails=null;
private String hid=null;

   public void setinvdetails(String invdetails){
	  this.invdetails=invdetails;
 }

   public String getinvdetails(){
	  return this.invdetails;
 }
   public void setfirno(String firno){
	  this.firno=firno;
 }

   public String getfirno(){
	  return this.firno;
 }
   
   public void sethid(String hid){
		  this.hid=hid;
	 }

	   public String gethid(){
		  return this.hid;
	 }
   
public void setpageno(String pageno){
				this.pageno=pageno;
			 }

			 public String getpageno(){
				return this.pageno;
			 }
	public void setsiid(String siid){
	  this.siid=siid;
 }

   public String getsiid(){
	  return this.siid;
 }

public void setpsno(String psno){
				this.psno=psno;
			 }
public String getpsno(){
				return this.psno;
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
