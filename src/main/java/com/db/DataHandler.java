package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHandler {


    public void checkTable(String name) throws SQLException {
        Connection connection = PostgresqlConnector.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM task");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " - " + resultSet.getString("name"));
        }
     }
}
