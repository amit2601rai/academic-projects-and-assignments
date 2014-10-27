package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class helper 
    {
	  // public static int fold=3; 		
	   
	  /*** Random Permutation Generation ***/  
      public ArrayList<Integer> randperm(int size)
        {
   	      	ArrayList<Integer>permut_num=new ArrayList<Integer>();
   	      	Set<Integer>Numbers=new HashSet<Integer>();
   	      	while(Numbers.size()!=size)
   	      		{
   	      			double x=Math.random()*size;
   	      			int y=(int)x;
   	      			if(Numbers.contains(y))continue;
   	      			Numbers.add(y);
   	      			permut_num.add(y);
   	      		}
   	      	return permut_num;
        }
    
      
      /**Checking for the correctness of read**/ 
      public void read_data_print(HashMap<Integer,Vector<DataItem> >Dataset)
	       {
        	   for(int i : Dataset.keySet())
          	 	{
          		 	   System.out.println(i);
          		 	   for(int j=0;j<Dataset.get(i).size();j++)
          		 	   {
          		 		   for(int k=0;k<Dataset.get(i).get(j).features.size();k++)
          		 		   {
          		 			   	System.out.print(Dataset.get(i).get(j).features.get(k)+" ");
          		 		   }
          		 		  System.out.println();
          		 	   }
          		} 
	       }
	  
    
      /**Checking for the correctness of Spilit**/ 
      public void spilit_data_print(Vector<HashMap<Integer,Vector<DataItem> > >Complete)
	      {
    	  		for(int i=0;i<5;i++)
    	  			{
    	  				HashMap<Integer,Vector<DataItem> >Q=new HashMap<Integer, Vector<DataItem>>();
    	  				Q=Complete.get(i);
    	  				for(int j : Q.keySet())
    	  					{
    	  						Vector<DataItem>V=new Vector<DataItem>();
    	  						V=Q.get(j);
    	  						for(int k=0;k<V.size();k++)
    	  							{
    	  								for(int t=0;t<4;t++)
    	  									{
    	  										System.out.print(V.get(k).features.get(t)+" ");
    	  									}
    	  								System.out.println();
    	  							}
	    			 
    	  					}
    	  			}
	      }
	
      /**Checking for the correctness of Merge**/
      public void merge_data_print(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
	      { 
	     	 	for(int i=0;i<2;i++)
	     	 		{
	     	 			HashMap<Integer,Vector<DataItem> >Q=new HashMap<Integer, Vector<DataItem>>();
	     	 			Q=Merged.get(i);
	     	 			for(int j : Q.keySet())
	     	 				{
	     	 					Vector<DataItem>V=new Vector<DataItem>();
	     	 					V=Q.get(j);
	     	 					for(int k=0;k<V.size();k++)
	     	 						{
	     	 							for(int t=0;t<4;t++)
	     	 								{
	     	 									System.out.print(V.get(k).features.get(t)+" ");
	     	 								}
	     	 							System.out.println();
	     	 						}
	     	 				}
	     	 		}
	     	}
	 
      
      /**checking for Y matrix**/
	  public void print_Y()
	      {
	    	  
	    	  
	      }
	  
	  /**checking for A matrix**/
	  public void print_A()
	      {
	    	  
	    	  
	      }
       
	  /**Fetching the number of classes**/
	  public int getClasses(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
	  {
		  HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
		  H=Merged.get(0);
		  return H.size();
	  }
	  
	  /**Fetching the number of attributes**/
	  public int getAttributes(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
	  {
		  HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
		  H=Merged.get(0);
		  return H.get(1).get(0).features.size();
	  }
	  
	  /**Total  number of rows(in each class)**/
	  public ArrayList<Integer> getRows_type(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
	  {
		  ArrayList<Integer> L=new ArrayList<Integer>();
		  HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
		  H=Merged.get(0);
		  for(int i:H.keySet())
		  {
			 L.add(H.get(i).size());
		  }
		  return L;
	  }
	  
	  /**Total  number of rows(in each class)[for testing data]**/
	  public ArrayList<Integer> getRows_type_test(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
	  {
		  ArrayList<Integer> L_test=new ArrayList<Integer>();
		  HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer, Vector<DataItem>>();
		  H=Merged.get(1);
		  for(int i:H.keySet())
		  {
			 L_test.add(H.get(i).size());
		  }
		  return L_test;
	  }
 
      /**get sum of all elements**/
	  public int getSum(ArrayList<Integer>L)
	  {
		  int sum=0;
		  for(int i:L)
		  {
			  sum+=i;
		  }
		  return sum;
	  }
   
	  public int getSum_one_one(ArrayList<Integer>L,int class_1,int class_2)
	  {
		  int sum=0;
		  for(int i=0;i<L.size();i++)
		  {
			  if(class_1==i+1||class_2==i+1)
			     sum+=L.get(i);
		  }
		  return sum;
	  }
   
      public ArrayList<Integer>get_actual_class_test(Vector<HashMap<Integer,Vector<DataItem> > > Merged)
      	{
    	   	ArrayList<Integer>L=new ArrayList<Integer>();
    	   	HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer,Vector<DataItem> >();
       		H=Merged.get(1);
       		for(int i : H.keySet())
       			{
       					Vector<DataItem>V=new Vector<DataItem>();
       					V=H.get(i);
       					for(int z=0;z<V.size();z++)
       						L.add(V.get(z).classLabel);	
       			}
       		return L;
      	}
    
   }