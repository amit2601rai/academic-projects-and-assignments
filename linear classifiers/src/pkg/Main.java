package pkg;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String [] args){
		
		Dataset Q=new Dataset();
		Main P=new Main();
		helper R=new helper();
		Classifier S=new Classifier();
		
		String filename=null;
		int index=0;
		System.out.println("Enter the Data File Name: ");
		Scanner in=new Scanner(System.in);
		filename=in.nextLine();
		System.out.println("Enter the Index of class label: ");
		index=in.nextInt();		
	   /***We will get the training and testing data***/
		   Q.driver(filename, index);
		 
	}
}
