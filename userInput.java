package edu.ucalgary.ensf409;


/**
 * This class handles the printing of the orderform
 * in an output.txt file.
 * @version 1.0
 * @since 1.0
 * @author Arindam Mishra
 */

import java.util.Scanner;

public class userInput {
	
	private static String numberOfItems;
	private static String category;
	private static String type;
	private Printing output;
	private static Scanner scanner;
	

	public userInput() {}
	
	public static void main(String args[]) {
		
	scanner = new Scanner(System.in);  
	System.out.print("Please press the enter key after every input you give.");
	System.out.print("Please enter the furniture category, furniture type and the number of items required");
    category= scanner.nextLine();
    type=scanner.nextLine();
    numberOfItems=scanner.nextLine();
		
		
	}


	  /**
     * getter for the string type of furniture needed
     * @return String type
     */
	public String getType() {
		return type;
	}

	  /**
     * getter for the printing object that calls onto the printing class
     * to print the output form
     * @return furniture's type needed
     */

	public Printing getOutput() {
		return output;
	}

	  /**
     * getter for the string category of furniture needed
     * @return furniture's category needed
     */

	public String getCategory() {
		return category;
	}

	  /**
     * getter for the integer number of items required by the user
     * @return number of furniture pieces required
     */

	public String getNumberofItems() {
		return numberOfItems;
	}



}
