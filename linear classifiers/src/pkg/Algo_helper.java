package pkg;

import java.util.ArrayList;

import org.ejml.simple.SimpleMatrix;

public class Algo_helper {


	/* This class contains functions which helps main algorithms.*/

	/*** Helping Single Perceptron ***/
	public int check(SimpleMatrix D)
	{
		int rows=D.numRows();
		int cols=D.numCols();
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				double x=D.get(i,j);
				if(x<0.0)return j;
			}
		}
		return -1;
	}



	/***Helping Batch Perceptron***/
	public boolean check_theta(SimpleMatrix XX,double theta,int d)
	{  
		int rows=XX.numRows();
		int cols=XX.numCols();
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				double x=XX.get(i,j);
				if(Math.abs(x)>theta)return false;
			}
		}
		return true;
	}

	public ArrayList<Integer> check_batch(SimpleMatrix D)
	{
		int rows=D.numRows();
		int cols=D.numCols();
		ArrayList<Integer> P=new ArrayList<Integer>();
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				double x=D.get(i, j);
				if(x<0.0)P.add(j);//negative correctly not classified
			}
		}	
		return P;
	}


	/**Helping in Relaxation [Single Sample and Batch Perceptron]**/
	public double square_norm(SimpleMatrix y)
	{
		double ans=0.0;
		int rows=y.numCols();
		int cols=y.numRows();
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				double x=y.getIndex(i,j);
				ans=ans+(x*x);
			}
		}
		return ans;
	}

	public SimpleMatrix relax(SimpleMatrix y,double b,SimpleMatrix a,double eta)
	{
		// [b-(a-t)y]y / square of 2nd norm of y
		Algo_helper P=new Algo_helper();
		SimpleMatrix product=a.mult(y);//one*one matrix
		double val=product.get(0,0);
		double scaling_factor=(b-val)/(P.square_norm(y));
		scaling_factor=eta*scaling_factor;
		y=y.scale(scaling_factor);
		return y;
	}

}//class ends here 