/*
*
* Author: Abrahym Sharf Eldden
* Created: October 26th, 2017
* 
* Description: This program simulates a game of dice. Two integers between 1 and 6 are entered into the Scanner.
* The numbers are then summed and the player wins if it equates a 7 or 11, the player loses if it equates a 2
* or 12. The method continues into another step if neither a win or a loss is produced on the first attempt. 
* The player will be asked for two more numbers between 1 and 6. If these new numbers add to 7, the player loses.
* If the sum of the new numbers are equal to the sum of the previous two numbers, then the player wins. This step is
* repeated until the player wins or loses.
* 
*/

import java.util.Scanner;

public class Assignment{
	static Scanner sc = new Scanner(System.in);
	static int[] die = new int[2];
	static int die1, die2;
	static int w = 0;
	static int l = 0;
	static char nxt;
	final static int stop1 = 2;
	final static int stop2 = 4;

	public static int[] dieNums(){

		System.out.println("Please type in one number between the range of 1 to 6.");
		die[0] = sc.nextInt();
		
		System.out.println("Please type in another number between the range of 1 to 6.");
		die[1] = sc.nextInt();

		if((die[0] == stop1) && (die[1] == stop2)) {
			System.out.println("You have entered the special number to end the game.");
			System.exit(0);
		}
		
		return die;
	}
	
	public static char outcome(int dieSum){
		if(dieSum == 7 || dieSum == 11) return nxt = 'A';
		else if(dieSum == 2 || dieSum == 12) return nxt = 'B';
		else return nxt = 'C'; 
	}

	public static void tryagain(int dieSum)throws Exception{
		do{
			do{
				System.out.println("Please type in one number between the range of 1 to 6.");
				die1 = sc.nextInt();
				
				System.out.println("Please type in another number between the range of 1 to 6.");
				die2 = sc.nextInt();

				if((die1 == stop1) && (die2 == stop2)) {
					System.out.println("You have entered the special number to end the game.");
					System.out.println("You have won: " + w + " times.");
					System.out.println("You have lossed: " + l + " times.");
					
					System.exit(0);
				}

				if(die1 < 1 || die1 > 6 || die2 < 1 || die2 > 6){
					System.out.println("Please enter integers between 1 and 6!");
				}
				Thread.sleep(1500);
			} while(die1 < 1 || die1 > 6 || die2 < 1 || die2 > 6);

			System.out.println("The numbers rolled were: " + die1 + " and " + die2 + ".");
			
			int num = die1 + die2;

			if(num == dieSum) {
				System.out.println("Congratulations! You've won the game.\nThe game will now restart.\n");
				w++;
				nxt = 'A';
			}
			else if(num == 7) {
				System.out.print("You've lost the game.\nThe game will now restart.\n");
				l++;
				nxt = 'B';
			}
			else {
				System.out.println("Please try again.\n");
				nxt = 'C';
				Thread.sleep(1500);
			} 
		} while(nxt == 'C');
	}
  	
  	public static void main(String[]args)throws Exception{  
		do{
			int dieSum;
			char end;

			do{
				do{
					dieNums();
					die1 = die[0];
					die2 = die[1];
				} while(die1 < 1 || die1 > 6 || die2 < 1 || die2 > 6);

				System.out.println("There numbers rolled were: " + die1 + " and " + die2 + ".");

				dieSum = die1 + die2;
				outcome(dieSum);

				if(nxt == 'A') {
					System.out.println("You have won the game! Play some more!\n");
					w++;
				}
				else if(nxt == 'B'){
					System.out.println("You have lost the game! Please try again.\n");
					l++;
				}
				else{
					System.out.println("You must continue to the next part!\n");
					Thread.sleep(2000);
				}
			} while(nxt == 'A' || nxt == 'B');
			
			tryagain(dieSum);

			Thread.sleep(1500);
		} while((die1 == stop1 && die2 == stop2) == false);
	}


}