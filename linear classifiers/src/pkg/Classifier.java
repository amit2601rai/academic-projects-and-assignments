package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.ejml.simple.SimpleMatrix;

public class Classifier {

	/**
	 *	Driver function which call the
	 *  [After the getting the values we will call the testing module from here] 
	 *  One Vs. Rest
	 *	One Vs. One
	 *	Simple Perceptron
	 *  Batch  Perceptron
	 **/


	/** 
	 *   [ One Vs. Rest ]: 
	 *   Prepare Y for each combination and calculate testing matrix Z as well 
	 *   Also maintain the actual Class of each and every row in an (array or array list)
	 *   Now using Y calculate final A with the help of Simple Perceptron and Batch Perceptron
	 *   we will get the <A_finals> 
	 *   Now we have to calculate confusion matrix with help of product(<A_finals>,<testing_finals>)
	 *   now three array of same dimension check for max in all three arrays and classified it as same
	 *   Actual class * Classified Class  [Initialise it from 0]   
	 **/


	public Integer[][] confusion_matrix(int num_classes,
			ArrayList<SimpleMatrix>final_A,
			SimpleMatrix final_testing,
			ArrayList<Integer>Actual_class_testing)
	{

		SimpleMatrix [] product=new SimpleMatrix[num_classes+1];
		Integer [][] matrix=new Integer[num_classes+1][num_classes+1];
		for(int i=1;i<=num_classes;i++)
			for(int j=1;j<=num_classes;j++)
				matrix[i][j]=0;

		for(int i=1;i<=num_classes;i++)
		{
			product[i]=final_A.get(i-1).mult(final_testing);
		}

		//store the dimension of 1-D Array
		int n=product[1].numCols();
		for(int k=0;k<n;k++)
		{
			double temp_max=product[1].get(0,k);
			int temp_class=1;
			for(int i=2;i<=num_classes;i++)
			{
				double temp=product[i].get(0,k);
				if(temp>temp_max)
				{
					temp_max=temp;
					temp_class=i;
				}
			}
			matrix[Actual_class_testing.get(k)][temp_class]++; 
		}

		return matrix;
	}



	public Integer[][] confusion_matrix_one_one(int num_classes,
			SimpleMatrix [][] B,
			SimpleMatrix final_testing,
			ArrayList<Integer>Actual_class_testing)
	{

		HashMap<Integer,store>H=new HashMap<Integer, store>();
		SimpleMatrix [][] Result=new SimpleMatrix[num_classes+1][num_classes+1]; 
		Integer [][] confusion_matrix=new Integer[num_classes+1][num_classes+1];
		for(int i=1;i<=num_classes;i++)
			for(int j=1;j<=num_classes;j++)
				confusion_matrix[i][j]=0;
		for(int i=1;i<=num_classes;i++)
		{
			for(int j=i+1;j<=num_classes;j++)
			{
				Result[i][j]=B[i][j].mult(final_testing);
			}
		}

		for(int i=1;i<=num_classes;i++)
		{
			for(int j=i+1;j<=num_classes;j++)
			{
				SimpleMatrix D=Result[i][j];
				for(int k=0;k<D.numCols();k++)
				{
					if(H.get(k)==null)
					{
						store P=new store();
						P.classlable=Actual_class_testing.get(k);
						for(int l=1;l<=num_classes;l++)
							P.count[l]=0;
						if(D.get(0, k)>0)
							P.count[i]++;
						else 
							P.count[j]++;
						H.put(k,P);
					}
					else
					{
						if(D.get(0, k)>0)
							H.get(k).count[i]++;
						else 
							H.get(k).count[j]++;
					}
				}
			}
		}

		for(int i:H.keySet())
		{
			store p=H.get(i);
			int temp_max=p.count[1],k=1;
			for(int j=2;j<=num_classes;j++)
			{
				if(p.count[j]>temp_max)
				{
					temp_max=p.count[j];
					k=j;
				}
			}
			confusion_matrix[p.classlable][k]++;
		}


		return confusion_matrix;
	}


	public Integer[][] OneVsRest(int num_classes,int d,ArrayList<Integer>L,ArrayList<Integer>L_test,
			Vector<HashMap<Integer,Vector<DataItem> > > Merged,int algo)
	{

		helper Q=new helper(); 
		Init_Matrix P=new Init_Matrix();
		Algorithms R=new Algorithms();
		Classifier S=new Classifier();

		int n=Q.getSum(L);
		int m=Q.getSum(L_test);

		ArrayList<SimpleMatrix>final_A=new ArrayList<SimpleMatrix>();

		/***** Preparing Test Data *****/
		ArrayList<Integer>Actual_class_testing=new ArrayList<Integer>();
		Actual_class_testing=Q.get_actual_class_test(Merged);//indexes store the classes
		double [][] Y_test=new double[d+1][m];
		Y_test=P.prepare_y_test(Merged,d,m);
		SimpleMatrix YY_test=new SimpleMatrix(Y_test);
        		
		for(int i=1;i<=num_classes;i++)
		{
			double [][] A=new double[d+1][1];
			double [][] Y=new double[d+1][n];
			A=P.prepare_a(d);
			Y=P.prepare_y(Merged, i, d, n);
			 SimpleMatrix A_final=null;
		   	/*********************** Algorithms *********************************/
			 if(algo==1)A_final=R.single_sample_perceptron(A, Y);
			 else if(algo==2)A_final=R.single_sample_relax_var_eta(A, Y);
			 else if(algo==3)A_final=R.Batchperceptron(A, Y, d);
			 else if(algo==4)A_final=R.batch_relax_var_eta(A, Y,d);
			 else if(algo==5)A_final=R.mse_psuedo_inv(Y,n);
			 else if(algo==6)A_final=R.mse_lms(A,Y,n,d);
			/*******************************************************************/						
			final_A.add(A_final);
		}
		//call the confusion matrix function and print it here [Row->actual Col->predicted]
		Integer [][] conf_mat=new Integer[num_classes+1][num_classes+1];
		conf_mat=S.confusion_matrix(num_classes, final_A, YY_test, Actual_class_testing);
		return conf_mat;//returning confusion matrix
	}

	/** 
	 *  [One Vs. One ]:  
	 *  Here the final combinations stored in 2D-array
	 *  Now create the testing data from same convention
	 *  Now we have <A_finals,Testing_finals>[for each testing data we have to store the actual classes] 
	 **/


	public Integer[][] OneVsOne(int num_classes,int d,ArrayList<Integer>L,
			ArrayList<Integer>L_test,
			Vector<HashMap<Integer,Vector<DataItem> > > Merged,int algo)
	{

		helper Q=new helper(); 
		Init_Matrix P=new Init_Matrix();
		Algorithms R=new Algorithms();
		Classifier S=new Classifier();	
		int m=Q.getSum(L_test);
		SimpleMatrix [][] B=new SimpleMatrix[num_classes+1][num_classes+1];
		/***** Preparing Test Data *****/
		ArrayList<Integer>Actual_class_testing=new ArrayList<Integer>();
		Actual_class_testing=Q.get_actual_class_test(Merged);//indexes store the classes
		double [][] Y_test=new double[d+1][m];
		Y_test=P.prepare_y_test(Merged,d,m);
		SimpleMatrix YY_test=new SimpleMatrix(Y_test);
		for(int i=1;i<=num_classes;i++)
		{
			for(int j=i+1;j<=num_classes;j++)
			{

				int n=Q.getSum_one_one(L,i,j);		
				double [][] A=new double[d+1][1];
				double [][] Y=new double[d+1][n];
				A=P.prepare_a(d);
				Y=P.prepare_y_pair(Merged, i,j, d, n);

				/*************Algorithms***************/

				if(algo==1)B[i][j]=R.single_sample_perceptron(A, Y);
				else if(algo==2)B[i][j]=R.single_sample_relax_var_eta(A, Y);
				else if(algo==3)B[i][j]=R.Batchperceptron(A, Y,d);
				else if(algo==4)B[i][j]=R.batch_relax_var_eta(A, Y,d);
				else if(algo==5)B[i][j]=R.mse_psuedo_inv(Y,n);
				else if(algo==6)B[i][j]=R.mse_lms(A, Y,n,d);

				/*************************************/
			}
		}
		//call the confusion matrix function and print it here
		Integer [][] conf_mat=new Integer[num_classes+1][num_classes+1];
		conf_mat=S.confusion_matrix_one_one(num_classes,B,YY_test,Actual_class_testing);
		return conf_mat;
	}	
}//class end here