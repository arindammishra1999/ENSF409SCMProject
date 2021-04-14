package edu.ucalgary.ensf409;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.*;
import edu.ucalgary.ensf409.userInput;

//unit tests for project
public class userInputTest {
  
 /*  for reference only remove/ignore
    @Test
    public void testProperInputs(){
        userInput u = new userInput();
        String input = "add 5";
        u = new cat(input.getBytes());
        System.setIn(u);

        assertEquals("add 5", inputOutput.getInput());
    }
*/
  
    @Test
    public void testIncorrectTypeInput(){	
    	boolean expected = false;
        userInput incorrectType = new userInput("chair","web","1");
        assertEquals(expected,  incorrectType.checkForValidType(incorrectType));    

    }

    @Test
    public void testIncorrectCategoryInput(){
    	boolean expected= false;
        userInput incorrectCategory = new userInput("table","wood","1");
        assertEquals(expected, incorrectCategory.checkForValidCategory(incorrectCategory));  
        //say a table
    }

    @Test
    public void testForIsNumericMethod(){
    	boolean expected = true;
    	userInput random = new userInput("chair","mesh","1");	
        String[] strArray= {"10","A1","A2"};    
        assertEquals(expected, userInput.isNumeric(strArray[0]));  

    }


}

  //then add in combinations of these