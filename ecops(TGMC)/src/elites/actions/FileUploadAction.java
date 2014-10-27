package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import elites.forms.*;
import org.apache.struts.upload.FormFile;
import java.io.*;
/**
 * @version 	1.0
 * @author
 */
public class FileUploadAction extends Action
{
  public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{
    UploadForm myForm = (UploadForm)form;

        // Process the FormFile
        FormFile myFile = myForm.getTheFile();
        String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        int fileSize       = myFile.getFileSize();
        byte[] fileData    = myFile.getFileData();
    System.out.println("contentType: " + contentType);
    System.out.println("File Name: " + fileName);
    System.out.println("File Size: " + fileSize);
    String filePath = getServlet().getServletContext().getRealPath("/") +"/upload";
    /* Save file on the server */
    if(!fileName.equals("")){  
        System.out.println("Server path:" +filePath);
        //Create file
        File fileToCreate = new File(filePath, fileName);
        //If file does not exists create file                      
        if(!fileToCreate.exists()){
          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
          fileOutStream.write(myFile.getFileData());
          fileOutStream.flush();
          fileOutStream.close();
        }
    }
    request.setAttribute("fileName",fileName);
      return mapping.findForward("success1");
    
  }
    
    
}