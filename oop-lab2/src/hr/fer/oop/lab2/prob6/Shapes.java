package hr.fer.oop.lab2.prob6;

public class Shapes {

	public static void main(String[] args) {
		line();
		bowl();
		reverseBowl();
		line();
		
		System.out.println(" ");
		
		reverseBowl();
		bowl();
		
		System.out.println(" ");

		bowl();
		line();
		
		System.out.println(" ");

		
		reverseBowl();
		line();

	}
	
	private static void line(){
		System.out.println("+---------+");
	}
	
	private static void bowl(){
		System.out.println("\\         /");
		System.out.println(" \\_______/");
		 
	}
	
	private static void reverseBowl(){
		System.out.println("  _______");
		System.out.println(" /       \\");
		System.out.println("/         \\");
	}
	
	
}
