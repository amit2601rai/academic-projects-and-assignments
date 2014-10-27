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
public class Intercoplogin extends Action
         {
             public ActionForward execute(ActionMapping mapping, ActionForm form,
	                     HttpServletRequest request, HttpServletResponse response)
	         throws Exception 
	           {
          	     
            	 String str=null,temp_str=null,temp_xml=null,to_print="";
            	 System.out.print("bffff");
            	 HttpSession session = request.getSession();
            	 String spr="";
                 spr=(String)session.getAttribute("copid");
                 System.out.print("bffffi");

                 String tem_id=spr.substring(0,2);
                 System.out.print(tem_id);

                 String query="select * from ELITE.COPS where COP_ID='"+spr+"'";
            	 System.out.print(query);

            	 
            	 PrintWriter out=response.getWriter();
            //	 HttpSession session = request.getSession();
  	          //   session.setAttribute("copid", temp_copid);
  	  /*    try{ System.out.print("in try bfore");

  	            xmldb2 coplogin=new xmldb2();
  	          System.out.print("model");
              ResultSet rs=coplogin.executeQuery(query );          
              System.out.print("rs");

              while(rs.next())
                 { 
            	  System.out.print("in while");

                    str=rs.getString(1);
                    temp_str="<temp>"+str+"</temp>";
			        temp_xml=rs.getString(2);
			        to_print=to_print+" "+"<x>"+" "+temp_str+" "+temp_xml+" "+"</x>";
			       
                } System.out.print(to_print);

  	        }
  	    catch(Exception e){out.print("catch");}
  	      request.setAttribute("to_print",to_print);  
	*/
	           
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
	           
         return mapping.findForward("c");     
	           
	           }
         }
  	      