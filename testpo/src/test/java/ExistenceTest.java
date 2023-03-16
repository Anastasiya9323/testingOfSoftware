import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Random;

import static org.junit.Assert.*;
public class ExistenceTest {
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

    private String usernameExist = "testuser";
    private String usernameNotExist="nottestuser";

    @Test
    public void existUserTest() throws SQLException {
        String sql = "SELECT * FROM usr WHERE username = '"+usernameExist+"'";
        Statement statement = connection.createStatement();
        ResultSet existUser = statement.executeQuery(sql);
        assertTrue(existUser.next());
    }

    @Test
    public void notExistUserTest() throws SQLException {
        String sql = "SELECT * FROM usr WHERE username = '"+usernameNotExist+"'";
        Statement statement = connection.createStatement();
        ResultSet existUser = statement.executeQuery(sql);
        assertFalse(existUser.next());
    }

}
