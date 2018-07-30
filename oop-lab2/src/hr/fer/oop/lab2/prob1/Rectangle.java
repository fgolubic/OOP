package hr.fer.oop.lab2.prob1;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);

		double width = 0;
		double length = 0 ;


		if(args.length==0){
			System.out.println("Please provide width:");
			width=read("width",scan);
			System.out.println("Please provide height:");
			length=read("length",scan);
		}



		else{
			if(args.length!=2){
				System.out.println("Invalid number of arguments provided");
				scan.close();
				return;
			}

			width=Double.parseDouble(args[0]);
			length=Double.parseDouble(args[1]);
		}

		

		double area=calculateArea(width, length);
		double per=calculatePerimiter(width,length);

		System.out.println("You have specified rectangle of width " + width + " and height " + length +". Its area is " +area +" and its perimiter is " + per +"." );
	
		scan.close();

	}

	private static double calculatePerimiter(double a, double b) {
		return 2*a + 2*b;
	}

	private static double read(String string,Scanner scan){

		double write ;

		do{
			write=scan.nextDouble();
			if(write==0)
				System.out.println("The input must not be blank.");
			else if(write<0)
				System.out.println("The" + string +"must not be negative");

		}while(write<=0);

		return write;
	}

	private static double calculateArea(double a,double b){
		return a*b;
	}
}
