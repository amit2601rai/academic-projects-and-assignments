package elites.forms;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;


public class Criminalform extends ActionForm
{
	 
      private String cid=null;
      private String age=null;
      private String area=null;
      private String num=null;
      private String crime=null;
	
	 public void setcid(String cid){
		this.cid=cid;
	  }

	  public String getcid(){
		return this.cid;
	  }
	  

	  public void setage(String age){
			this.age=age;
		  }

		  public String getage(){
			return this.age;
		  }
		  public void setarea(String area){
				this.area=area;
			  }

			  public String getarea (){
				return this.area;
			  }  
	 
			  public void setnum(String num){
					this.num=num;
				  }

				  public String getnum (){
					return this.num;
				  }  
		 
				  public void setcrime(String crime){
						this.crime=crime;
					  }

					  public String getcrime (){
						return this.crime;
					  }  
			  
		  public void reset(ActionMapping mapping,HttpServletRequest request){
	  
	  

	  this.cid=null;
	  this.num=null;
	  this.area=null;
	  this.age=null;
	  this.crime=null;
	 
		  
		  
		  }
      
}
