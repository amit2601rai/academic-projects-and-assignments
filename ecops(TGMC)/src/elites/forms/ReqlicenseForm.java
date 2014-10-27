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
public class ReqlicenseForm extends ActionForm

{  private String ctzid=null;
   public void setctzid(String ctzid){
	  this.ctzid=ctzid;
    }
   public String getctzid(){
	  return this.ctzid;
    }
	
	private String zone=null;
   public void setzone(String zone){
	  this.zone=zone;
    }
   public String getzone(){
	  return this.zone;
    }
	
	private String range=null;
   public void setrange(String range){
	  this.range=range;
    }
   public String getrange(){
	  return this.range;
    }
	
	private String district=null;
   public void setdname(String district){
	  this.district=district;
    }
   public String getdname(){
	  return this.district;
    }
	
	private String circle=null;
   public void setcname(String circle){
	  this.circle=circle;
    }
   public String getcname(){
	  return this.circle;
    }
	
	private String ps=null;
   public void setps(String ps){
	  this.ps=ps;
    }
   public String getps(){
	  return this.ps;
    }
	
	private String area=null;
   public void setarea(String area){
	  this.area=area;
    }
   public String getarea(){
	  return this.area;
    }
	
	private String reason=null;
   public void setreason(String reason){
	  this.reason=reason;
    }
   public String getreason(){
	  return this.reason;
    }
	
	private String poo=null;
   public void setpoo(String poo){
	  this.poo=poo;
    }
   public String getpoo(){
	  return this.poo;
    }
	
	 private String mmtype=null;
   public void setmmtype(String mmtype){
	  this.mmtype=mmtype;
    }
   public String getmmtype(){
	  return this.mmtype;
    }
	
	private String stime=null;
   public void setstime(String stime){
	  this.stime=stime;
    }
   public String getstime(){
	  return this.stime;
    }
	
	private String etime=null;
   public void setetime(String etime){
	  this.etime=etime;
    }
   public String getetime(){
	  return this.etime;
    }
	
	private String tnop=null;
   public void settnop(String tnop){
	  this.tnop=tnop;
    }
   public String gettnop(){
	  return this.tnop;
    }
   
   private String owner=null;
    

   public void setowner(String owner){
	  this.owner=owner;
 }

   public String getowner(){
	  return this.owner;
 }
    private String location=null;
    

   public void setlocation(String location){
	  this.location=location;
 }

   public String getlocation(){
	  return this.location;
 }	
	
	private String floors=null;
    

   public void setfloors(String floors){
	  this.floors=floors;
 }

   public String getfloors(){
	  return this.floors;
 }
	
	private String noemp=null;
    

   public void setnoemp(String noemp){
	  this.noemp=noemp;
 }

   public String getnoemp(){
	  return this.noemp;
 }
 private String wno=null;
    

   public void setwno(String wno){
	  this.wno=wno;
 }

   public String getwno(){
	  return this.wno;
 }
 
 private String wname=null;
    

   public void setwname(String wname){
	  this.wname=wname;
 }

   public String getwname(){
	  return this.wname;
 }
 
 private String wmodel=null;
    

   public void setwmodel(String wmodel){
	  this.wmodel=wmodel;
 }

   public String getwmodel(){
	  return this.wmodel;
 }
 
  private String hid=null;
    

   public void sethid(String hid){
	  this.hid=hid;
 }

   public String gethid(){
	  return this.hid;
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
