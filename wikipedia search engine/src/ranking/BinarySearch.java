package ranking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.*;
public class BinarySearch {
	         String extract(Vector<String>v,String key) throws Exception 
	               {
                
		      /*applying binary search on the vector of sparse_index*/
	            	 int l=0,u=0,mid=0;
	            	 u=v.size()-1;
	            	 boolean flag=false;
	            while(u-l!=1)
	            	 {
	            		 mid=(l+u)/2;
	            		 String s = (String)v.get(mid);
	            		 int index=s.indexOf(":");
	            		 s=s.substring(0, index);
	            		
	            		 if(s.compareTo(key)==0)
	            			 {
	            			    flag=true;
	            			    break;
	            			 }
	            		 else if(s.compareTo(key)<0)
	            			 l=mid;
	            		 else
	            			 u=mid;
	            		 
	            	 }
	          	if(!flag)
	            	{
	            	   String s = (String)v.get(u);
            		   int index=s.indexOf(":");
            		   s=s.substring(0, index);
            		   if(s.compareTo(key)<=0)
            			 mid=u;
            		   else
            			 mid=l;
	            	}
	             
	          	  
	              String key2=(String)v.get(mid);
	              int index=key2.indexOf(":");
       		      key2=key2.substring(index+1);
       		      long offset_1=Long.parseLong(key2);
	            
       		       //now we have offset_1
        		  /*dense Index[100 entries map to element of sparse index]*/
	              flag=false;
	             // FileReader fin2 = new FileReader("dense_index");
        	      BufferedReader br2 = null;
        	      BufferedReader br3 = null;
        	      /*perform change rand---->br*/
        	      RandomAccessFile rand = new RandomAccessFile("dense_index","r"); 
	              rand.seek(offset_1); 
	             
	              br2=new BufferedReader(new FileReader(rand.getFD()));
        	      
	              String ss=br2.readLine();
        	      int counter=1;
        	 	 while(counter<=100&&ss!=null)
            	 {
                      key2=ss;
        	 		  index=ss.indexOf(":");
          		      ss=ss.substring(0,index);
            		if(ss.compareTo(key)==0)
        			   {
        			      flag=true;
        			      break;
        			    }
            		 ss=br2.readLine();
            		 counter++;
            	  }
               if(!flag)return null;
        
               index=key2.indexOf(":");
  		       key2=key2.substring(index+1);
  		       long offset_2=Long.parseLong(key2);
  		   
  	         RandomAccessFile rand2 = new RandomAccessFile("mainIndex","r"); 
             rand2.seek(offset_2); 
             br3=new BufferedReader(new FileReader(rand2.getFD()));
  	         ss=br3.readLine();
  	         
  	         return ss;
	     }
            
 }