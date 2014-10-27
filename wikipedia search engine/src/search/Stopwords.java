package search;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Stopwords {
	  
	HashSet HSet = new HashSet();    
	public HashSet getHSet() {
		return HSet;
	}
	public void setHSet(HashSet hSet) {
		HSet = hSet;
	}
	public void store() 
	{
                 try{
		      	    	FileReader fin = new FileReader("stopwords");
				        BufferedReader br = new BufferedReader(fin);
		      	        String strLine;
	                    while((strLine = br.readLine()) != null)
	                    	 HSet.add(strLine);
	                   // System.out.println("The HashSet elements are: " + HSet.size());

                         fin.close();  
		      	     }catch (Exception e){System.err.println("Error: " + e.getMessage());}  
                    	
	}
}
