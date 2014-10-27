package helper;
import java.io.*;
public class Append {
	           private void copyfile(String srFile, String dtFile){
	        try{
	             File f1 = new File(srFile);
	             File f2 = new File(dtFile);
	             InputStream in = new FileInputStream(f1);
	  
	  //For Append the file.
	    OutputStream out = new FileOutputStream(f2,true);

	  //For Overwrite the file.
	 // OutputStream out = new FileOutputStream(f2);

	  byte[] buf = new byte[1024];
	  int len;
	  while ((len = in.read(buf)) > 0)
	   {
	        out.write(buf, 0, len);
	   }
	      in.close();
	      out.close();
	    System.out.println("File copied.");
	  }//try
	  catch(FileNotFoundException ex)
	   {
	         System.out.println(ex.getMessage() + " in the specified directory.");
	         System.exit(0);
	    }
     catch(IOException e)
              {
	               System.out.println(e.getMessage());  
	          }
	   }

public static void main(String[] args) 
                      {
	                        Append r=new Append();
	   	                    r.copyfile("forward_index_1","forward_index");
	   	                }
}
	
