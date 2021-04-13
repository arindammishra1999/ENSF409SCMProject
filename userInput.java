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
	private static Scanner scanner;
	private static String [] orderedItems;
	private static Printing output;

	public userInput() {}
	
	public static void main(String args[]) {
	
    MySQLHandler myJDBC = new MySQLHandler ("jdbc:mysql://localhost/inventory", "kunal", "ensf409");
    myJDBC.initializeConnection();
	scanner = new Scanner(System.in);  
	System.out.print("Please press the enter key after every input you give.");
	System.out.print("Please enter the furniture category, furniture type and the number of items required");
    category= scanner.nextLine();
    type=scanner.nextLine();
    numberOfItems=scanner.nextLine();
	orderedItems=myJDBC.selectFurnitureToOrder(category, type, numberOfItems);
	boolean isOrderedItemsID= isNumeric(orderedItems[0]);
	if(isOrderedItemsID) {
		output = new Printing(type+" "+category+", "+numberOfItems,orderedItems,null);
		output.writeFile();
	}else {
		output = new Printing(type+" "+category+", "+numberOfItems,null,orderedItems);
		output.writeFile();
	}		
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
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
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
