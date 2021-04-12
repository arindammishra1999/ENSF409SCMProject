package edu.ucalgary.ensf409;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import edu.ucalgary.ensf409.MySQLHandler;

//unit tests for project
public class CalculationsTest {
  

  //need to test when it doesnt work an produces the correct manufacturers list
  //will need one of these tests for each type of furniture

  @Test
  public void testManufacturersList(){
    int expected = 0;
    MySQLHandler sql = new MySQLHandler();
    sql.createConnection();
    int result = sql.selectFurnitureToOrder("chair", "Kneeling");
    assertEquals(expected,result);
  }
  //need a test to test if furniture is deleted from the database
  //could do this with do a queury after the delete and seeing if there
  //piece of furniture is still there

  //need to test when there is only 1 possible combination (finds the combination)


  //need to test when there are multiple combinations (finds the combination)


  //need to test that its producing the correct order form

//need to test that it selects the correct combination

  @Test
  public void testCorrectComboSelectedOne(){
    int expected = 100;
    MySQLHandler sql = new MySQLHandler();
    sql.createConnection();
    int result = sql.selectFurnitureToOrder("desk","Traditional");
    assertEquals(expected, result);
  }

  @Test
  public void testCorrectComboSelectedTwo(){
    int expected = 225;
    MySQLHandler sql = new MySQLHandler();
    sql.createConnection();
    int result = sql.selectFurnitureToOrder("chair","Task");
    assertEquals(expected, result);
  }
  //need to test that it correctly handles input values


  //need to test MySQLHandler pulls from correct table

  

  //need to test Calculations correctly ids all of the subtype

 /* @Test
  public void testFindsAllOfSubtype(){
    //think I need a getter to find this
    int number = 3;
    MySQLHandler sql = new MySQLHandler();
    sql.selectFurnitureToOrder("chair","Task");
    assertEquals(number, sql.getFurnitureArray().length);
  }*/
  //need to test that program can handle multiple furniture pieces to be built
  //and make sure if it can't meet the required amount it'll give the correct 
  //manufacturers

  //need to think of edge cases to test



}