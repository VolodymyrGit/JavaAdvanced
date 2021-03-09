package homeWork1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnector {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/it_system";
    private static final String USER_NAME = "postgres";
    private static final String PASS = "1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASS);
    }
}
