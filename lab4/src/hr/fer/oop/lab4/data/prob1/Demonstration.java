/**
 * 
 */
package hr.fer.oop.lab4.data.prob1;

import hr.fer.oop.lab4.prob2.SimpleHashtable;
import hr.fer.oopj.lab4.data.StudentGrades;

/**
 * @author Filip
 *
 */
public class Demonstration {

	public static void main(String[] args){
		int size=StudentGrades.getNumberOfRecords();
		SimpleHashtable<String,Integer> table=new SimpleHashtable<>(size);

		for(int i=0;i<size;i++){
			table.put(StudentGrades.getRecord(i).getStudentID(),StudentGrades.getRecord(i).getGrade());
		}

		BaremN ispitivac= new BaremN(3);

		table.removeIfValue(ispitivac);

		table.print();

	}
}
