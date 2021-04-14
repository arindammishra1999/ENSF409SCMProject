package edu.ucalgary.ensf409;

/**
 * This class handles the printing of the orderform
 * in an output.txt file.
 * @version 1.0
 * @since 1.0
 * @author Arindam Mishra, Kaitlin Culligan, Kunal Dhawan
 */
import java.io.*;

public class Printing {

	private BufferedWriter buffWrite;
	private FileWriter fileWrite;
	private String requestString;
	private String[] itemIDs;
	private String [] suggestedManufaturers;
	private int totalCost;

	
    /**
     * This is the constructor, it just initializes the local data members
     */
 public Printing(String requestString,String[] itemIds, String[] suggestedManufaturers) {
	 this.requestString=requestString;
	 this.itemIDs=itemIds;
	 this.setSuggestedManufaturers(suggestedManufaturers);
 }
 
 /**
  * This writes the order form into an output.txt file ( if not present, it creates one)
  */
 public void writeFile() {
	 try {
		 File file = new File("output.txt");
		  if (!file.exists()) {
			     file.createNewFile();
			  }  
		  fileWrite = new FileWriter(file);
		  buffWrite=new BufferedWriter(fileWrite);
		  if(itemIDs!=null && itemIDs.length>0) {
			  
	      totalCost = Integer.parseInt(itemIDs[0]);
	      
		  buffWrite.write("Furniture order Form ->");
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.write("Faculty Name:");
		  buffWrite.newLine();
		  buffWrite.write("Contact:");
		  buffWrite.newLine();
		  buffWrite.write("Date:");
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.write("Original Request: "+requestString);
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.write("Items Ordered");
		  buffWrite.newLine();
		  for(int i=1;i<itemIDs.length;i++) {
			  buffWrite.write("ID: "+itemIDs[i]);
			  buffWrite.newLine();			  
		  }
		  buffWrite.newLine();
		  buffWrite.newLine();
		  buffWrite.write("Total Price: $"+totalCost);
		  }else {
			 buffWrite.write("Order cannot be fulfilled based on current inventory."
			 		+ "Suggested manufactures are ");
			 if(suggestedManufaturers.length==1) {
				 buffWrite.write(suggestedManufaturers[0]);
			 }else if(suggestedManufaturers.length==2){
				 buffWrite.write(suggestedManufaturers[0]+" and "+suggestedManufaturers[1] );
			 }
			 else {
			 for(int i=0;i<suggestedManufaturers.length-2;i++) {
				 buffWrite.write(suggestedManufaturers[i]+",");
		
			 }
			 buffWrite.write(suggestedManufaturers[(suggestedManufaturers.length)-2]+"and");
			 buffWrite.write(suggestedManufaturers[(suggestedManufaturers.length)-1]);
		  }			 
		  }
		  
		  System.out.println("Order form created Successfully");
		  
		  
	 }
	 
	 catch(IOException ioe){
		 ioe.printStackTrace();
	 }
		finally
		{ 
		   try{
		      if(buffWrite!=null)
			 buffWrite.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
    }
 
 /**
  * This is the getter for the suggestedManufactures array
  */

public String [] getSuggestedManufaturers() {
	return suggestedManufaturers;
}

/**
 * this is the setter for the array of suggestedManufacturers
 * @return string array of suggestedManufactures
 */
public void setSuggestedManufaturers(String [] suggestedManufaturers) {
	this.suggestedManufaturers = suggestedManufaturers;
}

}
