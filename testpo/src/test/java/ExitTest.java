import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Random;

import static org.junit.Assert.*;

public class ExitTest {
    private Connection connection;
    String username="newuser1";
    String password="123user";
    @Before
    public void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost/TestingSoftware";
        String user = "postgres";
        String password = "d2qn5bqcl";
        connection = DriverManager.getConnection(url, user, password);

    }
    @Before
    public void logIn() throws SQLException{


    }

    @After
    public void disconnect() throws SQLException{
        connection.close();
    }


    @Test
    public void exitGoodTest() throws SQLException {
        String sql = "SELECT active FROM usr WHERE username = '"+username+"'";
        Statement statement = connection.createStatement();
        ResultSet existUser = statement.executeQuery(sql);
        assertTrue(existUser.next());
    }

    @Test
    public void exitBadTest(){

    }
}
