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
public class Pollform extends ActionForm

{

	private String question=null;
	private String email=null;
	private String name=null;
	private String op1=null;
	private String op2=null;
	private String op3=null;
	private String op4=null;
	private String des=null;
	
	public void setdes(String des)
	{
		this.des=des;
	}
	public String getdes()
	{
		return this.des;
	}
	public void setquestion(String question)
	{
		this.question=question;
	}
	public String getquestion()
	{
		return this.question;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public String getemail()
	{
		return this.email;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return this.name;
	}
	public void setop1(String op1)
	{
		this.op1=op1;
	}
	public String getop1()
	{
		return this.op1;
	}
	public void setop2(String op2)
	{
		this.op2=op2;
	}
	public String getop2()
	{
		return this.op2;
	}
	public void setop3(String op3)
	{
		this.op3=op3;
	}
	public String getop3()
	{
		return this.op3;
	}
	public void setop4(String op4)
	{
		this.op4=op4;
	}
	public String getop4()
	{
		return this.op4;
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
