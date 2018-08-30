/*
*
* Author: Abrahym Sharf Eldden
* Created: October 7th, 2017
* 
* Description: This program is the third homework assignment for CISC 1115 Fall 2017. This assignment
* is meant to simulate judging in the Olympic games by removing possibly biased scores (outliers) and 
* compute the average score while keeping track of the highest individual score.
* 
*/

import java.io.File; // to use data from file
import java.io.PrintStream; // to print from file.
import java.util.Scanner; // to use Scanner   
import java.util.ArrayList; // Needed to initiate the use of ArrayList
import java.util.List;	// Needed to initiate the use of List<>
import java.util.Collections; // Needed to initiate the use of Collections' methods on the array             

public class Assignment{
	public static void main(String[] args)throws Exception{
		File file = new File("input.txt"); // Designates a read in file - file must be present in folder for this variable to be functional
		Scanner sc = new Scanner(file); // Scans input file’s data depending on datatype
		PrintStream ps = new PrintStream("output.txt"); // Creates an output file and prints data to it
		File op = new File("output.txt"); // Designates a read in file - file is present as it is created above
		Scanner opRead = new Scanner(op); // Scans output file’s data in order for it to be printed to the console
		List<Double> arr = new ArrayList<>();

		int athlete_id, numOfJudges, i, j, athlete_highScoreId = 0, athlete_winId = 0;
		double total, average, athlete_highScore = 0, athlete_averageScore = 0;

		while(sc.hasNext()){
			// While there is a next line in input.txt, assign the datatypes to the below variables
			
			athlete_id = sc.nextInt(); // Reads in the next integer from input.txt
			numOfJudges = sc.nextInt(); // Reads in the next integer from input.txt
			i = 0;
			total = 0; 
			average = 0;

			if(sc.hasNextDouble()){
				while(i < numOfJudges) {
					arr.add(sc.nextDouble()); 	// Adds the scores of the judges to an array
					i++;
				}
			}

			Collections.sort(arr); 	// Sorts the array in ascending order.
			ps.println("--------------------------------------------------------------------");
			
			if(arr.get(i-1) > athlete_highScore){
				// To assign the athlete with the highest individual score

				athlete_highScoreId = athlete_id; 
				athlete_highScore = arr.get(i-1);
			}
			
			arr.remove(i - 1); 	// Removes the highest score from the array
			arr.remove(0); 	// Removes the lowest score from the array
			
			ps.println("Athlete " + athlete_id + "'s scores after dealing with outlier (bias) scores:");
			
			for(j = 0; j < arr.size(); j++ ){
				ps.print(arr.get(j) + ", ");
				total = total + arr.get(j);
			}
			ps.println("");

			average = (total/(numOfJudges - 2));

			ps.printf("Athlete " + athlete_id + "'s average score is: %.1f\n", average);
			
			ps.println("--------------------------------------------------------------------\n\n");
			
			arr.clear();

			if(average > athlete_averageScore) {
				// To assign the winning athlete and their score
				athlete_averageScore = average; 
				athlete_winId = athlete_id;
			}
			if(sc.hasNextLine()) sc.nextLine();
		}

		ps.printf("Athlete " + athlete_winId + " wins the tournament with a score of %.1f!\n", athlete_averageScore);
		ps.println("Athlete " + athlete_highScoreId + " had the highest individual score of: " + athlete_highScore + "!");

		while(opRead.hasNext()){
			// To print output.txt to the console

			System.out.println(opRead.nextLine());
		}
	}
}