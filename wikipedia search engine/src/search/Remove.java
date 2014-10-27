package search;

public class Remove {
                   public StringBuffer removal(StringBuffer val)
	                   {

  	            		 {
  			                
                  			int k=0;
                            int index=val.indexOf("<!--");
                            while(index!=-1){  
                                              // System.out.println("I m in comment");
                          	                   k=val.indexOf("-->",index);
                          	                   if(k!=-1)
                                               val.replace(index,k+3,"");
                          	                   else val.replace(index,index+4,"");
                          	                   index=val.indexOf("<!--");
                                            }
                        };
  	                   
	                     {
	  			                
	                  			int k=0;
	                            int index=val.indexOf("<ref");
	                            while(index!=-1){
	                                               //System.out.println("I m in ref");
	                          	                   k=val.indexOf(">",index);
	                          	                   if(k!=-1)
	                                               val.replace(index,k+1,"");
	                           	                   else val.replace(index,index+4,"");
	                          	                   index=val.indexOf("<ref");
	                                            }
	              
		                };  
		                
                
		               {
  			                int k=0;
                            int index=val.indexOf("{{reflist");
                            while(index!=-1){
                            	              //System.out.println("I m in reflist");
                                               k=val.indexOf("}}",index);
                          	                   if(k!=-1)
                                               val.replace(index,k+2,"");
                          	                   else val.replace(index,index+9,"");
                          	                   index=val.indexOf("{{reflist");
                                            }
                        };    
	                
                        
		                {
  			                int k=0;
                            int index=val.indexOf("{{Reflist");
                            while(index!=-1){
                            	               //System.out.println("I m in Reflist");
                                               k=val.indexOf("}}",index);
                          	                   if(k!=-1)
                                               val.replace(index,k+2,"");
                          	                   else val.replace(index,index+9,"");
                          	                   index=val.indexOf("{{Reflist");
                                            }
                        };    
                        
                     {
			                
              			   int k=0;
                           int index=val.indexOf("{{cite");
                           while(index!=-1){
                        	               //System.out.println("I m in cite");
                      	                   k=val.indexOf("}}",index);
                      	                   if(k!=-1)
                                           val.replace(index,k+2,"");
                      	                   else val.replace(index,index+6,"");
                      	                   index=val.indexOf("{{cite");
                                        }
                    }; 
	                
              		{
		                
              			int k=0;
                        int index=val.indexOf("[http:");
                        while(index!=-1){
                        	               //System.out.println("I m in http");
                      	                   k=val.indexOf("]",index);
                      	                   if(k!=-1)
                                           val.replace(index,k+1,"");
                      	                   else val.replace(index,index+6,"");
                      	                   index=val.indexOf("[http:");
                                        }
          
                   }; 
                         
                    {
		               int k=0;
                       int index=val.indexOf("==See also");
                       int index2=val.indexOf("==\n",index+2);
                       if(index!=-1&&index2!=-1)
                       val.replace(index,index2+3,"");
                    };
                   
                   
                    {
 		               int k=0;
                        int index=val.indexOf("==Bibliography");
                        int index2=val.indexOf("==\n",index+2);
                        if(index!=-1&&index2!=-1)
                        val.replace(index,index2+3,"");
                    };
                   
                    {
  		                 int k=0;
                         int index=val.indexOf("==Notes");
                         int index2=val.indexOf("==\n",index+2);
                         if(index!=-1&&index2!=-1)
                         val.replace(index,index2+3,"");
                     };
                     
                     {
   		               int k=0;
                          int index=val.indexOf("==Further reading");
                          int index2=val.indexOf("==\n",index+2);
                          if(index!=-1&&index2!=-1)
                          val.replace(index,index2+3,"");
                      };
                    
                    
                   {
		                 int k=0;
                         int index=val.indexOf("==Footnotes==");
                         if(index!=-1)
                         val.replace(index,val.length()-1,"");
                   };    
                 
                   {
		              int k=0;
                      int index=val.indexOf("==External links==");
                      if(index!=-1)
                      val.replace(index,val.length()-1,"");
                   };
                 
                  {
                     int index=val.indexOf("==References==");
                     if(index!=-1)
                     val.replace(index,val.length()-1,"");
                  };       
                 
          return val;
	 }
                   
        public StringBuffer remov(StringBuffer val)
                   {
                	   
                	    {
                	    	int k=0;
                            int index=val.indexOf("[[File:");
                            while(index!=-1){
                            	               //System.out.println("I m in file");
                          	                   k=val.indexOf("|",index);
                          	                   if(k!=-1)
                                               val.replace(index,k+1,"");
                          	                   else val.replace(index,index+7,"");
                          	                   index=val.indexOf("[[File:");
                                            }
                		   
                		   
                	    }   
                	    
                	    {
                	    	int k=0;
                            int index=val.indexOf("[[Image:");
                            while(index!=-1){
                            	               //System.out.println("I m in Image");
                          	                   k=val.indexOf("|",index);
                          	                   if(k!=-1)
                                               val.replace(index,k+1,"");
                          	                   else val.replace(index,index+8,"");
                          	                   index=val.indexOf("[[Image:");
                                            }
                	  };   
                	 return val;
                 }
  }
