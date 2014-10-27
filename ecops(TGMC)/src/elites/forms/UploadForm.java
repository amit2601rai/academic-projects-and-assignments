package elites.forms;

import javax.servlet.http.HttpServletRequest;


/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */


	import org.apache.struts.action.*;
	import org.apache.struts.upload.FormFile;



	/**
	* @author Deepak Kumar
	* @Web http://www.roseindia.net
	* @Email roseindia_net@yahoo.com
	*/

	/**
	 * Form bean for Struts File Upload.
	 *
	*/
	public class UploadForm extends ActionForm
	{
	  private FormFile theFile;

	  /**
	   * @return Returns the theFile.
	   */
	  public FormFile getTheFile() {
	    return theFile;
	  }
	  /**
	   * @param theFile The FormFile to set.
	   */
	  public void setTheFile(FormFile theFile) {
	    this.theFile = theFile;
	  }
	}