package elites.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class UseValueForm extends ActionForm

{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String copid=null;
    private String ctzid=null;
    private String name=null;
    private String rank=null;
    private String zone=null;
    private String range=null;
    private String district=null;
    private String circle=null;
    private String psname=null;
    private String deptt=null;
    public void setCopid(String copid)
    {
    	this.copid=copid;
    	}
    public String getCopid()
    {
    	return copid;
    }
    public void setCtzid(String ctzid)
    {
    	this.ctzid=ctzid;
    }
    public String getCtzid()
    {
    	return ctzid;
    }
    public void setName(String name)
    {
    	this.name=name;
    }
    public String getName()
    {
    	return name;
    }
    public void setRank(String rank)
    {
    	this.rank=rank;
    }
    public String getRank()
    {
    	return rank;
    }
    public void setZone(String zone)
    {
    	this.zone=zone;
    }
    public String getZone()
    {
    	return zone;
    }
    public void setRange(String range)
    {
    	this.range=range;
    }
    public String getRange()
    {
    	return range;
    }
    public void setDistrict(String district)
    {
    	this.district=district;
    }
    public String getDistrict()
    {
    	return district;
    }
    public void setCircle(String circle)
    {
    	this.circle=circle;
    }
    public String getCircle()
    {
    	return circle;
    }
    public void setPsname(String psname)
    {
    	this.psname=psname;
    }
    public String getPsname()
    {
    	return psname;
    }
    
    public void setdeptt(String deptt)
    {
    	this.deptt=deptt;
    }
    public String getdeptt()
    {
    	return deptt;
    }
    }

  