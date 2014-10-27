package elites.forms;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;


public class Coploginform extends ActionForm
{
	 
      private String copid=null;
      private String pwd=null;

	
	 public void setcopid(String copid){
		this.copid=copid;
	  }

	  public String getcopid(){
		return this.copid;
	  }
	  

	  public void setpwd(String pwd){
			this.pwd=pwd;
		  }

		  public String getpwd(){
			return this.pwd;
		  }
		  
	  public void reset(ActionMapping mapping,HttpServletRequest request){
	  
	  

	  this.copid=null;
	  this.pwd=null;
  }
      
}
