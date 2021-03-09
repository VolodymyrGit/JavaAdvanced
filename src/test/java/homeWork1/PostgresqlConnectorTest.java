package homeWork1;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PostgresqlConnectorTest {

    @Test
    void getConnection() {
        try {
            Connection connection = PostgresqlConnector.getConnection();
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}