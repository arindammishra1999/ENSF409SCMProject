package edu.ucalgary.ensf409;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import edu.ucalgary.ensf409.MySQLHandler;

//unit tests for project
//need dbconnect getter to fix a lot of issues
public class MySQLHandlerTest {
    //test pulling manufacturers list

    //test delete function
    @Test
    public void testDelete(){
        //make a queury, delete some of the stuff, try a queury again and see if its there
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        try{
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + chair);
            String[] resultOne = calculator.calculatePrices(results, "Mesh");
            myStmt.close();
            for(int i = 1; i < resultOne.length; i++){
                sql.deleteFurniture("chair", resultOne[i]);
            }
            Statement myStmtTwo = dbConnect.createStatement();
            results = myStmtTwo.executeQuery("SELECT * FROM " + chair);
            String[] resultTwo = calculator.calculatePrices(results, "Mesh");
            myStmt.close();
            assertNotEqual(resultOne,resultTwo);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //test connection
    @Test
    public void testConnection(){
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        assertNotNull("connection is null", sql.dbConnectGet());
    }

    //go through db and find cases where this is possible
    //test handling multiple furniture pieces (and can make all of them)
    @Test
    public void testMultiplePossible(){
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        String[] one = sql.selectFurnitureToOrder("desk", "Adjustable", 2);
        assertEquals("400",one[0]); //maybe a better way to assert it works
    }
    //test handling multiple furniture pieces (and can not make all of them)
   @Test
    public void testMultipleNotPossible(){
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        String[] one = sql.selectFurnitureToOrder("desk", "Adjustable", 3);
        assert(one[1].length > 5);
    }
    //test handling single furniture pieces (and can make it)
    @Test
    public void testSinglePossible(){
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        String[] one = sql.selectFurnitureToOrder("chair", "Mesh", 1);
        assertEquals("225",one[0]);
    }
    }

    //test handling single furniture pieces (and can not make it)
    @Test
    public void testSingleNotPossible(){
        MySQLHandler sql = new MySQLHandler();
        sql.createConnection();
        String[] one = sql.selectFurnitureToOrder("chair", "Kneeling", 1);
        assert(one[1].length > 5);
    }
}