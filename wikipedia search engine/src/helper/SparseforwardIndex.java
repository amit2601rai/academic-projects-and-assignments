package helper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

public class SparseforwardIndex {

	
	public void index(){
	
	                    try{
	                    	//one entry of sparse index point to 100 entries of dense matrix
		                     
	                    	 BufferedWriter out=new BufferedWriter(new FileWriter("sparse_forwardindex"));  
	                         FileReader fin = new FileReader("forward_index");
	                         
	                         BufferedReader br2 = new BufferedReader(fin); 
                             String line=br2.readLine();
                             
                             int count_1=0,count_2;
                             int counter=0;
                             
                             String line2=line;
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
  		                              counter=counter+line.getBytes().length+1;
        	                          line2=br2.readLine();
        	                          line=line2;
        	                          count_2=counter;
  		                           }
  	                           else
  		                          {
  		                             counter=counter+line.getBytes().length+1;
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
               	System.out.println("error"+ e.getMessage());
            }
     }
}