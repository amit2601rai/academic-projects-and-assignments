package ranking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.*;
import java.io.*;
public class TitleSearch {

	   String titlesearch(TreeMap<Integer,String>u,int i) throws Exception
	    {
	          
		   //System.out.println("size="+u.size());
	       String s=u.get(i);
		   if(s==null)
		   {
			   int k=u.floorKey(i); 
			   s=u.get(k);
		   }

           long offset_1=Integer.parseInt(s);
           //System.out.println("offset="+offset_1);
         
           /*perform change rand---->br*/ 
           RandomAccessFile rand = new RandomAccessFile("forward_index","r"); 
           rand.seek(offset_1); 
           BufferedReader br3=null;
           br3=new BufferedReader(new FileReader(rand.getFD())); 
           String ss=br3.readLine();
 	      // System.out.println(ss);
 	       
 	       String key;
 	 	 while(ss!=null)
     	 {
              int index=ss.indexOf(":");
   		      key=ss.substring(0,index);
   		      ss=ss.substring(index+1);
   		      int j = Integer.valueOf(key, 16).intValue();
     		if(i==j)
 			   {
 			     break;
 			   }
     		 ss=br3.readLine();
         }
 	 	 return ss;
      }
}