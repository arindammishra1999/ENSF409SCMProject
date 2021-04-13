package edu.ucalgary.ensf409;
import static org.junit.Assert.assertEquals;

import org.graalvm.compiler.core.match.MatchRule;
import org.junit.Test;
import org.junit.*;
import edu.ucalgary.ensf409.MySQLHandler;

//unit tests for project
public class userInputTest {
  
    @Test
    public void testProperInputs(){
        userInput u = new userInput();


    }
  
    @Test
    public void testIncorrectTypeInput(){
        userInput u = new userInput();
        //say a web chair

    }

    @Test
    public void testIncorrectCategoryInput(){
        userInput u = new userInput();
        //say a table

    }

    @Test
    public void testIncorrectNumberInput(){
        userInput u = new userInput();
        //negative or zero

    }
  //then add in combinations of these



}