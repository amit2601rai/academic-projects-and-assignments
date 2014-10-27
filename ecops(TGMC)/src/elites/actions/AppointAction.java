package elites.actions;
import elites.forms.*;
import elites.model.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

public class AppointAction extends Action
{
  public ActionForward execute(
    ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response) throws Exception{

	  UseValueForm appform = (UseValueForm) form;
	  String temp_rank=appform.getRank();
	  String temp_zone=appform.getZone();
	  String temp_range=appform.getRange();
	  String temp_district=appform.getDistrict();
	  String temp_circle=appform.getCircle();
	  String temp_psname=appform.getPsname();
	  String temp_deptt=appform.getdeptt();
	//  String temp_deptt=appform.getDeptt();
	  String temp_copid=appform.getCopid();
	  String temp_ctzid=appform.getCtzid();
	  String temp_name=appform.getName();
	  boolean validated=false;
	  System.out.print(temp_rank+temp_zone+temp_range+temp_district+temp_circle+temp_psname+temp_copid+temp_ctzid+temp_name);
	  String str=null;
	  
	  /*if(temp_rank=="DGP")
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone></posting></cop>";
	  }
	  else if(temp_rank.equals("ADGP"))
	  {
		str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone></posting></cop>";
	  }*/
	  if(temp_rank.equals("DGP"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank></cop>";  
	  }
	  if(temp_rank.equals("ADGP"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank></cop>";  
	  }
	  if(temp_rank.equals("IG"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone></posting></cop>";  
	  }
	  else if(temp_rank.equals("DIG"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range></posting></cop>";  
	  }
	  else if(temp_rank.equals("SP"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district></posting></cop>";  
	  }
	  else if(temp_rank.equals("ASP"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district></posting></cop>";  
	  }
	  else if(temp_rank.equals("CO"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle></posting></cop>";	  
	  }
	  else if(temp_rank.equals("INSPECTOR"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname></posting></cop>";  
	  }
	  
	 //without deptt
	  
	  else if(temp_rank.equals("SUB-INSECTOR"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><deptt>"+temp_deptt+"</deptt></posting></cop>";  
	  }
	  else if(temp_rank.equals("HEAD CONSTABLE"))
	  {
	   str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><deptt>"+temp_deptt+"</deptt></posting></cop>";
	  }
	  else if(temp_rank.equals("CONSTABLE"))
	  {str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><deptt>"+temp_deptt+"</deptt></posting></cop>";                                      
	   }
	  
	  //with deptt
	 
	  /*  else if(temp_rank.equals("SUB-INSECTOR"))
	  {
		  str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><department>"+temp_deptt+"</department></posting></cop>";  
	  }
	  else if(temp_rank.equals("HEAD CONSTABLE"))
	  {
	   str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><department>"+temp_deptt+"</department></posting></cop>";
	  }
	  else if(temp_rank.equals("CONSTABLE"))
	  {str="<cop><ctzid>"+temp_ctzid+"</ctzid><name>"+temp_name+"</name><rank>"+temp_rank+"</rank><posting><zone>"+temp_zone+"</zone><range>"+temp_range+"</range><district>"+temp_district+"</district><circle>"+temp_circle+"</circle><psname>"+temp_psname+"</psname><department>"+temp_deptt+"</department></posting></cop>";                                      
	   }*/
		  
		try{
			DbModel db=new DbModel();
			XmlModel xmlm=new XmlModel();
			String query="insert into ELITE.COP_DETAILS values('"+temp_copid+"','"+str+"','upload/011.jpg')";
			System.out.println("after query declaration");
			xmlm.executeDML(query);
			System.out.println("after execution");
			validated=true;
			String query2="insert into ELITE.LOGIN values('"+temp_copid+"','2222')";
 	         db.executeDML(query2);
            
 		    HttpSession hs =request.getSession();
                    hs.setAttribute("copid",temp_copid);
                    hs.setAttribute("ctzid",temp_ctzid);
                    hs.setAttribute("name",temp_name);
            System.out.println(validated);
			}
		catch(Exception e){System.out.print("in catch");}
		 if (validated)
		  {    
			  return mapping.findForward("success");
		  }
  
		else
		  {
		  return mapping.findForward("failure");
		  }
  }  
}
























