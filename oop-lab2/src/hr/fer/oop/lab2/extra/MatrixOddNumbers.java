package hr.fer.oop.lab2.extra;

import java.util.Scanner;

public class MatrixOddNumbers {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);

		int n=getSize(scan);

		int matrix[][]=new int[n][n];

		MatrixOddNumbers.getMatrix(matrix, n,scan);

		scan.close();

		printMatrix(matrix, n,"Input:");

		deleteOddNumbers(matrix, n);

		printMatrix(matrix, n , "Output:");

	}

	private static void deleteOddNumbers(int[][] matrix, int n) {
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				if(isOdd(matrix[i][j])){
					matrix[i][j]=0;
				}
			}
		}
	}

	private static boolean isOdd(int i) {
		if(i%2!=0){
			return true;
		}
		return false;
	}

	private static void printMatrix(int[][] matrix, int n, String string) {
		System.out.println(string);
		System.out.println();

		for(int i=0;i<n;i++){
			System.out.print("| ");
			for(int j=0;j<n;j++){
				System.out.print( matrix[i][j] + "|  ");

			}
			System.out.println();
		}
		System.out.println();

	}

	private static void getMatrix(int[][] matrix, int n, Scanner scan) {
		int index=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				index=(n*i)+j+1;
				System.out.println("Enter " + index + ". element.");
				matrix[i][j]=scan.nextInt();

			}
		}

	}

	private static int getSize(Scanner scan) {
		int n;
		do{
			System.out.println("Enter size of matrix:");
			n=scan.nextInt();

			if(n<=0){
				System.err.println("Size must be a number greater than 0.");
			}


		}while(n<=0);
		System.out.println("You entered size " + n +".Size of matrix is "+ n + "x" + n + ".");
		return n;
	}

}
