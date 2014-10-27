package search;
import java.io.*;
import java.util.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Arrays;


public class SaxReader {
                static int nam;
    public int getNam() {
					return nam;
				}
				public void setNam(int nam1) {
					nam = nam1;
				}
	public static void main(String[] args) throws Exception {
    	 double time;
         time = System.currentTimeMillis();
      
         System.out.println("Enter the folder:");
         String folder = null;
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedReader bufferedReader;
         folder = br.readLine();
       
        File file = new File(folder);  
        File[] files = file.listFiles(); 
        
        
        String directory="finalindex";
        boolean success = (new File(directory)).mkdir();
        
        
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        Parser handler = new Parser();	
        
        SaxReader r=new SaxReader();
        
        java.util.Arrays.sort(files);
        
        int count=0;
        for (int fileInList = 0; fileInList < files.length; fileInList++)  
                  {
        	           r.setNam(fileInList);
        	           System.out.println(files[fileInList]);
        	           parser.parse(new File(files[fileInList].toString()), handler);
                       count++;
                  }
         time = System.currentTimeMillis() - time;
         time=time/1000;
         System.out.println(" The test took " + time + " seconds");
         System.out.println("*******Indexing_phase finished******");  
   }
 }