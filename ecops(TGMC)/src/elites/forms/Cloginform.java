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
public class Cloginform extends ActionForm

{
		private String cid=null;
		private String pwd=null;
		
		 public void setcid(String cid){
			  this.cid=cid;
		 }

		   public String getcid(){
			  return this.cid;
		 }

		   public void setpwd(String pwd){
				  this.pwd=pwd;
			 }

			   public String getpwd(){
				  return this.pwd;
			 }
    
}
