package elites.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import elites.forms.*;
import org.apache.struts.upload.FormFile;
import java.io.*;
import elites.model.*;
import java.sql.*;
/**
 * @version 	1.0
 * @author
 */
public class PhotouploadAction extends Action
{
  public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{
	  
	  String spr="";
	  HttpSession hs=request.getSession();
      spr=(String)hs.getAttribute("copid");
      String tem_id=spr.substring(0,2);
    UploadForm myForm = (UploadForm)form;
    System.out.print("11");
        // Process the FormFile
        FormFile myFile = myForm.getTheFile();
        String contentType = myFile.getContentType();
        String fileName    = myFile.getFileName();
        System.out.print("middle");
        int fileSize       = myFile.getFileSize();
        byte[] fileData    = myFile.getFileData();
        System.out.print("22");
    System.out.println("contentType: " + contentType);
    System.out.println("File Name: " + fileName);
    System.out.println("File Size: " + fileSize);
    String filePath = getServlet().getServletContext().getRealPath("/") +"/upload";
    System.out.print("33");
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
    try{
    	 DbModel db=new DbModel();
    	
       	String str="upload/"+fileName;
     	String str1="update ELITE.COP_DETAILS set link='"+str+"' where copid='"+spr+"'";
     	db.executeDML(str1);
    
     	
    }
    	catch(Exception e)
    	{System.out.print("in catch");}
    
   // request.setAttribute("fileName",fileName);
      return mapping.findForward("tojsp");
    
  }
    
    
}