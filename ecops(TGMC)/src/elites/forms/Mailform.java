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
public class Mailform extends ActionForm

{
	private String text1=null;
	private String text2=null;
	private String text3=null;
	private String text4=null;
	
	public void setText1(String text1)
	
	{
		this.text1=text1;
	}
	
    public String getText1()
    {
    	return this.text1;
    }
    
public void setText2(String text2)
	
	{
		this.text2=text2;
	}
    public String getText2()
    {
    	return this.text2;
    }
public void setText3(String text3)
	
	{
		this.text3=text3;
	}
    public String getText3()
    {
    	return this.text3;
    }
public void setText4(String text4)
	
	{
		this.text4=text4;
	}
    public String getText4()
    {
    	return this.text4;
    }
}
