/*
*
* Author: Abrahym Sharf Eldden
* Created: September 14th, 2017
* 
* Description: This program is the first homework assignment for CISC 1115 Fall 2017. This program is meant to 
* iterate values of x -- where -3 <= x <= 3 -- through a function and state whether the value of the function
* is positive, negative or, zero. 
* 
*/

import java.util.ArrayList; // Needed to initiate the use of ArrayList
import java.util.List;	// Needed to initiate the use of List<>
import java.util.Collections; // Needed to initiate the use of Collections' methods on the array

public class Assignment{
  	public static void main(String [] args){  
		// Variable Declarations    
	    
	    double x,y;
	    List<Double> arr = new ArrayList<>();
	    
	    int naught = 0, pos = 0, neg = 0;

	    String name = "Abrahym Sharf Eldden";


	    System.out.println("\n\nHello. My name is " + name + " and this is the output of my first program!\n");
	    
	    System.out.println("TABLE OF VALUES: \n");
	    System.out.println("\t _____________________________________________\n\t|\t\t\t\t\t      |");
	    System.out.println("\t|   X\t\t  Y\t\t   STATUS     |");
	    System.out.println("\t _____________________________________________\n\t|\t\t\t\t\t      |");
	    
	    for(x = -3.0; x <= 3.0; x += 0.5) {
	      	
	      	y = ((4*x*x*x + 8*x*x - 31*x - 35) / (Math.sqrt(3*x*x + 1) + 2 * Math.abs(x - 1.5)));    

		    if (y < 0){
		    	System.out.printf("\t| " + x + "\t\t%.2f\t\t" + "Y IS NEGATIVE |\n", y);
		        neg++;

		        arr.add(y);
		    } 
		    else if(y > 0){
		        System.out.printf("\t| " + x + "\t\t%.2f\t\t" + "Y IS POSITIVE |\n", y);
		        pos++;
		        
		        arr.add(y);
		    } 
		    else {
		      	System.out.printf("\t| " + x + "\t\t%.2f\t\t" + "Y IS ZERO     |\n", y);
		      	naught++;
		    }
	    }

	    System.out.println("\t| ___________________________________________ |\n");
	    
	    System.out.println("Y is positive " + pos + " times.");
	    System.out.println("Y is negative " + neg + " times.");
	    System.out.println("Y is zero " + naught + " times.");

		for(int i = 0; i < arr.size(); i++ ){
   			arr.set(i, Math.abs(arr.get(i)));
		}
	    Collections.sort(arr);
	    System.out.printf("\nThe closest number to zero that is not zero is: %.2f\n", arr.get(0));

	    System.out.println("\n" + name + "'s first program is complete.\n");
 
	}
}