import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ValidationTest {
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost/TestingSoftware";
        String user = "postgres";
        String password = "d2qn5bqcl";
        connection = DriverManager.getConnection(url, user, password);
    }

    @After
    public void disconnect() throws SQLException {
        connection.close();
    }

    Random random = new Random();
    int id = random.nextInt();
    boolean active = false;
    String usernameFalse="";
    String passwordFalse="";
    String usernameTrue="usernametest";
    String passwordTrue="passwordtest";
    @Test
    public void badValidationUsernameTest() throws SQLException {
        String sql = "INSERT INTO usr (id, active, username, password) VALUES ("+String.valueOf(id)+","+String.valueOf(active)+",'"+usernameFalse+"','"+passwordTrue+"')";
        Statement statement = connection.createStatement();
        int newUser = statement.executeUpdate(sql);
        assertEquals(0,newUser);
    }

    @Test
    public void badValidationPasswordTest() throws SQLException {
        String sql = "INSERT INTO usr (id, active, username, password) VALUES ("+String.valueOf(id)+","+String.valueOf(active)+",'"+usernameTrue+"','"+passwordFalse+"')";
        Statement statement = connection.createStatement();
        int newUser = statement.executeUpdate(sql);
        assertEquals(0,newUser);
    }

    @Test
    public void goodValidationFirstTest() throws SQLException {
        String sql = "INSERT INTO usr (id, active, username, password) VALUES ("+String.valueOf(id)+","+String.valueOf(active)+",'"+usernameTrue+"','"+passwordTrue+"')";
        Statement statement = connection.createStatement();
        int newUser = statement.executeUpdate(sql);
        assertEquals(1,newUser);
    }

    @Test
    public void goodValidationSecondTest() throws SQLException {
        String sql = "INSERT INTO usr (id, active, username, password) VALUES ("+String.valueOf(id)+","+String.valueOf(active)+",'testuser13','testpassword13')";
        Statement statement = connection.createStatement();
        int newUser = statement.executeUpdate(sql);
        assertEquals(1,newUser);
    }
}
