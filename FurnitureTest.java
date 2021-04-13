package edu.ucalgary.ensf409;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

import edu.ucalgary.ensf409.Furniture;
import edu.ucalgary.ensf409.MySQLHandler;
import jdk.jfr.Timestamp;

//unit tests for project
public class FurnitureTest {
  

  @Test
  public void testGetterForID(){
    boolean[] a = {true,false,true,false};
    Furniture f = new Furniture("mesh", "D025", 25, a);
    assertEquals("D025", f.getID());
  }

  @Test
  public void testGetterForPrice(){
    boolean[] a = {true,false,true,false};
    Furniture f = new Furniture("mesh", "D025", 25, a);
    assertEquals(25, f.getPrice());
  }

  @Test
  public void testGetterForAvailability(){
    boolean[] a = {true,false,true,false};
    Furniture f = new Furniture("mesh", "D025", 25, a);
    assertEquals(a, f.getPiecesAvailable());
  }


  @Test
  public void testGetterForType(){
    boolean[] a = {true,false,true,false};
    Furniture f = new Furniture("mesh", "D025", 25, a);
    assertEquals("mesh", f.getType());
  }
  //need to think of edge cases to test



}