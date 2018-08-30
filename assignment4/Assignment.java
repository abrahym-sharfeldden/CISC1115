/*
 *
 * Author: Abrahym Sharf Eldden
 * Created: Tuesday, December 12th, 2017.
 *
*/

import java.util.Scanner;

public class Assignment {
	public static int nameCount = 0;
	public static int largestSum = 0;
	public static int smallestSum = 0;
	public static int sets = 0;

	public static void introduction(){
		// Receives no parameters
		// This method provides a description of what this program does.

		System.out.print("\u001B[32m"); // Changes the color of the console text to green.

		System.out.print("Hello! ");
		System.out.println("This program is going to request three integers from you.");
		System.out.println("Of the three integers you gave us, we will sum the two largest numbers.");
		System.out.println("Your name will be printed the amount of times equal to the sum unless: \n");
		System.out.println("\t 1.	The sum of the numbers given are below 0.");
		System.out.println("\t 2. 	The sum of the numbers given are above 10.");
		System.out.println("\nThe program will also compute how many of the numbers given were even.");
		System.out.println("This program will continue unless all three numbers entered are the same.");

		System.out.println("\u001B[0m \n\n"); // changes the color of the console text to the default color.
	}
	
	public static int findsum(int a, int b, int c){
		// Receives integer parameters- a, b, c- which are three entered integers from the Scanner.
		// Finds the sum of the two largest numbers provided.

		int sum = 0;

		if ((a > b && b > c) || (b > a && a > c)) sum = a + b;
		else if ((a > b && c > b) || (c > a && a > b)) sum = a + c;
		else if ((b > a && b > c) || (b > a && c > b)) sum = b + c;
		else if ((b > a && a > c) || (b > c && a > c)) sum = b + a;
		else if(a == b) sum = a + c;
		else if(a == c) sum = b + c;
		else if(b == c) sum = a + b;

		if(sum > largestSum) largestSum = sum; // keeps track of the largest sum computed by the program. This value is printed in the program's conclusion.
		if(smallestSum > sum) smallestSum = sum; // keeps track of the smallest sum computed by the program. This value is printed in the program's conclusion.

	 	return sum;
	}

	public static void printmyname(int sum){
		// Recieve integer parateter, sum, computed from the findsum() method above.
		// Prints out author's name equal to the parameter entered. 
		// If the parameter is greater than 10 or less than 0, method prints accordingly.

		if(sum > 0) {
			for (int i = 0; i <= sum ; i++ ) {
				if(sum > 10){
					System.out.println("Sum is too large.");
					break; // Ends the loop if the sum is greater than 10.
				}
				else {
					System.out.println("Abrahym Sharf Eldden");
					nameCount++; // Counts how many times the name was printed in total. This value is printed in the program's conclusion.
				}
			}
		}
		else {
			System.out.println("Sum is too small.");
		}
	} 

	public static int howmanyeven(int a, int b, int c){
		// Receives integer parameters- a, b, c- which are three entered integers from the Scanner.

		int counter = 0;

		if(a % 2 == 0) counter++;
		if(b % 2 == 0) counter++;
		if(c % 2 == 0) counter++;

		return counter;
	}

	public static void conclusion(){
		// This method prints out the conclusive statements after the game is ended.

		System.out.print("\n\u001B[32m");

		System.out.println("Total sets of three integer values submitted: " + sets + ".");
		System.out.println("Your name has been printed: " + nameCount + " times.");	
		System.out.println("The largest sum computed is: " + largestSum + ". ");
		System.out.println("The smallest sum computed is: " + smallestSum + ".");

		System.out.println("\u001B[0m"); // Changes the color of the console text to the default color.
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int sum,numEven;
		int a = 0;
		int b = 0;
		int c = 0;

		introduction(); 
		
		do{ 
			System.out.println("Please enter three integer (non-decimal) numbers below: ");
			
			a = sc.nextInt();
        	b = sc.nextInt();
        	c = sc.nextInt();

			if((a == b && b == c && a == c) == true) System.out.println("You have entered the number combination that would end the program after this iteration");
			else System.out.println("The three numbers entered were: " + a + ", " + b + ", " + c + ".");

			
			sum = findsum(a, b, c); 

			System.out.println("The largest sum possible with the numbers given is: " + sum + ".");

			printmyname(sum); 
			numEven = howmanyeven(a,b,c);

			if(numEven > 1) System.out.println("There are " + numEven + " even numbers.");
			else if(numEven == 1) System.out.println("There is 1 even number.");
			else System.out.println("There are 0 even numbers.");


			System.out.print("\n\n\n");

			sets++;
		} while((a == b && b == c && a == c) == false); // program ends if the three entered values are the same.

		conclusion();
	}
}