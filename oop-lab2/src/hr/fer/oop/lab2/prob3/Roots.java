package hr.fer.oop.lab2.prob3;

import java.text.DecimalFormat;

public class Roots {

	public static void main(String[] args) {

		if(args.length!=3){
			System.err.println("Enter 3 arguments.");
			return;
		}
		
		if(Integer.parseInt(args[2])<=0){
			System.err.println("Enter correct root, greater than 0");
		}
		

		double re=Double.parseDouble(args[0]);
		double im=Double.parseDouble(args[1]);
		int root=Integer.parseInt(args[2]);

		System.out.println("You requested calculation of " + root +". roots. Solutions are:");

		calculateRoot(re, im, root);


	}

	private static void calculateRoot(double re, double im, int root) {

		double mod=calculateModul(re,im);
		double angle=calculateAngle(re,im);

		double[] allReRoots = new double[root];
		double[] allImRoots= new double[root];

		double r=Math.pow(mod, 1.0/root);

		for(int i=0; i<root; i++){
			allReRoots[i]=r*Math.cos((angle+Math.PI*2*i)/root);
			allImRoots[i]=r*Math.sin((angle+Math.PI*2*i)/root);
		}

		precision(allReRoots,allImRoots, root);

		print(allReRoots, allImRoots,root);
		
		

	}

	private static void precision(double[] allReRoots, double[] allImRoots, int root) {
		DecimalFormat form= new DecimalFormat("#,####");
		final double k = Math.pow(10, -6);
		String temp;

		for(int i=0;i<root;i++){
			if(Math.abs(allReRoots[i])<k){
				allReRoots[i]=0;
			}
			else{
				temp=form.format(allReRoots[i]);
				allReRoots[i]=Double.parseDouble(temp);
			}
		}

		for(int i=0;i<root;i++){
			if(Math.abs(allImRoots[i])<k){
				allImRoots[i]=0;
			}
			else{
				temp=form.format(allImRoots[i]);
				allImRoots[i]=Double.parseDouble(temp);
			}
		}

	}

	private static void print(double[] allReRoots, double[] allImRoots, int root) {
		for(int i=0;i<root;i++)	{
			if(allImRoots[i]<0 && allReRoots[i]!=0){
				System.out.println(i+1 + ".)" + allReRoots[i]+ " - " +((-1)*allImRoots[i])+"i");
			}
			else if(allImRoots[i]>0 && allReRoots[i]!=0){
				System.out.println(i+1 + ".)" + allReRoots[i]+ " + " + allImRoots[i] + "i");
			}

			else if(allImRoots[i]==0 && allReRoots[i]!=0){
				System.out.println(i+1 +".)" + allReRoots[i]);
			}
			
			else if(allReRoots[i]==0 && allImRoots[i]<0 ){
				System.out.println(i+1 +".)" + " - " +((-1)*allImRoots[i])+"i");
				
			}
			
			else if(allReRoots[i]==0 &&allImRoots[i]>0){
				System.out.println(i+1 +".)" + allImRoots[i]);
			}
			
			
			else if(allReRoots[i]==0 && allImRoots[i]==0 ){
				System.out.println(i+1 + ".) 0");
			}


		}
	}

	private static double calculateAngle(double re, double im) {
		if(re==0) return Math.PI/2;
		double temp=im/re;
		temp= Math.atan(temp);
		return temp;
	}

	private static double calculateModul(double re, double im) {
		double a=Math.pow(re, 2);
		double b=Math.pow(im, 2);
		return Math.sqrt(a+b);
	}




}
