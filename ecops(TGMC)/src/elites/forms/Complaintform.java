package elites.forms;

import org.apache.struts.action.ActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class Complaintform extends ActionForm

{

	private String crime=null;
	private String dd=null;
	private String mm=null;
	private String yyyy=null;
	private String hh=null;
	private String min=null;
	private String details=null;
	private String[] victimname=null;
	private String[] victimid=null;
	private String district=null;
	private String circle=null;
	
	
	public void setcrime(String crime)
	{
		this.crime=crime;
	}
	
	public String getcrime()
	{
		return this.crime;
	}
	
	public void setdd(String dd)
	{
		this.dd=dd;
	}
	
	public String getdd()
	{
		return this.dd;
	}
	
	public void setmm(String mm)
	{
		this.mm=mm;
	}
	
	public String getmm()
	{
		return this.mm;
	}
	
	public void setyyyy(String yyyy)
	{
		this.yyyy=yyyy;
	}
	
	public String getyyyy()
	{
		return this.yyyy;
	}
	
	public void sethh(String hh)
	{
		this.hh=hh;
	}
	
	public String gethh()
	{
		return this.hh;
	}
	
	public void setmin(String min)
	{
		this.min=min;
	}
	
	public String getmin()
	{
		return this.min;
	}
	
	public void setdetails(String details)
	{
		this.details=details;
	}
	
	public String getdetails()
	{
		return this.details;
	}
	
	public void setvicname(String[] victimname)
	{
		this.victimname=victimname;
	}
	
	public String[] getvicname()
	{
		return this.victimname;
	}
	
	public void setvicid(String[] victimid)
	{
		this.victimid=victimid;
	}
	
	public String[] getvicid()
	{
		return this.victimid;
	}
	
	public void setdistrict(String district)
	{
		this.district=district;
	}
	
	public String getdistrict()
	{
		return this.district;
	}
	
	public void setcircle(String circle)
	{
		this.circle=circle;
	}
	
	public String getcircle()
	{
		return this.circle;
	}
}

