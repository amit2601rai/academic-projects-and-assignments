package elites.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;


public class viewform extends ActionForm
{
	 
	private static final long serialVersionUID = 1L;
	private String city=null;
      private String ps=null;
      private String zone=null;
      private String range=null;
      private String circle=null;
      private String hid=null;
     


	
	 public void setcity(String city){
		this.city=city;
	  }

	  public String getcity(){
		return this.city;
	  }
	  

	  public void setps(String ps){
			this.ps=ps;
		  }

		  public String getps(){
			return this.ps;
		  }
		  
		  public void setzone(String zone){
				this.zone=zone;
			  }

			  public String getzone(){
				return this.zone;
			  }
			  

			  public void setrange(String range){
					this.range=range;
				  }

				  public String getrange(){
					return this.range;
				  }
		  
				  public void setcircle(String circle){
						this.circle=circle;
					  }

					  public String getcircle(){
						return this.circle;
					  }
			  	  
					  public void sethid(String hid){
							this.hid=hid;
						  }

						  public String gethid(){
							return this.hid;
						  }
						  

						
   public void reset(ActionMapping mapping,HttpServletRequest request){
	  
	  

	  this.ps=null;
	  this.city=null;
	  this.circle=null;
	  this.range=null;
	  this.zone=null;
	  this.hid=null;}
	  
}