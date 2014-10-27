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
public class Pollanswerform extends ActionForm

{

    private String id=null;
    private String op=null;
    
    public void setid(String id){
  	  this.id=id;
   }

     public String getid(){
  	  return this.id;
   }
     
     public void setop(String op){
   	  this.op=op;
    }

      public String getop(){
   	  return this.op;
    }
}
