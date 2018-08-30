/*
*
* Author: Abrahym Sharf Eldden
* Created: October 7th, 2017
* 
* Description: This program is the second homework assignment for CISC 1115 Fall 2017. This program is meant to 
* compute baseball statistics; reading in the team's id, win-loss record and information gathered from this data.
* This is done for a total of ten (10) baseball teams. 
* 
*/

import java.io.File; // to use data from file
import java.io.PrintStream; // to print from file.
import java.util.Scanner; // to use Scanner                

public class Assignment{
	public static void main(String[] args)throws Exception{
		File file = new File("input.txt"); // Designates a read in file - file must be present in folder for this variable to be functional
		Scanner sc = new Scanner(file); // Scans input file’s data depending on datatype
		PrintStream ps = new PrintStream("output.txt"); // Creates an output file and prints data to it
		File op = new File("output.txt"); // Designates a read in file - file is present as it is created above
		Scanner opRead = new Scanner(op); // Scans output file’s data in order for it to be printed to the console

		int count = 0; // To count the number of teams in the league
		double best_winAvg1 = 0;
		int best_teamwinAvg1 = 0;

		double best_winAvg2 = 0;
		int best_teamwinAvg2 = 0;

		while(sc.hasNext()){
			// While there is a next line in input.txt, assign the datatypes to the below variables
			int team_id = sc.nextInt(); // Reads in the next integer from input.txt
			int team_wins = sc.nextInt(); // Reads in the next integer from input.txt
			int team_losses = sc.nextInt(); // Reads in the next integer from input.txt

			int team_gamesPlayed = team_wins+team_losses; 
			int team_gamesLeft = 25 - team_gamesPlayed;

			int team_winsA = team_wins + team_gamesLeft;
			int team_lossesA = team_losses + team_gamesLeft;

			double team_winAvg = (double) team_wins/team_gamesPlayed; // Computes a number between 0 and 1.

			if(team_winAvg > best_winAvg1){
				// Assigns the team’s name with the best win average to var best_teamwinAvg1

				best_winAvg1 = team_winAvg;
				best_teamwinAvg1 = team_id;
			}
			if(team_winAvg > best_winAvg2 && team_gamesLeft == 0){
				// Assigns the team who has completed all 25 games with the best win average to var best_teamwinAvg2 
				
				best_winAvg2 = team_winAvg;
				best_teamwinAvg2 = team_id;	
			}

			ps.println("----------------- Team: " + team_id + " --------------------------------");
			ps.println("Wins: " + team_wins + "\tLosses: " + team_losses);

			if(team_gamesPlayed == 25){
				ps.println("This team's season is complete.");
			} 
			else if(team_gamesPlayed < 25){
				ps.println("Total Games Played: " + team_gamesPlayed + "\tGames Remaining: " + team_gamesLeft);
				ps.println("|| If " + team_id + " wins all remaining games then their record would be: ");
				ps.println("|| Wins: " + team_winsA + "\tLosses: " + team_losses);
				ps.println("|| If " + team_id + " Loses all remaining games then their record would be:");
				ps.println("|| Wins: " + team_wins + "\tLosses: " + team_lossesA);
			}
			else{
				// Prints an error to the output.txt file allowing for easier troubleshooting.

				System.out.println("Error in the data, please check the output file and review the entered data.");
				System.exit(0);
			}

			ps.printf("\nWinning Average: %.2f\n\n", team_winAvg);

			if(team_gamesLeft >= team_wins) ps.println("Number of games remaining is greater than or equal to the number of games won.");
			else ps.println("Number of games remaining is less than the number of games won.");

			if(team_gamesLeft > team_losses) ps.println("Number of games remaining is greater than or equal to the number of games lost.");
			else ps.println("Number of games remaining is less than or equal to the number of games lost.");

			ps.print("-------------------------------------------------------------");
			ps.print("\n\n\n");

			count++; // Increments as the while statement is true
		}

		ps.println("The team with the best winning average that has completed the season is: " + best_teamwinAvg2 + " with a winning average of: " + best_winAvg2);
		ps.println("The team with the best winning average that has not completed the season is: " + best_teamwinAvg1 + " with a winning average of: " + best_winAvg1);

		ps.println("\nTotal number of teams in the league is: " + count);

		while(opRead.hasNext()){
			// To print output.txt to the console
			System.out.println(opRead.nextLine());
		}
	}
}