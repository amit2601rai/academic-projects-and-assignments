package pkg;

import java.util.HashMap;
import java.util.Vector;


public class Init_Matrix {

	
	
				/* One Vs. Rest
				 * Prepare A [ (d+1) * 1 ]
				 * Prepare Y [ (d+1) * n ]
				 */
				
				/* One Vs. One
				 * Prepare A 
				 * Prepare Y
				 * */
   public double [][] prepare_a(int d)
      {
    		double [][] matrix_a=new double[d+1][1];
    		for(int i=0;i<=d;i++)
    			matrix_a[i][0]=1;
    		return matrix_a;
      }
		
   public double [][] prepare_y(Vector<HashMap<Integer,Vector<DataItem> > > Merge,int class_lable,int d,int n)
     {
    	double [][] matrix_y=new double[d+1][n];
    	int k=0;
    	HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer,Vector<DataItem> >();
    	H=Merge.get(0);
    	for(int i : H.keySet())
    		{
    			if(i==class_lable)
    			{
    				Vector<DataItem>V=new Vector<DataItem>();
    				V=H.get(i);
    				for(int z=0;z<V.size();z++)
    					{
    				    	matrix_y[0][k]=1.0;
    				    	for(int l=1;l<=d;l++)
    				    		matrix_y[l][k]=V.get(z).features.get(l-1);
    				    	k++;
    					}
    			}
    		else{
    				Vector<DataItem>V=new Vector<DataItem>();
    				V=H.get(i);
    				for(int z=0;z<V.size();z++)
    				{
    				    matrix_y[0][k]=-1.0;
    					for(int l=1;l<=d;l++)
    						matrix_y[l][k]=(-1)*(V.get(z).features.get(l-1));
    					k++;
    				}
    			}
    	}
    return matrix_y;
   }
   
   public double [][] prepare_y_pair(Vector<HashMap<Integer,Vector<DataItem> > > Merge,int class_1,int class_2,int d,int n)
   		{
	   		double [][] matrix_y=new double[d+1][n];
	   		int k=0;
	   		HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer,Vector<DataItem> >();
	   		H=Merge.get(0);
	   		for(int i : H.keySet())
	   			{
	   				if(class_1==i)
	   					{
	   						Vector<DataItem>V=new Vector<DataItem>();
	   						V=H.get(i);
	   						for(int z=0;z<V.size();z++)
	   							{
	   								matrix_y[0][k]=1.0;
	   								for(int l=1;l<=d;l++)
	   									matrix_y[l][k]=V.get(z).features.get(l-1);
	   								k++;
	   							}
	   					}
	   			else if(class_2==i){
	   					Vector<DataItem>V=new Vector<DataItem>();
	   					V=H.get(i);
	   					for(int z=0;z<V.size();z++)
	   						{
	   							matrix_y[0][k]=-1.0;
	   							for(int l=1;l<=d;l++)
	   								matrix_y[l][k]=(-1)*(V.get(z).features.get(l-1));
	   							k++;
	   						}
	   				}
  	           }
        return matrix_y;
     }

   public double [][] prepare_y_test(Vector<HashMap<Integer,Vector<DataItem> > > Merge,int d,int n)
   	{
	   double [][] matrix_y=new double[d+1][n];
	   int k=0;
	   HashMap<Integer,Vector<DataItem> >H=new HashMap<Integer,Vector<DataItem> >();
	   H=Merge.get(1);
	   for(int i : H.keySet())
  			{
  					Vector<DataItem>V=new Vector<DataItem>();
  					V=H.get(i);
  					for(int z=0;z<V.size();z++)
  						{
  				    		matrix_y[0][k]=1.0;
  				    		for(int l=1;l<=d;l++)
  				    			matrix_y[l][k]=V.get(z).features.get(l-1);
  				    		k++;
  						}
  			}
	   return matrix_y;
   	}
   
}