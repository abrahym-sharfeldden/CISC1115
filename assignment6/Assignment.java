/*
*
* Author: Abrahym Sharf Eldden
* Created: December 14th, 2017
* 
*/

import java.io.File; // to use data from file
import java.io.PrintStream; // prints data to output file
import java.util.Scanner; // to use Scanner          

public class Assignment {	
	
	public static double[] readData(int n, double[] numbers)throws Exception{
		Scanner sc = new Scanner(new File("input.txt")); // Scans input file’s data depending on datatype.

		while(sc.hasNextDouble() == true) {
			for(int i = 0; i < n; i++) numbers[i] = sc.nextDouble();
		}

		return numbers;
	}

	public static void printArray(int q, double[] numb){
		for(int i = 0; i < q; i++){
			if(i % 5 == 0) System.out.println();
			System.out.printf("%.2f\t", numb[i]);
		}
		System.out.println();
	}

	public static double findAverage(int k, double[] p){
		double sum = 0;
		double avg;
		
		for(int i= 0; i < k; i++) sum = sum + p[i];
		avg = sum / k;
		return avg;
	}

	public static double[] howFarAway(double m, double[] r){
		double[] s = new double[r.length];

		for(int i = 0; i < r.length; i++) s[i] = r[i] - m;

		return s;
	}
	public static void optionalMethod(double o, double[] z){
		double temp;
		double closest = 999;
		double furthest = 0;

		for(int i = 0; i < z.length; i++){
			if(Math.abs((z[i] - o)) < closest) closest = z[i];
			if(Math.abs((z[i] - o)) > furthest) furthest = z[i];
		}

		System.out.printf("\nThe closest value to the average is: %.2f", closest);
		System.out.printf("\nThe furthest value to the average is: %.2f", furthest);
	}
	
	public static void main(String[] args)throws Exception{
		PrintStream ps = new PrintStream("output.txt"); // Creates an output file and prints data to it
		File op = new File("output.txt");
		
		System.setOut(ps); // Sets all the System.out's to redirect to output.txt

		double avg1 = 0;
		double avg2 = 0;
		int size = 15;

		double[] first = new double[size];
		double[] second = new double[size];

		readData(size, first);

		System.out.println("Here is the original array: ");
		printArray(first.length, first);

		avg1 = findAverage(first.length, first);
		System.out.printf("\nThe average was determined to be: %.2f", avg1);
		
		optionalMethod(avg2, first);

		second = howFarAway(avg1, first);

		System.out.println("\n\nHere is the new array: ");
		printArray(second.length, second);

		avg2 = findAverage(second.length, second);
		System.out.printf("\nThe average was determined to be: %.2f", avg2);

		optionalMethod(avg2, second);

	}
}