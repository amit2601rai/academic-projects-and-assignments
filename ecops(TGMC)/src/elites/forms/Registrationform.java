package elites.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;


public class Registrationform extends ActionForm
{
	 

	  private String name=null;
      private String fname=null;
      private String city=null;
      private String ps=null;
      private String area=null;
      private String place=null;
      private String occup=null;
      private String date=null;
      private String month=null;
      private String year=null;
      private String ms=null;
      private String email=null;
      private String phone=null;
      private FormFile proof=null;
      private FormFile theFile;
      private String sex=null;
    


	
	 public void setname(String name){
		this.name=name;
	  }

	  public String getname(){
		return this.name;
	  }
	  

	  public void setfname(String fname){
			this.fname=fname;
		  }

	  public String getfname(){
			return this.fname;
		  }
		  
	  public void setcity(String city){
				this.city=city;
			  }

	  public String getcity(){
				return this.city;
			  }
	  public void setarea(String area){
			this.area=area;
		  }

public String getarea(){
			return this.area;
		  }		  

	  public void setps(String ps){
					this.ps=ps;
				  }

	  public String getps(){
					return this.ps;
				  }
		  
	  public void setplace(String place){
						this.place=place;
					  }

	  public String getplace(){
						return this.place;
					  }
			  	  
	  public void setoccup(String occup){
							this.occup=occup;
						  }

	  public String getoccup(){
							return this.occup;
						  }
						  
	  public void setdate(String date){
								this.date=date;
							  }

	 public String getdate(){
								return this.date;
							  }
							  

							  public void setmonth(String month){
									this.month=month;
								  }

								  public String getmonth(){
									return this.month;
								  }
								  
								  public void setyear(String year){
										this.year=year;
									  }

									  public String getyear(){
										return this.year;
									  }
									  

									  public void setms(String ms){
											this.ms=ms;
										  }

										  public String getms(){
											return this.ms;
										  }
								  
										  public void setemail(String email){
												this.email=email;
											  }

											  public String getemail(){
												return this.email;
											  }
									  	  
											  public void setphone(String phone){
													this.phone=phone;
												  }

												  public String getphone(){
													return this.phone;
												  }
												  public void setsex(String sex){
														this.sex=sex;
													  }

													  public String getsex(){
														return this.sex;
													  }
											  	  
													  public void setproof(FormFile proof){
															this.proof=proof;
														  }

														  public FormFile getproof(){
															return this.proof;
														  }			  
														  public FormFile gettheFile() {
															    return theFile;
															  }
															  /**
															   * @param theFile The FormFile to set.
															   */
															  public void settheFile(FormFile theFile) {
															    this.theFile = theFile;
															  }	 
						
   
}