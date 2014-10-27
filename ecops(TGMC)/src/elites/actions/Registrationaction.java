package elites.actions;
import elites.model.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import elites.forms.*;
/**
 * @version 	1.0
 * @author
 */
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
public class Registrationaction extends Action

{
        public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception 
	    {
        	try{
    	    Registrationform rform =(Registrationform) form;
    	    String t1=rform.getname();
            String t2=rform.getfname();
            String t3=rform.getcity();
            String t4=rform.getps();
            String t5=rform.getarea();
            String t6=rform.getplace();
            String t7=rform.getoccup();
            String t8=rform.getdate();
            String t9=rform.getmonth();
            String t10=rform.getyear();
            String t11=rform.getms();
            String t12=rform.getemail();
            String t13=rform.getphone();
            FormFile t14=rform.getproof();
            FormFile t15=rform.gettheFile();
            String t16=rform.getsex();
	        String t17=t8+"/"+t9+"/"+t10;
	        System.out.print(t12);     
	        System.out.print(t13);   
	        String contentType = t15.getContentType();
	        String fileName    = t15.getFileName();
	        System.out.print("middle");
	        int fileSize       = t15.getFileSize();
	        byte[] fileData    = t15.getFileData();
	        System.out.print("22");
	        String contentType1 = t14.getContentType();
	        String fileName1    = t14.getFileName();
	        System.out.print("middle");
	        int fileSize1       = t14.getFileSize();
	        byte[] fileData1    = t14.getFileData();
	        System.out.print("22");
	    System.out.println("contentType: " + contentType);
	    System.out.println("File Name: " + fileName);
	    System.out.println("File Size: " + fileSize);
	    System.out.println("contentType: " + contentType1);
	    System.out.println("File Name: " + fileName1);
	    System.out.println("File Size: " + fileSize1);
	    String filePath = getServlet().getServletContext().getRealPath("/") +"/upload";
	    System.out.print("33");
	    if(!fileName.equals("")){  
	        System.out.println("Server path:" +filePath);
	        //Create file
	        File fileToCreate = new File(filePath, fileName);
	        //If file does not exists create file                      
	        if(!fileToCreate.exists()){
	          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
	          fileOutStream.write(t15.getFileData());
	          fileOutStream.flush();
	          fileOutStream.close();
	        }
	    }
	    
	    String filePath1 = getServlet().getServletContext().getRealPath("/") +"/upload";
	    System.out.print("33");

	    if(!fileName1.equals("")){  
	        System.out.println("Server path:" +filePath1);
	        //Create file
	        File fileToCreate = new File(filePath1, fileName1);
	        //If file does not exists create file                      
	        if(!fileToCreate.exists()){
	          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
	          fileOutStream.write(t14.getFileData());
	          fileOutStream.flush();
	          fileOutStream.close();
	        }
	    }
	    String str="upload/"+fileName;
	    String str1="upload/"+fileName1;
String t18="<citizen><name>"+t1+"</name><fname>"+t2+"</fname><address><city>"+t3+"</city><ps>"+t4+"</ps><area>"+t5+"</area><place>"+t6+"</place></address><occupation>"+t7+"</occupation><dob>"+t17+"</dob><maritalstatus>"+t11+"</maritalstatus><email>"+t12+"</email><phone>"+t13+"</phone><proof>"+str1+"</proof><photo>"+str+"</photo><sex>"+t16+"</sex></citizen>"; 
System.out.print(t18);     
System.out.print(t12+t13);     

	           //db2model lm=new db2model();
              //String query="insert into ELITE.CITIZEN(INFO,STATUS) values('"+t18+"','0')";
	         //lm.executeDML(query);
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            Connection con= DriverManager.getConnection("jdbc:db2:ECOPS1","R@j","123"); 
            Statement st=con.createStatement();
            String query="insert into ELITE.CITIZEN(INFO,STATUS) values('"+t18+"','0')";
           
            st.executeUpdate(query);
            
            
      }catch(Exception e){System.out.print(e);
      e.printStackTrace();}     
     return mapping.findForward("success");  
      }
 }
