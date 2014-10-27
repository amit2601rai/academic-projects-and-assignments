package pkg;

import java.util.ArrayList;

import org.ejml.simple.SimpleMatrix;

public class Algorithms {

	            /*
	                 Single sample Perceptron Algorithm
	                 Batch perceptron Algorithm (variable eta)
	                 Single sample Relaxation   (variable eta)
    				 Batch relaxation Learning  (variable eta)
  					 MSE using Pseudo Inverse
     				 MSE using LMS Procedure
	            */
	
	public SimpleMatrix single_sample_perceptron(double [][] a,double [][] y)
	   {
			SimpleMatrix A=new SimpleMatrix(a);
			SimpleMatrix B=new SimpleMatrix(y);
			SimpleMatrix C=A.transpose();
		
			Algo_helper op =new Algo_helper();
			int j;
			int count=0;
			int iterations=0;
			while(true)
				{
					if(iterations>10000)break;
					   iterations++;
					SimpleMatrix D=C.mult(B);
					if((j=op.check(D))!=-1)
						C=C.plus(B.extractVector(false, j).transpose());
					else 
						break;
					count++;
				}
	    
	    //System.out.println(count);
	   //System.out.println(C);
		return C;
	}

	public SimpleMatrix Batchperceptron(double [][] a,double [][] y,int d)
	{
		    double theta=0.0001;
			double eta=1;
			SimpleMatrix A=new SimpleMatrix(a);//solution vector
			SimpleMatrix B=new SimpleMatrix(y);//training vector
			SimpleMatrix C=A.transpose();
			Algo_helper op =new Algo_helper();
			int j=0;
			int k=0;
			while(true)
				{
					k++;
					if(k>1000)break;
					SimpleMatrix D=C.mult(B); 
					ArrayList<Integer>P=new ArrayList<Integer>();//holds the index of the negative value
					P=op.check_batch(D);
					if(P!=null)
						{
							double [][] X=new double[1][d+1];// 1 cross (d+1) matrix
							for(int i=0;i<=d;i++)
								X[0][i]=0.0;
							SimpleMatrix XX=new SimpleMatrix(X);				
							for(int l : P)
							{
								XX=XX.plus(B.extractVector(false, l).transpose());
							}
							eta=1.0/k;
							XX=XX.scale(eta);
							if(op.check_theta(XX,theta,d))break;
							C=C.plus(XX);
						}
					else break;
				}
		//System.out.println(C);
			return C;
	} 	
        
    public SimpleMatrix single_sample_relax_var_eta(double [][] a,double [][] y)
    {
    	SimpleMatrix A=new SimpleMatrix(a);
		SimpleMatrix B=new SimpleMatrix(y);
		SimpleMatrix C=A.transpose();
		Algo_helper op =new Algo_helper();
		
    	double eta=1;
    	int b=0;//initial margin we have to select[but How we would select it ]
    	int k=0,j=0;
    	while(true)
    	{
    		k=k+1;
    		if(k>1000)break;
			SimpleMatrix D=C.mult(B);
			if((j=op.check(D))!=-1)
				{
				   SimpleMatrix Y=B.extractVector(false, j);
				   eta=1.0/k;
				   SimpleMatrix ans=op.relax(Y, b, C, eta);
				   C=C.plus(ans.transpose());
				}
			else 
				break;
    	} 	
    	return C;
    }
    
    public SimpleMatrix batch_relax_var_eta(double [][] a,double [][] y,int d)
    {
		double theta=0.0001;
		double eta=1;
		SimpleMatrix A=new SimpleMatrix(a);
		SimpleMatrix B=new SimpleMatrix(y);
		SimpleMatrix C=A.transpose();
		Algo_helper op =new Algo_helper();
		int j;
		int k=0;
		int b=1;//initial margin we have to select[but How we would select it ]
		while(true)
			{
				k++;
				eta=1.0/k;
				if(k>1000)break;
				SimpleMatrix D=C.mult(B); 
				ArrayList<Integer>P=new ArrayList<Integer>();
				P=op.check_batch(D);
				if(P!=null)
					{
						double [][] X=new double[1][d+1];
						for(int i=0;i<=d;i++)
							X[0][i]=0.0;
						SimpleMatrix XX=new SimpleMatrix(X);				
						for(int l : P)
						{
							SimpleMatrix YY=B.extractVector(false, l).transpose();						      
							YY=YY.transpose();
							YY=op.relax(YY, b, C, eta);
							XX=XX.plus(YY.transpose());
						}
						if(op.check_theta(XX,theta,d))
							break;
						C=C.plus(XX);
					}//there atleast one negative sample
				else break;
			}
		return C;
    }
  
    public SimpleMatrix mse_psuedo_inv(double [][] y,int num)
    {
    	SimpleMatrix Y=new SimpleMatrix(y);
    	Y=Y.transpose();
    	double [][] b=new double [num][1];
    	for(int i=0;i<num;i++)
    		b[i][0]=1;
    	SimpleMatrix B=new SimpleMatrix(b);
    	SimpleMatrix A=(Y.transpose().mult(Y)).invert().mult(Y.transpose()).mult(B);
    	return A.transpose();
    }

    public SimpleMatrix mse_lms(double [][] a,double [][] y,int num,int d)
    {
	    Algo_helper op=new Algo_helper();
    	double theta=0.0001;
    	double eta=1;
    	int k=0;
    	SimpleMatrix A=new SimpleMatrix(a);
    	SimpleMatrix Y=new SimpleMatrix(y);
    	SimpleMatrix C=A.transpose();
    	double [][] b=new double [num][1];
    	for(int i=0;i<num;i++)
    		b[i][0]=1;
    	SimpleMatrix B=new SimpleMatrix(b);
    	
    	while(true)
    	{
    	  	k=k+1;
    	  	eta=1.0/k;
    	  	if(k>1000)break;
    	  	SimpleMatrix D=C.mult(Y);
    	    D=B.minus(D.transpose());
    	  	D=Y.mult(D);
    	  	D.scale(eta);
    	  	if(op.check_theta(D,theta,d))
				break;
    	  	C=C.plus(D.transpose());
    	    break;
    	}
    		return C;
    }

}//class of algorithms