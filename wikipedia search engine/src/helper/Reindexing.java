package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Reindexing
        {
          public void secondaryindex() 
	         {
		      try{
        	  /*dense matrix formation*/
       	       FileReader fin = new FileReader("mainIndex");
               BufferedReader br2 = new BufferedReader(fin); 
               BufferedWriter out=new BufferedWriter(new FileWriter("dense_index"));
               long counter=0;
               String line=br2.readLine();
              while(line!=null)
               {
           	  	  int index=line.indexOf(":");
           	      String line1=line.substring(0,index+1);
           	      out.write(line1+counter+"\n");
           	      counter=counter+line.length()+1;
           	      line=br2.readLine();
           	  }
             out.close();
            /*sparse matrix formation*/  
           //one entry of sparse index point to 100 entries of dense matrix
             out=new BufferedWriter(new FileWriter("sparse_index"));  
             fin = new FileReader("dense_index");
             br2 = new BufferedReader(fin); 
             line=br2.readLine();
             long count_1=0,count_2;
             counter=0;
             String line2=null;
             line2=line;
             count_2=counter;
             while(line!=null)
             {
           	  count_1++;
           	
           	  if(count_1==100)
           		  {
           		    int index=line2.indexOf(":");
               	    String line1=line2.substring(0,index+1);
           		    out.write(line1+count_2+"\n");
           		    count_1=0;
           		    
           		    counter=counter+line.length()+1;
                 	    line2=br2.readLine();
                 	    line=line2;
                 	    count_2=counter;
           		  }
           	  else
           		  {
           		    counter=counter+line.length()+1;
           		    line=br2.readLine();
           		  }
             }
              int index=line2.indexOf(":");
     	      String line1=line2.substring(0,index+1);
 		      out.write(line1+count_2+"\n");
              out.close();
	          }
          catch(Exception e)
                   {
        	           System.out.println("error!!");
        	       }
         }
}