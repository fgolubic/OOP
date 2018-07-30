package hr.fer.oop.lab2.prob4;

public class PrimeNumbers {

	public static void main(String[] args) {
	
		if(args.length!=1){
			System.err.println("You entered more than one argument.");
			return;
		}
		
			int i=Integer.parseInt(args[0]);
		
		if(i<=0){
			System.err.println("Enter positive number.");
			return;
		}
		
		int first=2;
		int brojac=0;
		
		System.out.println("You requested calculation of first "+ args[0] +" prime numbers. Here they are:");
		
		calculatePrimeNumbers(first, brojac, i);
	}

	private static void calculatePrimeNumbers(int first, int brojac, int i) {
		 if(brojac==i)
			 return;
		 brojac++;
		 if(checkPrime(first)){
			 System.out.println(brojac +". "+ first);
		 }
		 else{
			 brojac--;
		 }
		 first++;
		calculatePrimeNumbers(first,brojac,i);
	}

	private static boolean checkPrime(int first) {
		
		for(int j=2;j<first;j++){
			if(first %j==0)
				return false;
			
		}
		return true;
	}
			

}
