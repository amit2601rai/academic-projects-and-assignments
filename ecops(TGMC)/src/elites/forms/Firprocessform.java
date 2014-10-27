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
public class Firprocessform extends ActionForm

{

		private String cno=null;
		private String deptt=null;
		private String cr=null;
		
		public void setCno(String cno)
		{
			this.cno=cno;
		}
		public String getCno()
		{
			return this.cno;
		}
		public void setdeptt(String deptt)
		{
			this.deptt=deptt;
		}
		public String getdeptt()
		{
			return this.deptt;
		}
		public void setcr(String cr)
		{
			this.cr=cr;
		}
		public String getcr()
		{
			return this.cr;
		}
		
		
}