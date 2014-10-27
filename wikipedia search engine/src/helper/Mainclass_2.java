package helper;
import java.io.File;

public class Mainclass_2 {

	  static int k=0;	  
	  public void merg(File[] files)	
	              {
		                if(files.length==1)return;
		                
		                Merge m=new Merge();
		                m.merging(files[0].toString(),files[1].toString(),k++);
		                
		                System.out.println(files[0].toString()+" "+files[1].toString());
		                
		                File f1 = new File(files[0].toString());
		                boolean success = f1.delete();
		               
		                File f2 = new File(files[1].toString());
		                boolean success2 = f2.delete();
		                
		                
		                File file3 = new File("finalindex");  
		                File[] files2 = file3.listFiles();
		               
		                merg(files2);
		           
		                 return;
		          }
	  
	  
		public static void main(String[] args) throws Exception 
	    {
		   File file4 = new File("finalindex");  
           File[] files4 = file4.listFiles();
           Mainclass_2 e =new Mainclass_2();
		   e.merg(files4);
	    }
	  
}
