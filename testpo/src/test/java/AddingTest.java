import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AddingTest {
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost/TestingSoftware";
        String user = "postgres";
        String password = "d2qn5bqcl";
        connection = DriverManager.getConnection(url, user, password);
    }

    @After
    public void disconnect() throws SQLException{
        connection.close();
    }

    Random random = new Random();
    int id = random.nextInt();
    boolean active = false;
    private String username = "testuser";
    private String password = "password";

    @Test
    public void addUserTest() throws SQLException {
        String sql = "INSERT INTO usr (id, active, username, password) VALUES ("+String.valueOf(id)+","+String.valueOf(active)+",'"+username+"','"+password+"')";
        Statement statement = connection.createStatement();
        int newUser = statement.executeUpdate(sql);
        assertEquals(1,newUser);
    }
}
