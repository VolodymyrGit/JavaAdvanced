package com.db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PostgresqlConnectorTest {

    @Test
    void getConnection() throws SQLException {
        Connection connection = PostgresqlConnector.getConnection();
        assertFalse(connection.isClosed());
    }
}