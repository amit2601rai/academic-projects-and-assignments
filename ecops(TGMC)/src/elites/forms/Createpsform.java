package elites.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import java.util.*;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class Createpsform extends ActionForm

{
		private String dname=null;
		private String cname=null;
		private String psname=null;
		private ArrayList list2=null;
  
		public void setdistrict(String dname)
		{
			this.dname=dname;
		}
		public String getdistrict()
		{
			return this.dname;
		}
		public void setcircle(String cname)
		{
			this.cname=cname;
		}
		public String getcircle()
		{
			return this.cname;
		}
		public void setpsname(String psname)
		{
			this.psname=psname;
		}
		public String getpsname()
		{
			return this.psname;
		}
		public void setarea(ArrayList list2)
		{
			this.list2=list2;
		}
		public ArrayList getarea()
		{
			return this.list2;
		}
		
}
  
