package hr.fer.oop.lab2.prob5;

public class PrimeFactorization {

	public static void main(String[] args) {
		
		if(args.length!=1){
			System.err.println("Enter only one argument.");
			return;
		}
		
		int i= Integer.parseInt(args[0]);
		
		if(i<=1){
			System.err.println("Enter number greater than 1.");
			return;
		}
		
		System.out.println("You requested decomposition of number "+ args[0]+" into prime factors. Here they are:");
		
		
		decompose(i);
	}

	private static void decompose(int i) {
		int brojac=1;
		
		for(int j =2; j<=i; j++ ){
			if(i%j==0){
				System.out.println(brojac + "." + j);
				i=i/j;
				brojac++;
				j=1;
				
			}
			
		}
		
		
	}

}
