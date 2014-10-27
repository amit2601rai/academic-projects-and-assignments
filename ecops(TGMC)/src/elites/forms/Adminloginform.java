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
public class Adminloginform extends ActionForm

{

    private String id=null;
    private String pwd=null;
    
    public void setid(String id)
    {
    	this.id=id;
    }
    public String getid()
    {
    	return this.id;
    }
    
    public void setpwd(String pwd)
    {
    	this.pwd=pwd;
    }
    public String getpwd()
    {
    	return this.pwd;
    }
}
