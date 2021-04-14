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
	
	private  String numberOfItems;
	private  String category;
	private  String type;
	private static Scanner scanner;
	private static String [] orderedItems;
	private static Printing output;

	public userInput(String category,String type, String numberOfItems) {
		this.category=category;
		this.type=type;
		this.numberOfItems=numberOfItems;
	}
	
	public static void main(String args[]) {
	
    MySQLHandler myJDBC = new MySQLHandler ("jdbc:mysql://localhost/inventory", "kunal", "ensf409");
    myJDBC.initializeConnection();
    userInput input = new userInput("","","");
	scanner = new Scanner(System.in);
	System.out.println("Please press the enter key after every input you give.");
	System.out.println("Please enter the furniture category (chair, desk, filing or lamp), furniture type and the number of items required");
    input.category= scanner.nextLine();
    input.type=scanner.nextLine();
    input.numberOfItems=scanner.nextLine();
    
    
    if(input.checkForValidCategory(input)) {
    	if(input.checkForValidType(input)) {
    	if(input.checkForInValidNumber(input)) {
    		System.out.println("Enter a number greater than 0 for the number of furniture items you require. Please run the program again and re-enter the values");
    		System.exit(0);
    	}else {
	orderedItems=myJDBC.selectFurnitureToOrder(input.category, input.type, input.numberOfItems);
    	}
    	}else {
        	System.out.println("The given type does not exist in the desired category. Please run the program again and re-enter the values");
        	System.exit(0);
    	}
    }else {
    	System.out.println("The given table does not exist in the database. Please run the program again and re-enter the values");
    	System.exit(0);
    }
    
    
	boolean isOrderedItemsID= userInput.isNumeric(orderedItems[0]);
	if(isOrderedItemsID) {
		output = new Printing(input.type+" "+input.category+", "+input.numberOfItems,orderedItems,null);
		output.writeFile();
	}else {
		output = new Printing(input.type+" "+input.category+", "+input.numberOfItems,null,orderedItems);
		output.writeFile();
	}		
	}

	
	public boolean checkForValidCategory(userInput input) {
		 if(input.category.equals("chair")||input.category.equals("desk")||input.category.equals("filing")||input.category.equals("lamp")) {
			 return true;
		 }
		 return false;
	}
	
	public boolean checkForValidType(userInput input) {
		 if(input.category.equals("chair")) {
			 if(input.type.equals("Mesh")||input.type.equals("Task")||input.type.equals("Kneeling")||input.type.equals("Executive")||input.type.equals("Ergonomic")) {
				 return true;
			 }
			 return false;
		 }
		 if(input.category.equals("desk")) {
			 if(input.type.equals("Traditional")||input.type.equals("Adjustable")||input.type.equals("Standing")) {
				 return true;
			 }
			 return false;
		 }
		 if(input.category.equals("filing")) {
			 if(input.type.equals("Small")||input.type.equals("Medium")||input.type.equals("Large")) {
				 return true;
			 }
			 return false;
		 }
		 if(input.category.equals("lamp")) {
			 if(input.type.equals("Desk")||input.type.equals("Swing Arm")||input.type.equals("Study")) {
				 return true;
			 }
			 return false;
		 }
		 return false;
	}
	public boolean checkForInValidNumber(userInput input) {
		 if(Integer.parseInt(input.numberOfItems)<1) {
			 return true;
		 }
		 return false;
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

