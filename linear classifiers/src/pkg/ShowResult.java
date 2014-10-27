package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ShowResult 
   {
			public static final int fold=5;//constant
			public static final int train_fold=4;//constant
			public static final int test_fold=1;//constant
	  
	public void result(Vector<HashMap<Integer,Vector<DataItem> > >Complete,int algo)
	   {
	  
		   Classifier P=new Classifier();
           helper Q=new helper();
           Algo_helper R=new Algo_helper();
	       Dataset S=new Dataset();
	       Algorithms T=new Algorithms();
	       int num_class=Complete.get(0).size();
		   double [][] oneVsone=new double[num_class+1][num_class+1];
		   double [][] oneVsrest=new double[num_class+1][num_class+1]; 
		   double one_one_mean=0.0;
		   double one_rest_mean=0.0;
		   double variance_one_one=0.0;
		   double variance_one_rest=0.0;
		   double deviation_one_one=0.0;
		   double deviation_one_rest=0.0;
		   ArrayList<Double>one_one=new ArrayList<Double>();
		   ArrayList<Double>one_rest=new ArrayList<Double>();
		 
		   /*For calculating the average confusion matrix*/
		   for(int i=1;i<=num_class;i++)
		   {
			   for(int j=1;j<=num_class;j++)
			   {
				  oneVsone[i][j]=0.0;
				  oneVsrest[i][j]=0.0;
			   }
		   }
		        
	     for(int it=1;it<=5;it++)
	       {
	    	
	    	    /***********Data Generation************/
	    	    Vector<Integer>train=new Vector<Integer>();
	   	 		Vector<Integer>test=new Vector<Integer>();
	   	 		ArrayList<Integer>indices=new ArrayList<Integer>();
	   	 	    indices=Q.randperm(fold);
	   	 		int flag=1;
	   	 		for(int i:indices)
	   	 		{
	   	 			if(flag<=train_fold)
	   	 				train.add(i);
	   	 			else
	   	 				test.add(i);
	   	 			flag++;
	   	 		}
	    	    Vector<HashMap<Integer,Vector<DataItem> > >Merged=new Vector<HashMap<Integer,Vector<DataItem> > >();
	    	    Merged=S.Merge(Complete,train,test);	    	      	    
	    	
	    	  /*************** Important ********************/
	    	    int num_classes=Q.getClasses(Merged);//Getting number of classes
	    		int num_attributes=Q.getAttributes(Merged);//Getting number of attributes
	    		int d=num_attributes;
	    		ArrayList<Integer>L=new ArrayList<Integer>();//Getting no of rows in each class [Training]
	    		L=Q.getRows_type(Merged);
	    		ArrayList<Integer>L_test=new ArrayList<Integer>();//Getting no of rows in each class [Testing]
	    		L_test=Q.getRows_type_test(Merged);
	    	
	    	  /**************Calculation**************/
	    		 double total_one_one=0.0;
	    		 double total_one_rest=0.0;
			     Integer [][] result_one_one=P.OneVsOne(num_classes, d, L, L_test, Merged,algo);
			     Integer [][] result_one_rest=P.OneVsRest(num_classes, d, L, L_test, Merged,algo);   
			     
			     
			  /******* Sum (Confusion Matrix) *******/ 
			     for(int k=1;k<=num_classes;k++)
			         {
			    	    for(int j=1;j<=num_classes;j++)
			    	    {
			    	    	 total_one_one+=result_one_one[k][j];
			    	    	 total_one_rest+=result_one_rest[k][j];   	 
			    	    	 oneVsone[k][j]+=result_one_one[k][j];
			    	    	 oneVsrest[k][j]+=result_one_rest[k][j];
			    	    }
			         }
			     double temp1=0.0;
			     double temp2=0.0;
			     for(int k=1,j=1;k<=num_classes;k++,j++)
			        {
			    	          temp1+=result_one_one[k][j];
			    	          temp2+=result_one_rest[k][j];
			        }
			     temp1=temp1/total_one_one;
			     temp2=temp2/total_one_rest;
			     temp1*=100;
			     temp2*=100;
			     temp1=100-temp1;
			     temp2=100-temp2;
			     one_one.add(temp1);
			     one_rest.add(temp2);
			     one_one_mean+=temp1;
			     one_rest_mean+=temp2;		     
	       }//end of for loop iteration 
	       
	         one_one_mean/=5;
		     one_rest_mean/=5;
		     
		     /*Average Confusion Matrix*/
		     for(int k=1;k<=num_class;k++)
	         {
	    	    for(int j=1;j<=num_class;j++)
	    	    {
	                oneVsone[k][j]/=5;
	                oneVsrest[k][j]/=5;
	    	    }
	         }
		     /*Varience Calculation*/
		    for(int i=0;i<5;i++)
		    {
		    	double temp1=0.0;
		    	double temp2=0.0;
		    	temp1=one_one.get(i);
		    	temp1=temp1-one_one_mean;
		    	temp1=Math.pow(temp1, 2);		    	
		        temp2=one_rest.get(i);
		        temp2=temp2-one_rest_mean;
		        temp2=Math.pow(temp2, 2);
		        variance_one_one+=temp1;
		        variance_one_rest+=temp2;
		    }
		    variance_one_one/=5;
		    variance_one_rest/=5;
		    deviation_one_one=Math.sqrt(variance_one_one);
		    deviation_one_rest=Math.sqrt(variance_one_rest);    
		    
		        //Printing the Results
		    if(algo==1)System.out.println("------- Single Sample Perceptron -------\n");
		    else if(algo==2)System.out.println("------- Single Sample Relaxation Variable Eta -------\n");
		    else if(algo==3)System.out.println("------- Batch Perceptron -------\n");
		    else if(algo==4)System.out.println("------- Batch Relaxation Variable Eta-------\n");
		    else if(algo==5)System.out.println("------- Mse Psuedo Inverse -------\n");
		    else if(algo==6)System.out.println("------- Mse LMS -------\n");

		    		/** OneVsOne **/ 
		    System.out.println("Strategy : One Versus One\n ");
		    System.out.println("Mean	:"	+one_one_mean+"\n");
		    System.out.println("Variance:"	+variance_one_one+"\n");
		    System.out.println("Deviation:"	+deviation_one_one+"\n");
		    System.out.println("Confusion Matrix: \n");
		    for(int k=1;k<=num_class;k++)
	        	{
		    		for(int j=1;j<=num_class;j++)
		    			{
		    				System.out.print(oneVsone[k][j]+" ");
		    			}
		    		System.out.println();
	        	}
		 
		    
		    	/** OneVsRest **/
		    System.out.println("\nStrategy : One Versus Rest \n");
		    System.out.println("Mean	:"	+one_rest_mean+"\n");
		    System.out.println("Variance:"	+variance_one_rest+"\n");
		    System.out.println("Deviation:"	+deviation_one_rest+"\n");
		    System.out.println("Confusion Matrix: \n");
		    for(int k=1;k<=num_class;k++)
	        	{
		    		for(int j=1;j<=num_class;j++)
		    			{
		    			   System.out.print(oneVsrest[k][j]+"	");
		    			}
		    		System.out.println();
	        	}
	       
	    }
 }//class end
  
