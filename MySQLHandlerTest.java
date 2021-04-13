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
            String[] result = calculator.calculatePrices(results, "Kneeling");
            myStmt.close();
            assertEquals(expected,result[0]);
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

    //test handling multiple furniture pieces (and can make all of them)

    //test handling multiple furniture pieces (and can not make all of them)

    //test handling single furniture pieces (and can make it)

    //test handling single furniture pieces (and can not make it)
}