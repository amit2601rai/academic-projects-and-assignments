package elites.actions;
import elites.forms.*;
import elites.model.*;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * @version 	1.0
 * @author
 */
public class ReqlicenseAction extends Action

{

    public ActionForward execute(ActionMapping mapping, ActionForm form,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

		ReqlicenseForm reqform = (ReqlicenseForm) form;
		String temp_ctzid=reqform.getctzid();
  	    String temp_zname=reqform.getzone();
  	    String temp_rname=reqform.getrange();
  	    String temp_dname=reqform.getdname();
  	    String temp_cname=reqform.getcname();
  	    String temp_pname=reqform.getps();
  	    String temp_aname=reqform.getarea();
  	    String temp_hid=reqform.gethid();
  	    System.out.print(temp_ctzid+temp_zname+temp_rname+temp_dname+temp_cname+temp_pname+temp_aname);
  	    DbModel dm=new DbModel();
  	    ResultSet rs;
  	    System.out.print(temp_hid+"hid");
  	  
   	  if(temp_hid.equals("1"))//impiles it is for arms license
	    {
	    
	    String temp_owner=reqform.getowner();
	    String temp_wno=reqform.getwno();
	    String temp_wname=reqform.getwname();
	    String temp_wmodel=reqform.getwmodel();
	    String temp_refno="";
	    System.out.print("in arms");
	   // System.out.print(temp_ctzid+temp_zname+temp_rname+temp_dname+temp_cname+temp_pname+temp_aname+temp_reason+temp_poo+temp_mmtype+temp_stime+temp_etime+temp_tnop);
	    
	    try{
	    	
	    	String query="insert into ELITE.LICENSEARMS (CTZID,ZNAME,RNAME,DNAME,CNAME,PNAME,ANAME,OWNER,WNO,WNAME,WMODEL,VERIFIED,APPROVED) values("+temp_ctzid+",'"+temp_zname+"','"+temp_rname+"','"+temp_dname+"','"+temp_cname+"','"+temp_pname+"','"+temp_aname+"','"+temp_owner+"','"+temp_wno+"','"+temp_wname+"','"+temp_wmodel+"','false','false')"; 
	    	System.out.println("after query declaration"+query);
	  		dm.executeDML(query);
	  		System.out.print("executedarms");
	  		String p="select refno from ELITE.LICENSEARMS where ctzid="+temp_ctzid+"";
	  	    rs=dm.executeQuery(p);
	  	      while(rs.next())
	  	      {temp_refno=rs.getString(1);
	  	        }
	  	    request.setAttribute("refno",temp_refno);
	  		return mapping.findForward("success");
	       }
	    catch(Exception e)
	       {System.out.print(e);
	        }
	    }
  	    
   	  else if(temp_hid.equals("2"))//impiles it is for hotels nd browsing centres
	    {System.out.print("in hbc");
	    
	    String temp_owner=reqform.getowner();
	    String temp_location=reqform.getlocation();
	    String temp_floors=reqform.getfloors();
	    String temp_noemp=reqform.getnoemp();
	    String temp_refno="";
	    
	   // System.out.print(temp_ctzid+temp_zname+temp_rname+temp_dname+temp_cname+temp_pname+temp_aname+temp_reason+temp_poo+temp_mmtype+temp_stime+temp_etime+temp_tnop);
	    
	    try{
	    	
	    	String query="insert into ELITE.LICENSEHBC (CTZID,ZNAME,RNAME,DNAME,CNAME,PNAME,ANAME,OWNER,LOCATION,FLOORS,NOEMP,VERIFIED,APPROVED) values("+temp_ctzid+",'"+temp_zname+"','"+temp_rname+"','"+temp_dname+"','"+temp_cname+"','"+temp_pname+"','"+temp_aname+"','"+temp_owner+"','"+temp_location+"','"+temp_floors+"','"+temp_noemp+"','false','false')"; 
	    	System.out.println("after query declaration"+query);
	  		dm.executeDML(query);
	  		System.out.print("executedhbc");
	  		String p="select refno from ELITE.LICENSEHBC where ctzid="+temp_ctzid+"";
	  	    rs=dm.executeQuery(p);
	  	      while(rs.next())
	  	      {temp_refno=rs.getString(1);
	  	        }
	  	    request.setAttribute("refno",temp_refno);
	  		return mapping.findForward("success");
	       }
	    catch(Exception e)
	       {System.out.print(e);
	        }
	    }
  	    
   	  else if(temp_hid.equals("3"))//impiles it is for loudspeakers
	    {System.out.print("in lds");
	    
	    String temp_owner=reqform.getowner();
	    String temp_location=reqform.getlocation();
	    String temp_stime=reqform.getstime();
	    String temp_etime=reqform.getetime();
	    String temp_reason=reqform.getreason();
	    String temp_refno="";
	    
	   // System.out.print(temp_ctzid+temp_zname+temp_rname+temp_dname+temp_cname+temp_pname+temp_aname+temp_reason+temp_poo+temp_mmtype+temp_stime+temp_etime+temp_tnop);
	    
	    try{
	    	
	    	String query="insert into ELITE.LICENSELDS (CTZID,ZNAME,RNAME,DNAME,CNAME,PNAME,ANAME,OWNER,LOCATION,STIME,ETIME,REASON,VERIFIED,APPROVED) values("+temp_ctzid+",'"+temp_zname+"','"+temp_rname+"','"+temp_dname+"','"+temp_cname+"','"+temp_pname+"','"+temp_aname+"','"+temp_owner+"','"+temp_location+"','"+temp_stime+"','"+temp_etime+"','"+temp_reason+"','false','false')"; 
	    	System.out.println("after query declaration"+query);
	  		dm.executeDML(query);
	  		System.out.print("executedlds");
	  		String p="select refno from ELITE.LICENSELDS where ctzid="+temp_ctzid+"";
	  	    rs=dm.executeQuery(p);
	  	      while(rs.next())
	  	      {temp_refno=rs.getString(1);
	  	        }
	  	    request.setAttribute("refno",temp_refno);
	  		return mapping.findForward("success");
	       }
	    catch(Exception e)
	       {System.out.print(e);
	        }
	    }
  	    
   	  else if(temp_hid.equals("4"))//impiles it is for mass meeting
  	    {System.out.print("in mm");
  	    String temp_reason=reqform.getreason();
  	    String temp_poo=reqform.getpoo();
  	    String temp_mmtype=reqform.getmmtype();
  	    String temp_stime=reqform.getstime();
  	    String temp_etime=reqform.getetime();
  	    String temp_tnop=reqform.gettnop();
  	    String temp_refno="";
  	    System.out.print(temp_ctzid+temp_zname+temp_rname+temp_dname+temp_cname+temp_pname+temp_aname+temp_reason+temp_poo+temp_mmtype+temp_stime+temp_etime+temp_tnop);
  	    
  	    try{
  	    	
  	    	String query="insert into ELITE.LICENSEMASSMEETING (CTZID,ZNAME,RNAME,DNAME,CNAME,PNAME,ANAME,REASON,POO,MMTYPE,STIME,ETIME,TNOP,VERIFIED,APPROVED) values("+temp_ctzid+",'"+temp_zname+"','"+temp_rname+"','"+temp_dname+"','"+temp_cname+"','"+temp_pname+"','"+temp_aname+"','"+temp_reason+"','"+temp_poo+"','"+temp_mmtype+"','"+temp_stime+"','"+temp_etime+"','"+temp_tnop+"','false','false')"; 
  	    	System.out.println("after query declaration"+query);
  	  		dm.executeDML(query);
  	  		System.out.print("executedmm");
  	  		String p="select refno from ELITE.LICENSEMASSMEETING where ctzid="+temp_ctzid+"";
  	  	    rs=dm.executeQuery(p);
  	  	      while(rs.next())
  	  	      {temp_refno=rs.getString(1);
  	  	        }
  	  	    request.setAttribute("refno",temp_refno);
  	  		return mapping.findForward("success");
  	       }
  	    catch(Exception e)
  	       {System.out.print(e);
  	        }
  	    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	ActionMessages errors = new ActionMessages();
	ActionForward forward = new ActionForward(); // return value

	try {

	    // do something here

	} catch (Exception e) {

	    // Report the error using the appropriate name and ID.
	    errors.add("name", new ActionMessage("id"));

	}

	// If a message is required, save the specified key(s)
	// into the request for use by the <struts:errors> tag.

	if (!errors.isEmpty()) {
	    saveErrors(request, errors);

	    // Forward control to the appropriate 'failure' URI (change name as desired)
	    //	forward = mapping.findForward("failure");

	} else {

	    // Forward control to the appropriate 'success' URI (change name as desired)
	    // forward = mapping.findForward("success");

	}

	// Finish with
	return (forward);

    }
}
