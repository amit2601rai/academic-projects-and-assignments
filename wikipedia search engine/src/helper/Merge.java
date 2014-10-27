package helper;
import java.io.*;
public class Merge 
      {

            public  void merging(String A,String B,int i)
              {
            	
            	try{
            		  
            	      FileReader fin = new FileReader(A);
            	      BufferedReader br = new BufferedReader(fin);
            	      
            	      FileReader fin2 = new FileReader(B);
            	      BufferedReader br2 = new BufferedReader(fin2);
            	      
            	      BufferedWriter br3 = null; 
            	      
                      br3 = new BufferedWriter(new FileWriter("finalindex/result_"+i));
                  
                      String str,str2;
            	      str=br.readLine();
            	      str2 = br2.readLine();
            	      int outer_1;
            	      int outer_2;
	                    while(str!= null && str2 != null)
	                               {
	                                   
	                    	                  outer_1=str.indexOf(":");
	               	                          outer_2=str2.indexOf(":");
	                    	              if(str.substring(0,outer_1).compareTo(str2.substring(0,outer_2))==0)
	                    	              {
	                    	                    
	                    	            	       int index1=str.indexOf(":");
	                    	            	       int index2=str2.indexOf(":");
	                    	            	       int index11=str.indexOf(":",index1+1);
	                    	            	       int index22=str2.indexOf(":",index2+1);
	                    	            	       int doc1=Integer.parseInt(str.substring(index1+1,index11));
	                    	            	       int doc2=Integer.parseInt(str2.substring(index2+1,index22));
	                    	            	       doc1=doc1+doc2;
	                    	            	       String s1=str.substring(index11+1);
	                    	            	       String s2=str2.substring(index22+1);
	                    	            	       String term=str.substring(0,index1);
	                    	            	       br3.write(term+":"+doc1+":"+s1+"|"+s2+"\n");
	                    	            	       str=br.readLine();
	                    	            	       str2=br2.readLine();
	                    	            	     
	                    	              }
	                    	              else if(str.substring(0,outer_1).compareTo(str2.substring(0,outer_2))<0)
	                    	              {
	                    	            	     
	                    	            	       br3.write(str+"\n");
	                    	            	       str=br.readLine();
	                    	            	  
	                    	              }
	                    	              else if(str.substring(0,outer_1).compareTo(str2.substring(0,outer_2))>0)
	                    	              {
	                    	            	       
	                    	            	        br3.write(str2+"\n");
	                    	            	        str2=br2.readLine();  
	                    	            	  
	                    	              }
	                    	         }
            	       
	                  while(str!= null)
	                    {
	                	    br3.write(str+"\n");
	            	        str=br.readLine();
	                    	
	                    }
	                  while(str2!= null)
	                    {
	                	   br3.write(str2+"\n");
	            	       str2=br2.readLine();
	                    	
	                    }
            	
            	   br3.close();
            	
           }catch(Exception e){}
       }
 }

