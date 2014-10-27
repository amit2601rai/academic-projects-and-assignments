package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class Dataset 
    {
				public static final int fold=5;//constant
				public static final int train_fold=4;//constant
				public static final int test_fold=1;//constant
		/* driver[control the whole function]
		 * Read  
		 * Spilit  
		 * Merge 
		 * In the return we will get training and test data
		 * */
	/*** Read File and Build Data Set ***/
	 public HashMap<Integer,Vector<DataItem> > readData(String filename,int index)
		{
		    HashMap<Integer,Vector<DataItem> >Dataset=new HashMap<Integer, Vector<DataItem>>();
			try{
				BufferedReader br=new BufferedReader(new FileReader(filename));   
				String line=null;
				while((line=br.readLine())!=null)
				{
						DataItem p=new DataItem();
						String [] attributes=line.split(Config.seprator);
						int class_index=0;
	    	            for(int i=0;i<attributes.length;i++)
	    	            {
	    		   		    if(i!=index) 
	    		   		          p.features.add(Double.parseDouble(attributes[i]));	
	    		   		    else{
	    		   			      p.classLabel=Integer.parseInt(attributes[index]);
	    		   				  class_index=p.classLabel;
	    		   		         }
	    	   		     }
	    	           if(Dataset.get(class_index)==null)
	    	            {
	    	        	   	Vector<DataItem>q=new Vector<DataItem>();
	    	        	   	q.add(p);
	    	        	   	Dataset.put(class_index,q);
	    	            }
	    	           else
	    	        	   	Dataset.get(class_index).add(p);
	    	     }  
			}catch (Exception e)
				{
		        	e.printStackTrace();
				}
		return Dataset;
	 }

	 /*** Spilit Dataset in to number of folds ***/  
     public Vector<HashMap<Integer,Vector<DataItem> > > spilit(HashMap<Integer,Vector<DataItem> >Dataset,int folds)
         {
    		   Vector<HashMap<Integer,Vector<DataItem> > >Spilit_data=new Vector<HashMap<Integer,Vector<DataItem> > >();	   
        	   ArrayList<Integer>Permut_Numbers=new ArrayList<Integer>();
        	   helper P =new helper();         	   
        	   DataItem q=new DataItem();
        	   boolean flag=true;
        	   boolean check=true;
        	   for(int i : Dataset.keySet())
        	   {
        		   Vector<DataItem>spilit_token=new Vector<DataItem>();
        		   spilit_token=Dataset.get(i); 
        		   Permut_Numbers=P.randperm(spilit_token.size()); 
        		   int count=0,k=-1;
        		   int val=spilit_token.size()/folds;   
        		   //System.out.println("val= "+val+"   "+"size = "+spilit_token.size());
        		   for(int j : Permut_Numbers)
        		    {     			  
        			     if(count==0&&flag&&check)   /* Check : Represents the creation of new element [ Hashmap ] */
        			   		 {                      /* Flag : Represents the change of element in big array */
        			    	                       /* k: index of big vector */
        			    	                      /* count: next index of that big vector */
        				        k++; 
        			   		    flag=false;
        			   		    HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer,Vector<DataItem> >();
        			   		    q=spilit_token.get(j);
        			   		    Vector<DataItem>r=new Vector<DataItem>();
        			   		    r.add(q);
        			   		    H.put(q.classLabel,r);
        			   		    Spilit_data.add(H);
        			   		 }
        			   	else if(count==0)
        			   		 {
        			   		    k++;
        			   		    flag=true;
        			   			q=spilit_token.get(j);
        			   			if(Spilit_data.get(k).get(q.classLabel)!=null)
        			   			   Spilit_data.get(k).get(q.classLabel).add(q);
        			   			   
        			   			else{
        			   					Vector<DataItem>r=new Vector<DataItem>();
        			   					r.add(q);
        			   					Spilit_data.get(k).put(q.classLabel,r);
        			   				}
        			   		   }
        			   	else{
        			   			   flag=true; 
        			   			   q=spilit_token.get(j);
        			   			   if(Spilit_data.get(k).get(q.classLabel)!=null)
        			   				   		Spilit_data.get(k).get(q.classLabel).add(q);
        			   			   else{
    			   				   	  		Vector<DataItem>r=new Vector<DataItem>();
    			   				   	  		r.add(q);
    			   				   	  		Spilit_data.get(k).put(q.classLabel,r);
    			   				   		}
        			   		}
        			 count++;
        			 count%=val;
        		}
        	check=false;
        }	   
       return Spilit_data;
     }
 
    
    /*** Preparing Training and Testing***/
     public Vector<HashMap<Integer,Vector<DataItem> > > Merge(Vector<HashMap<Integer,Vector<DataItem> > >Complete,
    	   Vector<Integer>Indices,
  		   Vector<Integer>Indices_2)
      {
      	     Vector<HashMap<Integer,Vector<DataItem> > >Merged=new Vector<HashMap<Integer,Vector<DataItem> > >();
      	     boolean flag=true;
      	    /*Training data generation*/
      	     for(int i=0;i<Indices.size();i++)
      	    	{
      	    		int x=Indices.get(i);
      	    		if(flag)
      	    		    { 

      	    				HashMap<Integer, Vector<DataItem>> hash = new HashMap<Integer, Vector<DataItem>>();
      	    				HashMap<Integer,Vector<DataItem>> temphash = Complete.get(x);
      	    				for(int label : temphash.keySet())
      	    				{
      	    					hash.put(label,new Vector<DataItem>());
      	    					hash.get(label).addAll(temphash.get(label));
      	    				}
      	    				Merged.add(hash);
      	    				flag=false;
      	    		     }
      	    		else
      	    		    {
      	    				HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
      	    				H=Complete.get(x);
      	    				for(int k : H.keySet())
      	    				{
      	    					Vector<DataItem>Q=H.get(k);
      	    					Merged.get(0).get(k).addAll(Q);
      	    				}
      	    			}
      	    	  }
      	   /*Testing Generation*/   	    
      	    flag=true;
      	    for(int i=0;i<Indices_2.size();i++)
  	    	 {
  	    		int x=Indices_2.get(i);
  	    		if(flag)
  	    		     {
  	    				HashMap<Integer, Vector<DataItem>> hash = new HashMap<Integer, Vector<DataItem>>();
	    				HashMap<Integer,Vector<DataItem>> temphash = Complete.get(x);
	    				for(int label : temphash.keySet())
	    				{
	    					hash.put(label,new Vector<DataItem>());
	    					hash.get(label).addAll(temphash.get(label));
	    				}
	    				Merged.add(hash);
	    				flag=false;
  	    		     }
  	    		else{
  	    				HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
  	    				H=Complete.get(x);
  	    				for(int k : H.keySet())
  	    				{
  	    					Vector<DataItem>Q=new Vector<DataItem>();
  	    					Q=H.get(k);
  	    					Merged.get(1).get(k).addAll(Q);
  	    				}
  	    			}
  	    	   }
          	
          	return Merged;
          }

       
	 /*** Driver Function ****/
	 public void driver(String filename,int index)
	   {
		    HashMap<Integer,Vector<DataItem> >Dataset=new HashMap<Integer, Vector<DataItem>>();
		    Dataset p=new Dataset();
		    helper q=new helper();
   	 		Dataset=p.readData(filename,index);
   	 		Vector<HashMap<Integer,Vector<DataItem> > >Complete=new Vector<HashMap<Integer,Vector<DataItem> > >();
   	 		Complete=p.spilit(Dataset,fold);  
   	 		ShowResult r=new ShowResult();
   	 		for(int i=1;i<7;i++)
   	 		    r.result(Complete,i);
   
	   }
}
