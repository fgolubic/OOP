package hr.fer.oop.lab4.prob3;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Creates a map of students and their grades, and then it prints student statistics out.
 * @author Filip
 *
 */
public class Students {
	private static int MIN_GRADE=1;
	private static int MAX_GRADE=5;
	private static DecimalFormat form= new DecimalFormat("#.##");

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LinkedHashMap<String,LinkedList<Integer>> studentMap= new LinkedHashMap<String,LinkedList<Integer>>();
		int grade;
		String name;
		String[] line;

		System.out.println("Upisuj ime i ocjenu ucenika sve dok se ne upise 'KRAJ'.");

		while(true){

			line=scanner.nextLine().split("[ ]+");
			

			if(line[0].equals("KRAJ")){
				System.out.println("Kraj unosa!");
				break;
			}

			if(line.length!=2){
				System.err.println("Pogrešan unos! Treba unijeti ime i JEDNU ocjenu.");
				scanner.close();
				return;
			}


			name=line[0];
			grade=Integer.parseInt(line[1]);

			if(grade<MIN_GRADE || grade>MAX_GRADE){
				System.err.println("Error: expecting a grade. Expecting a number between 1 and 5.");
				scanner.close();
				return;
			}

			if(!studentMap.containsKey(name)){
				studentMap.put(name, new LinkedList<Integer>());

			}

			studentMap.get(name).add(grade);


		}

		scanner.close();
		studentStatistics(studentMap);


	}

	/**
	 * Print name, grades, all different grades, average grade and standard deviation for each student.
	 * @param studentMap
	 */
	private static void studentStatistics(LinkedHashMap<String, LinkedList<Integer>> studentMap) {
		for(String temp:studentMap.keySet()){
			System.out.println("Ucenik "+temp);
			System.out.println("	Broj ocjena:"+studentMap.get(temp).size());

			System.out.print("	Ocjene:");
			for(int i=0;i<studentMap.get(temp).size();i++ ){
				System.out.print(studentMap.get(temp).get(i));
				System.out.print(" ");
			}
			System.out.println();

			System.out.print("	Razlicite ocjene:");
			getDifferentGrades(studentMap.get(temp));
			System.out.println();

			System.out.print("	Prosjecna ocjena:");
			printAvrage(studentMap.get(temp));

			System.out.print("	Standardna devijacija:");
			standardDeviation(studentMap.get(temp));
		}


	}

	/**
	 * Calculate and print standard deviation for a student.
	 * @param linkedList
	 */
	private static void standardDeviation(LinkedList<Integer> linkedList) {
		double variance,sum=0,mean=0;
		
		for(Integer i:linkedList){
			mean+=i;
		}
		
		mean/=linkedList.size();

		for(Integer i: linkedList){
			sum+=Math.pow((i-mean),2.0);
		}

		variance=Math.sqrt(sum/(linkedList.size()));

		System.out.println(form.format(variance));
	}

	/**
	 * Print average of a sum of students grades.
	 * @param linkedList
	 */
	private static void printAvrage(LinkedList<Integer> linkedList) {
		double avrage=0;
		for(Integer i: linkedList){
			avrage+=i;
		}

		avrage=avrage/(linkedList.size());

		System.out.println(form.format(avrage));

	}

	/**
	 * Prints all different grades that student has.
	 * @param linkedList
	 */
	private static void getDifferentGrades(LinkedList<Integer> linkedList) {
		Set<Integer> set= new TreeSet<Integer>();
		for(Integer i:linkedList){
			set.add(i);
		}

		for(Integer i: set){
			System.out.print(i+" ");
		}
	}

}
