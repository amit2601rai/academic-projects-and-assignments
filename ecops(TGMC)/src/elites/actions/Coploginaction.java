package elites.actions;
import java.sql.*;

import elites.model.*;
import elites.forms.*;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.*;



/**
 * @version 	1.0
 * @author
 */
public class Coploginaction extends Action
         {
             public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	         {
          Coploginform login = (Coploginform) form;
  	      String temp_id=null;
          String temp_pd=null;
  	      String temp_copid=login.getcopid();
  	      String temp_pwd=login.getpwd();
  	      String tem_id=temp_copid.substring(0,2);
  	      String role="cop";
  	      HttpSession session = request.getSession();
  	      session.setAttribute("copid", temp_copid);
  	
  	    try{
  	      DbModel coplogin=new DbModel();/*make object of db2model and call executeQuery method*/
          ResultSet rs=coplogin.executeQuery("select * from ELITE.LOGIN where cop_id='"+temp_copid+"'");    
          System.out.print("After rs");
  	 if(rs.next())
           {  System.out.print("Inside while");
        	        temp_id=rs.getString(1);
                    temp_pd=rs.getString(2);
                
                    if(temp_id.equals(temp_copid)&& temp_pd.equals(temp_pwd))
                     {      
                    	session.setAttribute("copid", temp_copid);
                    	session.setAttribute("role", role);
                	  if(tem_id.equals("01"))
                          return mapping.findForward("dgp");
                       if(tem_id.equals("02"))
                          return mapping.findForward("adgp");
                       if(tem_id.equals("03"))
                          return mapping.findForward("igp");
                       if(tem_id.equals("04"))
                          return mapping.findForward("dig");
                       if(tem_id.equals("05"))
                          return mapping.findForward("sp");
                       if(tem_id.equals("06"))
                          return mapping.findForward("asp");
                       if(tem_id.equals("07"))
                          return mapping.findForward("co");
                       if(tem_id.equals("08"))
                          return mapping.findForward("i");
                       if(tem_id.equals("09"))
                          return mapping.findForward("si");
                       if(tem_id.equals("10"))
                          return mapping.findForward("hc");
                       if(tem_id.equals("11"))
                          return mapping.findForward("c");
              	     }
                  else 
                	  {
                	   if(temp_id.equals(temp_copid)) 
                         return mapping.findForward("failure1");
                      }   
            }
  	 }
  	 catch(Exception e){System.out.print("in catch");}
  	 return mapping.findForward("failure2");
	         }
         }     
         