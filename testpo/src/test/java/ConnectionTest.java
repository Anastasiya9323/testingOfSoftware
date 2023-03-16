import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class ConnectionTest {

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

    @Test
    public void connectTest(){
        assertNotNull(connection);
    }


}
